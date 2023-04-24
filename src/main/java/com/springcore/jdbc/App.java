package com.springcore.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springcore.jdbc.dao.StudentDao;
import com.springcore.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("My program started.......");
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcCofig.class);
		
		StudentDao studentDao =  ctx.getBean("studentDao", StudentDao.class);
	    
		/*
		 * Student student = new Student(); student.setId(666); student.setName("john");
		 * student.setCity("Chandigarh");
		 * 
		 * int result = studentDao.insert(student); System.out.println("srudent added "
		 * + result);
		 */
		
		
		
		List<Student> students = studentDao.getAllStudents();
		
		for(Student s : students)
		System.out.println(s);
		
		
		
		
		
		
		
		// spring jdbc => JdbcTemplate

		/*
		 * ApplicationContext ctx = new
		 * ClassPathXmlApplicationContext("springJdbc.xml"); StudentDao studentDao =
		 * ctx.getBean("studentDao", StudentDao.class);
		 * 
		 * 
		 * Student student = new Student(); student.setId(234);
		 * student.setName("Shreya"); student.setCity("hosiyarpur");
		 * 
		 * int result = studentDao.insert(student);
		 * System.out.println("Student added"+result);
		 * 
		 * 
		 * //UPDATE
		 * 
		 * Student student = new Student(); student.setId(234);
		 * student.setName("verma"); student.setCity("Delhi"); int result =
		 * studentDao.change(student);
		 * 
		 * System.out.println("Data is changed " +result);
		 * 
		 * 
		 * //DELETE
		 * 
		 * Student student = new Student(); student.setId(234); int result =
		 * studentDao.delete(student); System.out.println("one data has been deleted " +
		 * result);
		 * 
		 * 
		 * Student student = studentDao.getStudent(222); System.out.println(student);
		 * 
		 * 
		 * List<Student> students = studentDao.getAllSrudents(); for(Student st :
		 * students) System.out.println(st);
		 */

	}
}
