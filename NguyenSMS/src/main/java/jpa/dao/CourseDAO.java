package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
/**
 * 
 * This interface lists the methods that can be implemented in the CourseService class
 *
 */
public interface CourseDAO {

	List<Course> getAllCourses();

}
