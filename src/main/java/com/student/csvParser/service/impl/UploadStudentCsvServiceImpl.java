package com.student.csvParser.service.impl;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.student.csvParser.dao.StudentRepository;
import com.student.csvParser.entity.Student;
import com.student.csvParser.request.StudentCsvDto;
import com.student.csvParser.service.UploadStudentCsvService;

@Service
public class UploadStudentCsvServiceImpl implements UploadStudentCsvService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public UploadStudentCsvServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public String uploadStudentData(MultipartFile file) throws IOException {
		
		HeaderColumnNameTranslateMappingStrategy<StudentCsvDto> strategy = new HeaderColumnNameTranslateMappingStrategy<StudentCsvDto>();
		strategy.setType(StudentCsvDto.class);
		
		// Column mapping for CSV Headers to fields in Dto
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("id", "studentId");
		mapping.put("name", "name");
		mapping.put("dept", "dept");
		mapping.put("address", "address");
		mapping.put("phoneNumber", "phoneNumber");
		
		strategy.setColumnMapping(mapping);
		
		Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CsvToBean<StudentCsvDto> csvToBean = new CsvToBeanBuilder<StudentCsvDto>(reader)
                                                .withMappingStrategy(strategy)
                                                .withIgnoreLeadingWhiteSpace(true)
                                                .build();

        List<StudentCsvDto> studentCsvDtoList = csvToBean.parse();
        
        for(StudentCsvDto studentCsvDto : studentCsvDtoList) {
        	Student student = new Student();
        	student.setStudentId(studentCsvDto.getStudentId());
        	student.setName(studentCsvDto.getName());
        	student.setDept(studentCsvDto.getDept());
        	student.setAddress(studentCsvDto.getAddress());
        	student.setPhoneNumber(studentCsvDto.getPhoneNumber());
        	
        	studentRepository.save(student);
        }
        
		return "CSV have been parsed and stored in db";
	}
	
}
