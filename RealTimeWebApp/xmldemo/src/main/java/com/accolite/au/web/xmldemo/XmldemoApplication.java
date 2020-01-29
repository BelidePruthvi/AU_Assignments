package com.accolite.au.web.xmldemo;

import com.sun.net.httpserver.HttpContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class XmldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmldemoApplication.class, args);
	}

//	@Bean
//	public JdbcTemplate jdbcTemplate(){
//
//		JdbcTemplate jdbcTemplate=new JdbcTemplate();
//		jdbcTemplate.setDataSource();
//	}

}
