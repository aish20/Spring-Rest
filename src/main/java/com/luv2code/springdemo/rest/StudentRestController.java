package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define endpoint for "/students " - this will return the list of student
	
	@GetMapping("/students")
	public List<Student> getStudent()
	{
		List<Student> theStudent = new ArrayList<Student>();
		
		theStudent.add(new Student("A","B"));
		theStudent.add(new Student("X","Y"));
		theStudent.add(new Student("G","H"));
		
		
		return theStudent;
		
	}
	
	

}
