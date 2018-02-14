package dev.fringe.crud.config

import java.util.Properties

import org.springframework.context.annotation.{Bean, Configuration}

@Configuration class ContextProperties {
  @Bean def properties: Properties = {
    val properties = new Properties
    properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
    properties.put("hibernate.show_sql", "true")
    properties.put("hibernate.hbm2ddl.auto", "create")
    properties.put("org.hibernate.envers.audit_table_suffix", "_AUDIT_LOG")
    properties
  }
}