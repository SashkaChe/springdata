package ru.springdata;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@PropertySource("classpath:/datasource.properties")
@Import(DataConfig.class)
@ComponentScan(basePackages = "ru.springdata")
@EnableTransactionManagement
public class EntityConfig {

	@Resource
	private DataSource dataSource;

	@Bean 
	public PlatformTransactionManager transactionManager() { 
	return new JpaTransactionManager(entityFactory());
	}

	
	
	@Bean 
	public JpaVendorAdapter jpaVendorAdapter() { 
	return new HibernateJpaVendorAdapter(); 
}
			
	
	@Bean
	@Primary
	public EntityManagerFactoryAccessor entityFactory() {
	
		
	//	Properties hibernateProperties = new Properties();
	 //   hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
	    
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean(); 
        factoryBean.setDataSource(dataSource); 
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter()); 
        factoryBean.setPackagesToScan("ru.springdata"); 
        
    //    factoryBean.setJpaProperties(hibernateProperties); 
        
        factoryBean.afterPropertiesSet(); 
      
        return factoryBean.getNativeEntityManagerFactory(); 

		    }

	
}
