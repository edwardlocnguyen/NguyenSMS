package com.NguyenSMS.NguyenSMS;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jpa.service.CourseService;
import jpa.service.StudentService;
import jpa.util.HibernateUtil;

public class App {
	static Session session = HibernateUtil.getConnection();
	static Transaction t = session.beginTransaction();

	/**
	 * 
	 * How to run this program:
	 * 
	 * 1 - Open NguyenSMS/hibernate.cfg.xml
	 * 2 - Update the connection url, username, and password to the database in your local computer accordingly
	 * 
	 * 3 - Open NguyenSMS/src/main/java/com.NguyenSMS.NguyenSMS/App.java
	 * 4 - Run Java Application
	 * 5 - Follow instructions printed in the console
	 * 
	 * Notes: Instructions will prompt you to run the two SQL scripts that are
	 * attached in this repo. Run the scrips in MySQLWorkbench.
	 * 
	 * 
	 * How to run the test:
	 * 
	 * 1 - Open NguyenSMS/src/test/java/com.NguyenSMS.NguyenSMS/StudentServiceTest.java
	 * 2 - Run Junit Test
	 * 
	 */

	public static void main(String[] args) {
		SMSRunner runner = new SMSRunner();
		runner.runProgram();

//		StudentService studentServiceObj = new StudentService();
//		studentServiceObj.getAllStudents();

	}
}