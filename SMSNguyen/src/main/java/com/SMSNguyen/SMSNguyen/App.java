package com.SMSNguyen.SMSNguyen;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jpa.service.CourseService;
import jpa.service.StudentService;
import jpa.util.HibernateUtil;

public class App {
	static Session session = HibernateUtil.getConnection();
	static Transaction t = session.beginTransaction();

	public static void main(String[] args) {
		SMSRunner runner = new SMSRunner();
		runner.runProgram();

//		StudentService studentServiceObj = new StudentService();
//		studentServiceObj.getAllStudents();

	}
}