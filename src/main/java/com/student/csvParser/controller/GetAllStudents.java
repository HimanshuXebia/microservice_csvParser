package com.student.csvParser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.csvParser.response.StudentPaginationResponse;
import com.student.csvParser.service.StudentDataService;

@RestController
@RequestMapping("/api/v1")
public class GetAllStudents {
	
	private final StudentDataService studentDataService;
	
	@Autowired
	public GetAllStudents(StudentDataService studentDataService) {
		this.studentDataService = studentDataService;
	}


	// Fetch all users
	@GetMapping("/")
	ResponseEntity<StudentPaginationResponse> getAllStudents(
			@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
		
		StudentPaginationResponse response = studentDataService.getAllStudents(pageNumber, pageSize);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
