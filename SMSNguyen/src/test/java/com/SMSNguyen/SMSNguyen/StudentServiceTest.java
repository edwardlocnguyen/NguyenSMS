package com.SMSNguyen.SMSNguyen;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class StudentServiceTest {
	private StudentService studentService;

	@Before
	public void setUp() {
		studentService = new StudentService();
	}

	@Test
	public void testGetStudentByEmail() {
//		Given
		String email = "mslewis@gmail.com";
		Student expectedStudent = new Student("mslewis@gmail.com", "LaTonya Lewis", "mslewisrocks", null);
//		When
		Student actualStudent = studentService.getStudentByEmail(email);
//		Then
		assertEquals(expectedStudent.getsEmail(), actualStudent.getsEmail());
	}

}
