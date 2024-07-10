package com.student.csvParser.response;

import java.util.List;

import com.student.csvParser.entity.Student;

public class StudentPaginationResponse {
	private int pageNo;
	private int pageSize;
	private long pageCount;
	List<Student> studentList;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public List<Student> getstudentList() {
		return studentList;
	}

	public void setstudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
