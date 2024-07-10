package com.student.csvParser.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.csvParser.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	

}
