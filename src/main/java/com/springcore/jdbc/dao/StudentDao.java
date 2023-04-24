package com.springcore.jdbc.dao;

import java.util.List;

import com.springcore.jdbc.entities.Student;

public interface StudentDao {
	
public int insert(Student student);
public int change(Student student);
public int delete(Student student);
public Student getStudent(int id);
public List<Student>getAllStudents();

}
