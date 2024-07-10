package com.student.csvParser.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadStudentCsvService {

	String uploadStudentData(MultipartFile file) throws FileNotFoundException, IOException;

}
