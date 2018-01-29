package dev.fringe.crud.config;

import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ContextProperties {

    public Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("org.hibernate.envers.audit_table_suffix", "_AUDIT_LOG");
        return  properties;
    }

}
