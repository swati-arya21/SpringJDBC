package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
       // ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
       StudentDao stud =  context.getBean("studentDao", StudentDao.class);
        
       // ********Insert querry
 /*  Student student = new Student();
        student.setId(1113);
        student.setName("Vishnu");
        student.setCity("Vaikundh Dham");
            
        int result = stud.insert(student);
        System.out.println("No of records inserted = "+result);*/
      
       //******** Update querry
  /*     Student student = new Student();
       student.setId(1113);
       student.setName("Radha");
       student.setCity("Barsana");
       
       int result = stud.change(student);
       System.out.println("Data changed " +result); */
        
        //********** Delete Query
        
       //Student student = new Student();
       //student.setId(1113);
             //int r = stud.delete(114);
            //System.out.println("Deleted record=" +r);
       
       //***************Select Query
         
       /* Student student = stud.getStudent(112);
        System.out.println(student);*/
       
        
        List<Student> student = stud.getAllStudent();
        for(Student s:student)
        {
        	System.out.println(s);
        }
        
       
    /*    JdbcTemplate template=context.getBean("jdbcTemplate", JdbcTemplate.class);
       // insert query
        String query ="insert into student(id,name,city) values(?,?,?)";
        //fire query
        int result = template.update(query,114,"Kartikaye","Kailash");
        
        System.out.println("No of record inserted = "+result);
    	*/
        
    }
}
