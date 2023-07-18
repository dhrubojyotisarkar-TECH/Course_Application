package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;
	

	public CourseServiceImpl() {
		
//		list=new ArrayList<>();
//		list.add(new Course(01,"Java Course","This is a java course from scratch for beginner."));
//		list.add(new Course(02,"C Programming Language","This course is for Data structure using C"));
//		list.add(new Course(03,"Python","Python beginner course"));
		
	}

// get courses
	@Override
	public List<Course> getCourses() {
		
//		return list;
		return courseDao.findAll();
	}

// get courses by id
	@Override
	public Course getCourses(Long courseId) {
		
//		Course c=null;
//		for(Course course : list) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//			
//		}
		
//		return c;
		//Course entity=courseDao.getOne(courseId);
		 return courseDao.findById(courseId).get();
	}

// add courses
	@Override
	public Course addCourse(Course course) {
		
//		list.add(course);
//		return course;
		courseDao.save(course);
		return course;
	}

// update courses
	@Override
	public Course updateCourse(long courseId, Course course) {
//		Course c=null;
//		for(Course course1 : list) {
//			if(course1.getId()==courseId) {
//				c=course1;
//				System.out.println(course1.getId());
//				list.set(list.indexOf(c),course);
//				System.out.println(list.indexOf(c)+" "+course);
//				break;
//			}
//		
//	}
//		return course;
		courseDao.save(course);
		return course;

		
}

//delete courses
	@Override
	public String deleteCourses(long courseId) {
//		Course c=null;
//		for(Course course2 : list) {
//			if(course2.getId()==courseId) {
//				c=course2;
//				list.remove(c);
//				break;
//			}
//			
//		}
//		return "Course deleted";
		Course entity=courseDao.getOne(courseId);
		courseDao.delete(entity);
		return "Course deleted";
	
	}
}
