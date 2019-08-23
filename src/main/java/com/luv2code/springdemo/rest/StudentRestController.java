package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId)
	{
		
		// just index into the list and this will return that particular student name
		
		// check the studentId against the list size and this will throw the error 
		
		if((studentId>=theStudent.size())|| (studentId <0))
		{
			throw new StudentNotFoundException("Student id is not found = "+studentId);
		}
		return theStudent.get(studentId);
		
	}
	
	// Add an exception handler using @ExceptionHandler annotation
	
	
	// this is the exception handler method 
	
	// StudentErrorResponse is the type of response body 
	
	// StudentNotFoundException exception type to be catched or handled
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception)
	{
		// create a StudentErrorResponse 
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		error.setMessage(exception.getMessage());
		
		error.setTimestamp(System.currentTimeMillis());
		
		// return responseEntity 
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
		
		
	}
	
	

}
