package com.pattern.distribution.component.jta.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author buildupchao
 * @date 2019/12/08 19:39
 * @since JDK 1.8
 */
@Configuration
public class DataSourceConfiguration {

    @Primary
    @Bean(name = "primaryDataSource")
    @ConfigurationProperties("spring.jta.atomikos.datasource.primary")
    public DataSource primaryDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "secondaryDataSource")
    @ConfigurationProperties("spring.jta.atomikos.datasource.secondary")
    public DataSource secondaryDataSource() {
        return new AtomikosDataSourceBean();
    }
}
