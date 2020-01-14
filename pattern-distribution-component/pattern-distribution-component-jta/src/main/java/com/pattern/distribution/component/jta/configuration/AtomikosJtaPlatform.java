package com.pattern.distribution.component.jta.configuration;

import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

/**
 * @author buildupchao
 * @date 2019/12/08 19:38
 * @since JDK 1.8
 */
@Configuration
public class AtomikosJtaPlatform extends AbstractJtaPlatform {

    private static final long serialVersionUID = 459212787417688139L;

    @Override
    @Bean(name = "atomikosTransactionManager")
    protected TransactionManager locateTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(true);
        return userTransactionManager;
    }

    @Override
    @Bean(name = "userTransaction")
    protected UserTransaction locateUserTransaction() {
        UserTransactionImp userTransactionImp = new UserTransactionImp();

        try {
            userTransactionImp.setTransactionTimeout(300);
        } catch (SystemException ex) {
            ex.printStackTrace();
        }
        return userTransactionImp;
    }

    @Bean(name = "transactionManager")
    @DependsOn({ "userTransaction", "atomikosTransactionManager" })
    public PlatformTransactionManager transactionManager() throws SystemException {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
        jtaTransactionManager.setTransactionManager(locateTransactionManager());
        jtaTransactionManager.setUserTransaction(locateUserTransaction());
        return jtaTransactionManager;
    }
}

