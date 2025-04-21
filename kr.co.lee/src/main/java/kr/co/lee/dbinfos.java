package kr.co.lee;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//JPA
@Configuration  //환경설정  => Config.xml
//properties 파일을 로드 할 수 있도록 하는 어노테이션
@PropertySource("classpath:/application.properties") 
public class dbinfos {
/*
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	@Bean
  public DataSource mysqldb() {	  
	  return DataSourceBuilder.create().build();
  }
*/	
	
}
