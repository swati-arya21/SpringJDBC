package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student)
	{
		// insert querry
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(), student.getCity());
		return r;
	}
	public int change(Student student)
	{
		// Update query
		String query = "update student set name=?, city=? where id=?";
	    int r =this.jdbcTemplate.update(query, student.getName(),student.getCity(), student.getId());
		return r;
	}
   public int delete(int studentId)
   {
	   // Delete querry
	    String query = "Delete from student where id=?";
	    int r = this.jdbcTemplate.update(query,studentId);
	   return r;
   }
   public Student getStudent(int studentId)
   {
	   // Select querry 
	   String querry = "select * from student where id=?";
	   RowMapper<Student> rowMapper = new RowMapperImpl();
	   Student student= this.jdbcTemplate.queryForObject(querry,rowMapper,studentId);
	   return student;
   }
   public List<Student> getAllStudent()
   {
	   // Select all query
	   String query = "select * from student";
	   List<Student> student = this.jdbcTemplate.query(query,new RowMapperImpl());
	   return student;
   }
}
