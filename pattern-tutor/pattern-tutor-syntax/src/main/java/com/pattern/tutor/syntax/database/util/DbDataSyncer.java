package com.pattern.tutor.syntax.database.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import junit.framework.Assert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class DbDataSyncer {

	private static final Logger LOGGER = LoggerFactory.getLogger(DbDataSyncer.class);
	
	private String fileOutputPath;
	
	private static final LinkedBlockingQueue<String> SQL_QUEUE = Queues.newLinkedBlockingQueue();

	public DbDataSyncer(String fileOutputPath) {
		this.fileOutputPath = fileOutputPath;
	}

	public void syncData(Connection conn, String tableName, String condition, List<String> columnNames) {
		Assert.assertNotNull(conn);
		Assert.assertNotNull(tableName, "tableName cannot be null!");
		Assert.assertNotNull(columnNames);

		String selectedColumnNames = Joiner.on(",").join(columnNames);
		String sql = String.format("SELECT %s FROM %s WHERE %s ", selectedColumnNames, tableName, condition);
		
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				StringBuffer insertSql = new StringBuffer();
				insertSql.append("INSERT INTO ")
						 .append(tableName)
						 .append(" (").append(selectedColumnNames).append(") VALUES(");
				for (int i = 0; i < columnNames.size(); i++) {
					String columnTypeName = metaData.getColumnTypeName(i + 1);
					Object value = rs.getObject(i);
					if (value != null) {
						if (needQuotes(columnTypeName)) {
							insertSql.append("'").append(value.toString()).append("'");
						} else {
							insertSql.append(value.toString());
						}
					} else {
						insertSql.append("null");
					}
					insertSql.append(",");
				}
				String finalSql = insertSql.substring(0, insertSql.lastIndexOf(",")).concat(");");
				SQL_QUEUE.put(finalSql);
			}
		} catch (Exception ex) {
			LOGGER.error("sync data error!", ex);
		} finally {
			DBUtil.close(null, statement, rs);
		}
	}
	
	private boolean needQuotes(String columnTypeName) {
		boolean isNeedQuotes = false;
		String lowerColumnTypeName = columnTypeName.toLowerCase();
		isNeedQuotes = lowerColumnTypeName.contains("varchar") || lowerColumnTypeName.contains("char")
				|| lowerColumnTypeName.contains("date") || lowerColumnTypeName.contains("datetime");
		return isNeedQuotes;
	}
	
	public void startSyncSqlConsumer() {
		SyncSqlConsumer syncSqlConsumer = new SyncSqlConsumer(fileOutputPath);
		syncSqlConsumer.setName("sync-sql-consumer");
		syncSqlConsumer.start();
	}
	
	static class SyncSqlConsumer extends Thread {
		
		private String fileOutputPath;
		
		private volatile boolean stop = false;
		
		public SyncSqlConsumer(String fileOutputPath) {
			super();
			this.fileOutputPath = fileOutputPath;
		}

		@Override
		public void run() {
			System.out.println("SyncSqlConsumer started...");
			
			String fileName = UUID.randomUUID().toString() + ".data";
			String fullFilePath = fileOutputPath + "/" + fileName;
			System.out.printf("Created file=[%s], filepath=[%s]\n", fileName, fullFilePath);
			FileWriter writer = null;
			try {
				writer = new FileWriter(new File(fullFilePath), true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			while (true) {
				if (stop) {
					break;
				}
				try {
					String sql = SQL_QUEUE.take();
					writer.write(sql);
					writer.write("\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			IOUtils.closeQuietly(writer);
		}

		public void setStop(boolean stop) {
			this.stop = stop;
		}
	}
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	static class SyncTableInfo {
		private String tableName;
		private List<String> columnNames;
		private String condition;
	}
	
	public static void main(String[] args) throws IOException {
		List<SyncTableInfo> syncTableInfos = Lists.newArrayList();
		syncTableInfos.add(SyncTableInfo.builder()
				.tableName("report_config")
				.columnNames(Arrays.asList("id", "title", "status", "time_grain", "create_user_id", "create_time", "modify_user_id", "modify_time", "description"))
				.build()
		);
		syncTableInfos.add(SyncTableInfo.builder()
				.tableName("config_set")
				.columnNames(Arrays.asList("id", "config_id", "type", "name", "source_database_id", "left_op", "operator", "right_op"))
				.build()
		);
		syncTableInfos.add(SyncTableInfo.builder()
				.tableName("config_column")
				.columnNames(Arrays.asList("id", "config_id", "config_set_id", "column_as_name", "column_title", "is_group"))
				.build()
		);
		syncTableInfos.add(SyncTableInfo.builder()
				.tableName("config_table")
				.columnNames(Arrays.asList("id", "config_id", "config_set_id", "source_table_id", "source_table_name"))
				.build()
		);
		syncTableInfos.add(SyncTableInfo.builder()
				.tableName("config_sql")
				.columnNames(Arrays.asList("id", "config_id", "config_set_id", "sql_no", "sql_str"))
				.build()
		);
		syncTableInfos.add(SyncTableInfo.builder()
				.tableName("config_time_clause")
				.columnNames(Arrays.asList("id", "config_id", "config_set_id", "type", "pattern_type", "pattern_str", "start_replace_str", "end_replace_str", "custom_value"))
				.build()
		);
		
		String workspace = System.getProperty("user.dir");
		String base = "src/main/java/com/pattern/tutor/syntax/database";
		String fileOutputPath = workspace + "/" + base;
		DbDataSyncer dbDataSyncer = new DbDataSyncer(fileOutputPath);
		dbDataSyncer.startSyncSqlConsumer();
		
		// jdbc.properties
		Connection conn = new DbHelper(fileOutputPath).connect();
		Assert.assertNotNull(conn);
		System.out.println(conn.toString());
		
//		for (SyncTableInfo syncTableInfo : syncTableInfos) {
//			dbDataSyncer.syncData(conn, syncTableInfo.getTableName(), syncTableInfo.getCondition(), syncTableInfo.getColumnNames());
//		}
	}
}
