package ru.springdata;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/datasource.properties")
public class DataConfig {

	
	@Value("${data.url}")
	private String url;
	
	@Value("${data.username}")
	private String username;
	
	@Value("${data.password}")
	private String password;
	
	@Value("${data.driver}")
	private String driver;
	
	
	@Bean
	public DataSource dataSource() {
				
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
		    }
	
	
}
