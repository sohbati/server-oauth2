package com.rsp.myserver.configuration.database;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactory",
    transactionManagerRef = "secondTransactionManager", basePackages = {"com.rsp.myserver.persistence.second.repository"})
public class SecondDbConfig {

  @Bean(name = "secondDataSource")
  @ConfigurationProperties(prefix = "second.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "secondEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
          EntityManagerFactoryBuilder builder, @Qualifier("secondDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("com.rsp.myserver.persistence.second.entity").
            persistenceUnit("second").build();
  }

  @Bean(name = "secondTransactionManager")
  public PlatformTransactionManager secondTransactionManager(
      @Qualifier("secondEntityManagerFactory") EntityManagerFactory secondEntityManagerFactory) {
    return new JpaTransactionManager(secondEntityManagerFactory);
  }

}
