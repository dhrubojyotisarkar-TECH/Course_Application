package com.springrest.springrest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService  courseService;
	
	
	@GetMapping("/home")
	public String home() {
		
		return "This is home page ...";
	}
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		
		return this.courseService.getCourses();
		
	}
	//get the courses by id
	@GetMapping("/courses{CourseId}")
	public Course getCourses(@PathVariable String CourseId)
	{
		return this.courseService.getCourses(Long.parseLong(CourseId));
		
	}
	// add new course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
	// update course by id
	@PutMapping("/courses{CourseId}")
	public Course updateCourse(@PathVariable String CourseId , @RequestBody Course course)
	{
		return this.courseService.updateCourse(Long.parseLong(CourseId),course);
	}
	// delete course by id
	@DeleteMapping("/courses{CourseId}")
	public String deleteCourse(@PathVariable String CourseId) {
		
		return this.courseService.deleteCourses(Long.parseLong(CourseId));
		
	}
	

}
