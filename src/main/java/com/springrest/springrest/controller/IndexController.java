package com.springrest.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {

		return "index";
	}
	@GetMapping("/courses_id")
	public String coursesbyid() {

		return "coursesbyid";
	}

	@GetMapping("/addnewcourse")
	public String addNewcourse() {

		return "addnewcoursepage";
	}

	@GetMapping("/updatecourse")
	public String updateCourse() {

		return "/updatecourse";
	}

	@GetMapping("/deletecourse")
	public String deletecourse() {

		return "/deletecourse";
	}

}
