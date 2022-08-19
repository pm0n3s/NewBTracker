package com.NewBornTracker.config;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ComponentScan({ "com.NewBornTracker" })
//@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.NewBornTracker.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
    
    @Bean 
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:tcp://localhost:9090/mem:db");
    	dataSource.setUsername("sa");
    	dataSource.setPassword("");
    	return dataSource;
    }
    

//	@Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//            .generateUniqueName(false)
//            .setName("testdb")
//            .setType(EmbeddedDatabaseType.H2)
//            .setScriptEncoding("UTF-8")
//            .ignoreFailedDrops(true)
//            .build();
//    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");
        return properties;        
    }
    
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
    	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    	transactionManager.setSessionFactory(sessionFactory().getObject());
    	return transactionManager;
    }
    

//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory s) {
//       HibernateTransactionManager txManager = new HibernateTransactionManager();
//       txManager.setSessionFactory(s);
//       return txManager;
//    }
}