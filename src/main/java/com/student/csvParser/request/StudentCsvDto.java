package com.student.csvParser.request;

import com.opencsv.bean.CsvBindByPosition;

public class StudentCsvDto {

	@CsvBindByPosition(position = 0)
	private Long studentId;
	@CsvBindByPosition(position = 1)
	private String name;
	@CsvBindByPosition(position = 2)
	private String dept;
	@CsvBindByPosition(position = 3)
	private String address;
	@CsvBindByPosition(position = 4)
	private String phoneNumber;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
