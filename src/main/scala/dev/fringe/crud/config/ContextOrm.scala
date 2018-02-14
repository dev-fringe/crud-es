package dev.fringe.crud.config

import java.util.Properties
import javax.sql.DataSource

import dev.fringe.crud.service.CrudService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.{HibernateJpaDialect, HibernateJpaVendorAdapter}

@Configuration
class ContextOrm  @Autowired()(dataSource : DataSource , properties:Properties) {
  @Bean def entityManagerFactory: LocalContainerEntityManagerFactoryBean = {
    val em = new LocalContainerEntityManagerFactoryBean
    em.setDataSource(dataSource)
    em.setPackagesToScan("dev.fringe.crud.model")
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter)
    em.setJpaDialect(new HibernateJpaDialect)
    em.setJpaProperties(properties)
    em.setPersistenceXmlLocation("classpath*:persistence.xml")
    em
  }
}
