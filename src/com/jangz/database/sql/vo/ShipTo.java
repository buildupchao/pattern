package com.jangz.database.sql.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import com.jangz.database.util.DBUtil;

public class ShipTo {

	private Integer shipToId;
	private Timestamp shipToDate;

	public ShipTo() {
	}

	public ShipTo(Integer shipToId, Timestamp shipToDate) {
		this.shipToId = shipToId;
		this.shipToDate = shipToDate;
	}

	public ShipTo selectById(Integer shipToId) throws SQLException {
		String sql = "select ship_to_date from ship_to where ship_to_id=?";
		
		Connection conn = DBUtil.getConnction();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1);
		
		ResultSet rs = pstmt.executeQuery();
		Timestamp date = null;
		if (rs.next()) {
			date = rs.getTimestamp(1);
		}

		return new ShipTo(1, date);
	}
	
	public int insert(ShipTo shipTo) throws SQLException {
		String sql = "insert into ship_to(ship_to_date) value(?)";
		
		Connection conn = DBUtil.getConnction();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setTimestamp(1, shipTo.shipToDate);
		
		return pstmt.executeUpdate();
	}

	public static void main(String[] args) throws SQLException {
//		System.out.println(new ShipTo().selectById(1));
		ShipTo shipTo = new ShipTo(null, Timestamp.from(Instant.now()));
		System.out.println(shipTo.insert(shipTo));
	}

	@Override
	public String toString() {
		return "ShipTo [shipToId=" + shipToId + ", shipToDate=" + shipToDate + "]";
	}
}
