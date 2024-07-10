package com.student.csvParser.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.csvParser.service.UploadStudentCsvService;


@RestController
@RequestMapping("/api/v1/")
public class UploadStudentCsvController {
	
	private UploadStudentCsvService uploaStudentCsvService;

	@Autowired
	public UploadStudentCsvController(UploadStudentCsvService uploaStudentCsvService) {
		this.uploaStudentCsvService = uploaStudentCsvService;
	}
	
	@PostMapping("upload-student-data")
	public ResponseEntity<String> uploadStudentData(@RequestParam("file") MultipartFile file) throws IOException{
		String response = uploaStudentCsvService.uploadStudentData(file);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
}