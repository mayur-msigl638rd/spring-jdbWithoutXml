package com.springcore.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springcore.jdbc.entities.Student;

public class StudentDaoImp implements StudentDao  {

	private JdbcTemplate jdbcTemplate;

	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stubString query = "insert into student(id,name,city) values(?,?,?)";
		 String query = "insert into student(id,name,city) values(?,?,?)"; 
		 int r =  this.jdbcTemplate.update(query, student.getId(), student.getName(),student.getCity());
		 return r;
		
	}

	public int change(Student student) {
		//updating data
		
		String query = "update student set name = ? , city = ? where id =?";
		int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(Student student) {
		String query = "delete from student where id = ?";
		int result = this.jdbcTemplate.update(query , student.getId());
		return result;
	}

	public Student getStudent(int id) {
		//select single student data
		
		String query = "select * from student where id =?";
		RowMapper<Student>rowMapper = new RowMapperImpl(); // we need to design "RowMapperImp ourself"
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,id );
		
		return student;
	}

	public List<Student> getAllStudents() {
		String query = "Select * from student";
		RowMapper<Student>rowMapper = new RowMapperImpl();
		List<Student> students= this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	
	}
	


