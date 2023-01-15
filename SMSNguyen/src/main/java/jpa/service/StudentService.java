package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.util.HibernateUtil;

public class StudentService extends HibernateUtil implements StudentDAO {

	@Override
	public List<Student> getAllStudents() {
		Session session = HibernateUtil.getConnection();
		String statement = "From Student";
		TypedQuery<Student> query = session.createQuery(statement, Student.class);
		List<Student> studentList = query.getResultList();
		for (Student eachStudent : studentList) {
			System.out.println("Student Email: " + eachStudent.getsEmail());
			System.out.println("Student Name: " + eachStudent.getsName());
			System.out.println("Student Pass: " + eachStudent.getsPass());
			System.out.println("");
		}
		session.close();
		return studentList;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		Session session = HibernateUtil.getConnection();
		String statement = "FROM Student s WHERE s.sEmail = :sEmail";
		TypedQuery<Student> query = session.createQuery(statement, Student.class);
		query.setParameter("sEmail", sEmail);
		Student student = query.getSingleResult();
		System.out.println("Student Email: " + student.getsEmail());
		System.out.println("Student Name: " + student.getsName());
		System.out.println("Student Pass: " + student.getsPass());
		session.close();
		return student;
	}

	@Override
	public boolean validateStudent(String sEmail, String sPass) {
		Session session = HibernateUtil.getConnection();
		String statement = "FROM Student s WHERE s.sEmail = :sEmail AND s.sPass = :sPass";
		TypedQuery<Student> query = session.createQuery(statement, Student.class);
		query.setParameter("sEmail", sEmail);
		query.setParameter("sPass", sPass);
		List<Student> students = query.getResultList();
		if (!students.isEmpty()) {
			Student student = students.get(0);
			System.out.println(" Login Successful");
			System.out.println(" Hello " + student.getsName());
			session.close();
			return true;
		} else {
			System.out.println(" Login Failed");
			session.close();
			return false;
		}

	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		Session session = HibernateUtil.getConnection();
		session.beginTransaction();
//		.get(class type of obj, pk of obj)
		Student student = (Student) session.get(Student.class, sEmail);
		Course course = (Course) session.get(Course.class, cId);
//		student.getsCourses() returns a List<Course> of Course objs
		if (!student.getsCourses().contains(course)) {
			student.getsCourses().add(course);
			session.save(student);
			session.getTransaction().commit();
			System.out.println("\n Success! You registered to the course! \n");
		} else {
			System.out.println("\n Fail! You are already registered in that course! \n");
		}
		List<Course> courses = student.getsCourses();
		System.out.println(" My Classes: \n");
		System.out.println(" ID | COURSE NAME | INSTRUCTOR NAME");
		for (Course eachCourse : courses) {
			System.out.println(" " + eachCourse.getcId() + " | " + eachCourse.getcName() + " | "
					+ eachCourse.getcInstructorName());
		}
		session.close();
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		Session session = HibernateUtil.getConnection();
		Student student = (Student) session.get(Student.class, sEmail);
		List<Course> courses = student.getsCourses();
		System.out.println(" My Classes: \n");
		System.out.println(" ID | COURSE NAME | INSTRUCTOR NAME");
		for (Course eachCourse : courses) {
			System.out.println(" " + eachCourse.getcId() + " | " + eachCourse.getcName() + " | "
					+ eachCourse.getcInstructorName());
		}
		session.close();
		return courses;
	}

}
