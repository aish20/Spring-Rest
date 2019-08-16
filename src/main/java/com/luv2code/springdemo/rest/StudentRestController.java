package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudent ;
	
	// define endpoint for "/students " - this will return the list of student
	
	@PostConstruct
	public void loadData()
	
	{
		
		System.out.println("I am loaddata");
theStudent = new ArrayList<Student>();
		
		theStudent.add(new Student("A","B"));
		theStudent.add(new Student("X","Y"));
		theStudent.add(new Student("G","H"));
		System.out.println("I have loaded data");
		
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudent()
	{
	     return theStudent;
		
	}
	
	

}
