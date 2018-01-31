package dev.fringe.crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ContextOrm {

    @Autowired private DataSource dataSource;
    @Autowired private Properties properties;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("dev.fringe.crud.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaDialect(new HibernateJpaDialect());
        em.setJpaProperties(properties);
        em.setPersistenceXmlLocation("classpath*:persistence.xml");
        return em;
    }
//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(ds.dataSource());
//        sessionFactory.setPackagesToScan("dev.fringe.crud.model");
//        sessionFactory.setHibernateProperties(prop.properties());
//        return sessionFactory;
//    }
}
