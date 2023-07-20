package com.springrest.springrest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import antlr.collections.List;

@Controller
public class MapptingController {

	@Autowired
	private CourseService courseService;

	MyController mc = new MyController();

	@RequestMapping("/courses_all")
	public void allcourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		java.util.List<Course> allcour = courseService.getCourses();
		// response.getWriter().println("<h1>"+allcour+"</h1><br>");
		for (Course i : allcour) {
			response.getWriter().println("<h1>" + i + "</h1><br>");
		}

		response.getWriter().println("<form action=\"/\" method=\"get\">\r\n"
				+ "<button type=\"Submit\" class=\"button1\">Back to home</button>\r\n" + "</form>");

	}

	@RequestMapping("/coursesbyid_main")
	public void couseFollow(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			String myid = request.getParameter("id");
			Course c2 = new Course();
			c2 = courseService.getCourses(Long.parseLong(myid));
			long ID = c2.getId();
			String TITLE = c2.getTitle();
			String DES = c2.getDescription();
			response.getWriter().println("<h1>The Couse is :</h1><br>");
			response.getWriter().println("<h1>" + ID + "</h1><br>");
			response.getWriter().println("<h1>" + TITLE + "</h1><br>");
			response.getWriter().println("<h1>" + DES + "</h1><br>");

		} catch (Exception e) {
			response.getWriter().println("<h1>Ops!! Some thing went wrong , try aagain</h1><br>");
		} finally {

			response.getWriter().println("<form action=\"/\" method=\"get\">\r\n"
					+ "<button type=\"Submit\" class=\"button1\">Back to home</button>\r\n" + "</form>");
		}

	}

	@RequestMapping("/courses_add")
	public void addnewcourse(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// return this.courseService.addCourse(c1);
		try {
			String id = request.getParameter("id");
			String titel = request.getParameter("title");
			String des = request.getParameter("desricption");
			System.out.println("Printing the datas" + id + titel + des);
			Course c1 = new Course();
			c1.setId(Long.parseLong(id));
			c1.setTitle(titel);
			c1.setDescription(des);
			System.out.println("The object fromed as : " + c1);
			// System.out.println(mc.addCourse(c1));
			System.out.println(courseService.addCourse(c1));

			response.getWriter().println("<h1>Course added Succesfully</h1><hr><br>" + c1 + "<br>");

		} catch (Exception e) {
			response.getWriter().println("<h1>Ops!! Some thing went wrong , try aagain</h1><br>");
		} finally {
			response.getWriter().println("<form action=\"/\" method=\"get\">\r\n"
					+ "<button type=\"Submit\" class=\"button1\">Back to home</button>\r\n" + "</form>");

		}

	}

	@RequestMapping("/courses_update")
	public void updatecourse(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {
			String idmain = request.getParameter("id_main");
			String id = request.getParameter("id");
			String titel = request.getParameter("title");
			String des = request.getParameter("desricption");

			Course c4 = new Course();
			c4.setId(Long.parseLong(id));
			c4.setTitle(titel);
			c4.setDescription(des);

			courseService.updateCourse(Long.parseLong(idmain), c4);

			response.getWriter().println("<h1>Course updated Succesfully</h1><hr><br>" + c4 + "<br>");

		} catch (Exception e) {
			response.getWriter().println("<h1>Ops!! Some thing went wrong , try aagain</h1><br>");
		} finally {
			response.getWriter().println("<form action=\"/\" method=\"get\">\r\n"
					+ "<button type=\"Submit\" class=\"button1\">Back to home</button>\r\n" + "</form>");
		}

	}

	@RequestMapping("/courses_delete")
	public void deleteCourse(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String idmain = request.getParameter("id_main");

		try {
			courseService.deleteCourses(Long.parseLong(idmain));
			response.getWriter().println("<h1>Course deleted Succesfully</h1><hr><br>");
		} catch (Exception e) {
			response.getWriter().println("<h1>Ops!! Some thing went wrong , try aagain</h1><hr><br>");
		}

		finally {
			response.getWriter().println("<form action=\"/\" method=\"get\">\r\n"
					+ "<button type=\"Submit\" class=\"button1\">Back to home</button>\r\n" + "</form>");

		}
	}

}
