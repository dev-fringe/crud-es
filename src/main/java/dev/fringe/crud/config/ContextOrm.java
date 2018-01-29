package dev.fringe.crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class ContextOrm {

    @Autowired private ContextDataSource ds;
    @Autowired private ContextProperties prop;

//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(ds.dataSource());
//        sessionFactory.setPackagesToScan("dev.fringe.crud.model");
//        sessionFactory.setHibernateProperties(prop.properties());
//        return sessionFactory;
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(ds.dataSource());
        em.setPackagesToScan("dev.fringe.crud.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaDialect(new HibernateJpaDialect());
        em.setJpaProperties(prop.properties());
        em.setPersistenceXmlLocation("classpath*:persistence.xml");
        return em;
    }
}
