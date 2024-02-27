package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(342, "Java Course", "This course is to describe the Java in depth", 18549.99));
		list.add(new Course(923, "Spring Boot Course", "This course is to describe the Sprin Boot in depth", 15999.99));
		list.add(new Course(127, "Angular Course", "This course is to describe the Angular in depth", 11999.99));
		list.add(new Course(003, "Database Course", "This course is to describe the Database(MySQL) in depth", 17949.99));
		list.add(new Course(245, "Devops Course", "This course is to describe the DevOps in depth", 25999.99));
	}
	
	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long id) {
		Course c=null;
		
		for(Course course: list) {
			if(course.getId()==id) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course newCourse) {
		for(Course course: list) {
			if(course.getId()==newCourse.getId()) {
				list.remove(course);
				list.add(newCourse);
				break;
			}
		}
		return newCourse;
	}

	@Override
	public void deleteCourse(long courseId) throws Exception {
		for(Course course: list) {
			if(course.getId()==courseId) {
				list.remove(course);
				return;
			}
		}
		throw new Exception("Data not found!");
	}

}
