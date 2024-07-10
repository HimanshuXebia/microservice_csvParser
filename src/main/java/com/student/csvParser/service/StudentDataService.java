package com.student.csvParser.service;

import com.student.csvParser.response.StudentPaginationResponse;

public interface StudentDataService {
	
	StudentPaginationResponse getAllStudents(Integer pageNumber, Integer pageSize);
}
