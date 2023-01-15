package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.util.HibernateUtil;

public class CourseService extends HibernateUtil implements CourseDAO {

	@Override
	public List<Course> getAllCourses() {
		Session session = HibernateUtil.getConnection();
		String statement = "FROM Course";
		TypedQuery<Course> query = session.createQuery(statement, Course.class);
		List<Course> courses = query.getResultList();
		System.out.println(" \n All Courses: \n");
		System.out.println(" ID | COURSE NAME | INSTRUCTOR NAME");
		for (Course eachCourse : courses) {
			System.out.println(" " + eachCourse.getcId() + " | " + eachCourse.getcName() + " | "
					+ eachCourse.getcInstructorName());
		}
		session.close();
		return courses;
	}

}
