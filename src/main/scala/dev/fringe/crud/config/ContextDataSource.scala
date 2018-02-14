package dev.fringe.crud.config

import javax.sql.DataSource

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class ContextDataSource {

  @Bean def dataSource: DataSource = {
    val dataSource = new BasicDataSource
    dataSource.setDriverClassName("org.hsqldb.jdbcDriver")
    dataSource.setUrl("jdbc:hsqldb:mem:fringe")
    dataSource.setUsername("sa")
    dataSource.setPassword("")
    dataSource
  }
}
