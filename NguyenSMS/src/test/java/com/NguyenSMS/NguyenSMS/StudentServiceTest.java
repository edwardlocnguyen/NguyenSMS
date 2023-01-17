package com.NguyenSMS.NguyenSMS;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import jpa.entitymodels.Student;
import jpa.service.StudentService;
/**
 * 
 * This test class contains a test method called testGetStudentByEmail
 * This test method is testing a method called getStudentByEmail, which is defined in the StudentService class
 *
 */
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
