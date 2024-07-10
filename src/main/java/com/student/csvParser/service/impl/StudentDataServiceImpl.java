package com.student.csvParser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.student.csvParser.dao.StudentRepository;
import com.student.csvParser.entity.Student;
import com.student.csvParser.response.StudentPaginationResponse;
import com.student.csvParser.service.StudentDataService;

@Service
public class StudentDataServiceImpl implements StudentDataService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentDataServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}



	@Override
	public StudentPaginationResponse getAllStudents(Integer pageNumber, Integer pageSize) {
		StudentPaginationResponse response = new StudentPaginationResponse();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> studentPage = studentRepository.findAll(pageable);
		response.setPageNo(pageNumber);
		response.setPageSize(pageSize);
		response.setPageCount(studentPage.getTotalElements());
		response.setstudentList(studentPage.getContent());
		return response;
	}

}
