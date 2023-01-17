package com.NguyenSMS.NguyenSMS;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;
/**
 * 
 * The methods in SMSRunner are invoked in App.java
 * These methods can trigger each other, depending on the option choices that the user submits in the console
 * A user can login, see their courses, and register for a course
 * 
 */
public class SMSRunner {

	StudentService studentServiceObj = new StudentService();
	CourseService courseServiceObj = new CourseService();
	private String sEmail;
	private String sPass;
	Scanner scanner = new Scanner(System.in);

	public void runProgram() {
		System.out.println(
				"\n Hi Ms. Lewis, please make sure to load both SQL scripts from my zip file before continuing. \n Then enter 1 or 2. \n");
		System.out.println(
				" 1. Continue, I have already ran both SQL scripts \n 2. Quit, I have not ran the SQL scripts yet");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		if (userInput == 1) {
			studentLogin();
		} else {
			System.out.println(
					"\n Please load both SQL scripts from my zip file onto 'smsdb' in your MySQLWorkbench, and then re-run this program");
		}
	}

	public void studentLogin() {
		System.out.println("Are you a(n): \n 1. Student \n 2. Quit \n Please, enter 1 or 2.");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		if (userInput == 1) {
			System.out.println("Enter Your Email (you can use 'mslewis@gmail.com' for ease)");
			sEmail = scanner.nextLine();
			System.out.println("Enter Your Password (you can use 'mslewisrocks' for ease)");
			sPass = scanner.nextLine();
			boolean isValidStudent = studentServiceObj.validateStudent(sEmail, sPass);
			if (isValidStudent) {
				showStudentCourses(sEmail);
			}
		} else {
			System.out.println("\n You have been signed out");
		}

	}

	public void showStudentCourses(String sEmail) {
		studentServiceObj.getStudentCourses(sEmail);
		System.out.println("\n 1. Register to Class \n 2. Logout");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		if (userInput == 1) {
			courseServiceObj.getAllCourses();
			registerCourse();
		} else {
			System.out.println("\n You have been signed out");
		}
	}

	public void registerCourse() {
		System.out.println("\n Enter a course ID number: ");
		int userInput = scanner.nextInt();
		List<Course> courses = courseServiceObj.getAllCourses();
		boolean isValidCourse = false;
		for (Course eachCourse : courses) {
			if (eachCourse.getcId() == userInput) {
				isValidCourse = true;
				break;
			}
		}
		if (isValidCourse) {
			studentServiceObj.registerStudentToCourse(sEmail, userInput);
			System.out.println("\n You have been signed out");
		} else {
			System.out.println("\n Please enter a valid course ID");
			registerCourse();
		}
	}

}
