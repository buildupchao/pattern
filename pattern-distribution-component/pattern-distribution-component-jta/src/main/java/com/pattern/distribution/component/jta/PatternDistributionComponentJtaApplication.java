package com.pattern.distribution.component.jta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author buildupchao
 */
@EnableTransactionManagement
@SpringBootApplication
public class PatternDistributionComponentJtaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatternDistributionComponentJtaApplication.class, args);
    }
}
