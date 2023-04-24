package com.springcore.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.jdbc.dao.StudentDao;
import com.springcore.jdbc.dao.StudentDaoImp;

@Configuration
public class JdbcCofig {

	@Bean("ds")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("your username");
		ds.setPassword("Your password");
		
		return ds;
		
		
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}  
	
	@Bean("studentDao")
	public StudentDao getStudentDao()
	{
		StudentDaoImp studentDao = new StudentDaoImp();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
		
	}
	
}
