package com.springrest.springrest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;


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
		
		response.getWriter().println("<style>\r\n" + 
				"@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');\r\n" + 
				"\r\n" + 
				"* {\r\n" + 
				"	margin: 0;\r\n" + 
				"	padding: 0;\r\n" + 
				"	box-sizing: border-box;\r\n" + 
				"	font-family: 'Poppins', sans-serif;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body {\r\n" + 
				"	width: 100%;\r\n" + 
				"	height: 100vh;\r\n" + 
				"	background-image: url(https://images.wallpaperscraft.com/image/single/books_library_shelves_138556_3840x2160.jpg);\r\n" + 
				"	background-size: cover;\r\n" + 
				"	backdrop-filter: blur(5px);\r\n" + 
				"	max-width: 1440px;\r\n" + 
				"	margin-inline: auto;\r\n" + 
				"	padding-inline: 3rem;\r\n" + 
				"	color: #fff;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"h1 {\r\n" + 
				"	color: #FFD700\r\n" + 
				";\r\n" + 
				"	width: 85%;\r\n" + 
				"	font-size: 2rem;\r\n" + 
				"	text-shadow: 8px 8px 12px black;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"button {\r\n" + 
				"	border: none;\r\n" + 
				"	border-radius: 11px;\r\n" + 
				"	color: #000;\r\n" + 
				"	padding: 12px 23px;\r\n" + 
				"	text-align: center;\r\n" + 
				"	font-size: 1rem;\r\n" + 
				"	font-weight: 600;\r\n" + 
				"	margin: 4px 2px;\r\n" + 
				"	cursor: pointer;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"button:hover {\r\n" + 
				"	scale: 1.05;\r\n" + 
				"	transition: all 0.5s ease-out;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".button1 {\r\n" + 
				"	background-color: #4caf50;\r\n" + 
				"} /* Green */\r\n" + 
				".button2 {\r\n" + 
				"	background-color: #008cba;\r\n" + 
				"} /* Blue */\r\n" + 
				".button3 {\r\n" + 
				"	background-color: #ffc0cb;\r\n" + 
				"} /* Pink */\r\n" + 
				".button4 {\r\n" + 
				"	background-color: #a83232;\r\n" + 
				"} /* Red */\r\n" + 
				".button5 {\r\n" + 
				"	background-color: #ffff00;\r\n" + 
				"} /* Yellow */\r\n" + 
				"\r\n" + 
				"input[type=text], select {\r\n" + 
				"  width: 100%;\r\n" + 
				"  padding: 12px 20px;\r\n" + 
				"  margin: 8px 0;\r\n" + 
				"  display: inline-block;\r\n" + 
				"  border: 1px solid #ccc;\r\n" + 
				"  border-radius: 4px;\r\n" + 
				"  box-sizing: border-box;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"input[type=submit] {\r\n" + 
				"  width: 100%;\r\n" + 
				"  background-color: #4CAF50;\r\n" + 
				"  color: white;\r\n" + 
				"  padding: 14px 20px;\r\n" + 
				"  margin: 8px 0;\r\n" + 
				"  border: none;\r\n" + 
				"  border-radius: 4px;\r\n" + 
				"  cursor: pointer;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"input[type=submit]:hover {\r\n" + 
				"  background-color: #45a049;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"div {\r\n" + 
				"  border-radius: 5px;\r\n" + 
				"  background-color: #f2f2f2;\r\n" + 
				"  padding: 20px;\r\n" + 
				"  color: #000000;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				"");

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
			
			response.getWriter().println("<style>\r\n" + 
					"@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');\r\n" + 
					"\r\n" + 
					"* {\r\n" + 
					"	margin: 0;\r\n" + 
					"	padding: 0;\r\n" + 
					"	box-sizing: border-box;\r\n" + 
					"	font-family: 'Poppins', sans-serif;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"body {\r\n" + 
					"	width: 100%;\r\n" + 
					"	height: 100vh;\r\n" + 
					"	background-image: url(https://images.wallpaperscraft.com/image/single/books_library_shelves_138556_3840x2160.jpg);\r\n" + 
					"	background-size: cover;\r\n" + 
					"	backdrop-filter: blur(5px);\r\n" + 
					"	max-width: 1440px;\r\n" + 
					"	margin-inline: auto;\r\n" + 
					"	padding-inline: 3rem;\r\n" + 
					"	color: #fff;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"h1 {\r\n" + 
					"	color: #FFD700\r\n" + 
					";\r\n" + 
					"	width: 85%;\r\n" + 
					"	font-size: 2rem;\r\n" + 
					"	text-shadow: 8px 8px 12px black;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button {\r\n" + 
					"	border: none;\r\n" + 
					"	border-radius: 11px;\r\n" + 
					"	color: #000;\r\n" + 
					"	padding: 12px 23px;\r\n" + 
					"	text-align: center;\r\n" + 
					"	font-size: 1rem;\r\n" + 
					"	font-weight: 600;\r\n" + 
					"	margin: 4px 2px;\r\n" + 
					"	cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button:hover {\r\n" + 
					"	scale: 1.05;\r\n" + 
					"	transition: all 0.5s ease-out;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".button1 {\r\n" + 
					"	background-color: #4caf50;\r\n" + 
					"} /* Green */\r\n" + 
					".button2 {\r\n" + 
					"	background-color: #008cba;\r\n" + 
					"} /* Blue */\r\n" + 
					".button3 {\r\n" + 
					"	background-color: #ffc0cb;\r\n" + 
					"} /* Pink */\r\n" + 
					".button4 {\r\n" + 
					"	background-color: #a83232;\r\n" + 
					"} /* Red */\r\n" + 
					".button5 {\r\n" + 
					"	background-color: #ffff00;\r\n" + 
					"} /* Yellow */\r\n" + 
					"\r\n" + 
					"input[type=text], select {\r\n" + 
					"  width: 100%;\r\n" + 
					"  padding: 12px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  display: inline-block;\r\n" + 
					"  border: 1px solid #ccc;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  box-sizing: border-box;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit] {\r\n" + 
					"  width: 100%;\r\n" + 
					"  background-color: #4CAF50;\r\n" + 
					"  color: white;\r\n" + 
					"  padding: 14px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  border: none;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit]:hover {\r\n" + 
					"  background-color: #45a049;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"div {\r\n" + 
					"  border-radius: 5px;\r\n" + 
					"  background-color: #f2f2f2;\r\n" + 
					"  padding: 20px;\r\n" + 
					"  color: #000000;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"</style>\r\n" + 
					"");

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
		} 
		finally {
			response.getWriter().println("<style>\r\n" + 
					"@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');\r\n" + 
					"\r\n" + 
					"* {\r\n" + 
					"	margin: 0;\r\n" + 
					"	padding: 0;\r\n" + 
					"	box-sizing: border-box;\r\n" + 
					"	font-family: 'Poppins', sans-serif;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"body {\r\n" + 
					"	width: 100%;\r\n" + 
					"	height: 100vh;\r\n" + 
					"	background-image: url(https://images.wallpaperscraft.com/image/single/books_library_shelves_138556_3840x2160.jpg);\r\n" + 
					"	background-size: cover;\r\n" + 
					"	backdrop-filter: blur(5px);\r\n" + 
					"	max-width: 1440px;\r\n" + 
					"	margin-inline: auto;\r\n" + 
					"	padding-inline: 3rem;\r\n" + 
					"	color: #fff;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"h1 {\r\n" + 
					"	color: #FFD700\r\n" + 
					";\r\n" + 
					"	width: 85%;\r\n" + 
					"	font-size: 2rem;\r\n" + 
					"	text-shadow: 8px 8px 12px black;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button {\r\n" + 
					"	border: none;\r\n" + 
					"	border-radius: 11px;\r\n" + 
					"	color: #000;\r\n" + 
					"	padding: 12px 23px;\r\n" + 
					"	text-align: center;\r\n" + 
					"	font-size: 1rem;\r\n" + 
					"	font-weight: 600;\r\n" + 
					"	margin: 4px 2px;\r\n" + 
					"	cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button:hover {\r\n" + 
					"	scale: 1.05;\r\n" + 
					"	transition: all 0.5s ease-out;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".button1 {\r\n" + 
					"	background-color: #4caf50;\r\n" + 
					"} /* Green */\r\n" + 
					".button2 {\r\n" + 
					"	background-color: #008cba;\r\n" + 
					"} /* Blue */\r\n" + 
					".button3 {\r\n" + 
					"	background-color: #ffc0cb;\r\n" + 
					"} /* Pink */\r\n" + 
					".button4 {\r\n" + 
					"	background-color: #a83232;\r\n" + 
					"} /* Red */\r\n" + 
					".button5 {\r\n" + 
					"	background-color: #ffff00;\r\n" + 
					"} /* Yellow */\r\n" + 
					"\r\n" + 
					"input[type=text], select {\r\n" + 
					"  width: 100%;\r\n" + 
					"  padding: 12px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  display: inline-block;\r\n" + 
					"  border: 1px solid #ccc;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  box-sizing: border-box;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit] {\r\n" + 
					"  width: 100%;\r\n" + 
					"  background-color: #4CAF50;\r\n" + 
					"  color: white;\r\n" + 
					"  padding: 14px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  border: none;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit]:hover {\r\n" + 
					"  background-color: #45a049;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"div {\r\n" + 
					"  border-radius: 5px;\r\n" + 
					"  background-color: #f2f2f2;\r\n" + 
					"  padding: 20px;\r\n" + 
					"  color: #000000;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"</style>\r\n" + 
					"");

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
		}
		finally {
			response.getWriter().println("<style>\r\n" + 
					"@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');\r\n" + 
					"\r\n" + 
					"* {\r\n" + 
					"	margin: 0;\r\n" + 
					"	padding: 0;\r\n" + 
					"	box-sizing: border-box;\r\n" + 
					"	font-family: 'Poppins', sans-serif;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"body {\r\n" + 
					"	width: 100%;\r\n" + 
					"	height: 100vh;\r\n" + 
					"	background-image: url(https://images.wallpaperscraft.com/image/single/books_library_shelves_138556_3840x2160.jpg);\r\n" + 
					"	background-size: cover;\r\n" + 
					"	backdrop-filter: blur(5px);\r\n" + 
					"	max-width: 1440px;\r\n" + 
					"	margin-inline: auto;\r\n" + 
					"	padding-inline: 3rem;\r\n" + 
					"	color: #fff;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"h1 {\r\n" + 
					"	color: #FFD700\r\n" + 
					";\r\n" + 
					"	width: 85%;\r\n" + 
					"	font-size: 2rem;\r\n" + 
					"	text-shadow: 8px 8px 12px black;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button {\r\n" + 
					"	border: none;\r\n" + 
					"	border-radius: 11px;\r\n" + 
					"	color: #000;\r\n" + 
					"	padding: 12px 23px;\r\n" + 
					"	text-align: center;\r\n" + 
					"	font-size: 1rem;\r\n" + 
					"	font-weight: 600;\r\n" + 
					"	margin: 4px 2px;\r\n" + 
					"	cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button:hover {\r\n" + 
					"	scale: 1.05;\r\n" + 
					"	transition: all 0.5s ease-out;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".button1 {\r\n" + 
					"	background-color: #4caf50;\r\n" + 
					"} /* Green */\r\n" + 
					".button2 {\r\n" + 
					"	background-color: #008cba;\r\n" + 
					"} /* Blue */\r\n" + 
					".button3 {\r\n" + 
					"	background-color: #ffc0cb;\r\n" + 
					"} /* Pink */\r\n" + 
					".button4 {\r\n" + 
					"	background-color: #a83232;\r\n" + 
					"} /* Red */\r\n" + 
					".button5 {\r\n" + 
					"	background-color: #ffff00;\r\n" + 
					"} /* Yellow */\r\n" + 
					"\r\n" + 
					"input[type=text], select {\r\n" + 
					"  width: 100%;\r\n" + 
					"  padding: 12px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  display: inline-block;\r\n" + 
					"  border: 1px solid #ccc;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  box-sizing: border-box;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit] {\r\n" + 
					"  width: 100%;\r\n" + 
					"  background-color: #4CAF50;\r\n" + 
					"  color: white;\r\n" + 
					"  padding: 14px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  border: none;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit]:hover {\r\n" + 
					"  background-color: #45a049;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"div {\r\n" + 
					"  border-radius: 5px;\r\n" + 
					"  background-color: #f2f2f2;\r\n" + 
					"  padding: 20px;\r\n" + 
					"  color: #000000;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"</style>\r\n" + 
					"");

			response.getWriter().println("<form action=\"/\" method=\"get\">\r\n"
					+ "<button type=\"Submit\" class=\"button1\">Back to home</button>\r\n" + "</form>");
		}

	}

	@RequestMapping("/courses_delete")
	public void deleteCourse(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		

		try {
			String idmain = request.getParameter("id_main");
			String flat=courseService.deleteCourses(Long.parseLong(idmain));
			if(flat.equals("Course deleted")){
			response.getWriter().println("<h1>Course deleted Succesfully</h1><hr><br>");
			}else {
				response.getWriter().println("<h1>Ops!! Some thing went wrong , try aagain</h1><hr><br>");
			}
		} catch (Exception e) {
			response.getWriter().println("<h1>Ops!! Some thing went wrong , try aagain</h1><hr><br>");
		}

		finally {
			response.getWriter().println("<style>\r\n" + 
					"@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap');\r\n" + 
					"\r\n" + 
					"* {\r\n" + 
					"	margin: 0;\r\n" + 
					"	padding: 0;\r\n" + 
					"	box-sizing: border-box;\r\n" + 
					"	font-family: 'Poppins', sans-serif;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"body {\r\n" + 
					"	width: 100%;\r\n" + 
					"	height: 100vh;\r\n" + 
					"	background-image: url(https://images.wallpaperscraft.com/image/single/books_library_shelves_138556_3840x2160.jpg);\r\n" + 
					"	background-size: cover;\r\n" + 
					"	backdrop-filter: blur(5px);\r\n" + 
					"	max-width: 1440px;\r\n" + 
					"	margin-inline: auto;\r\n" + 
					"	padding-inline: 3rem;\r\n" + 
					"	color: #fff;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"h1 {\r\n" + 
					"	color: #FFD700\r\n" + 
					";\r\n" + 
					"	width: 85%;\r\n" + 
					"	font-size: 2rem;\r\n" + 
					"	text-shadow: 8px 8px 12px black;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button {\r\n" + 
					"	border: none;\r\n" + 
					"	border-radius: 11px;\r\n" + 
					"	color: #000;\r\n" + 
					"	padding: 12px 23px;\r\n" + 
					"	text-align: center;\r\n" + 
					"	font-size: 1rem;\r\n" + 
					"	font-weight: 600;\r\n" + 
					"	margin: 4px 2px;\r\n" + 
					"	cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"button:hover {\r\n" + 
					"	scale: 1.05;\r\n" + 
					"	transition: all 0.5s ease-out;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".button1 {\r\n" + 
					"	background-color: #4caf50;\r\n" + 
					"} /* Green */\r\n" + 
					".button2 {\r\n" + 
					"	background-color: #008cba;\r\n" + 
					"} /* Blue */\r\n" + 
					".button3 {\r\n" + 
					"	background-color: #ffc0cb;\r\n" + 
					"} /* Pink */\r\n" + 
					".button4 {\r\n" + 
					"	background-color: #a83232;\r\n" + 
					"} /* Red */\r\n" + 
					".button5 {\r\n" + 
					"	background-color: #ffff00;\r\n" + 
					"} /* Yellow */\r\n" + 
					"\r\n" + 
					"input[type=text], select {\r\n" + 
					"  width: 100%;\r\n" + 
					"  padding: 12px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  display: inline-block;\r\n" + 
					"  border: 1px solid #ccc;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  box-sizing: border-box;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit] {\r\n" + 
					"  width: 100%;\r\n" + 
					"  background-color: #4CAF50;\r\n" + 
					"  color: white;\r\n" + 
					"  padding: 14px 20px;\r\n" + 
					"  margin: 8px 0;\r\n" + 
					"  border: none;\r\n" + 
					"  border-radius: 4px;\r\n" + 
					"  cursor: pointer;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"input[type=submit]:hover {\r\n" + 
					"  background-color: #45a049;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"div {\r\n" + 
					"  border-radius: 5px;\r\n" + 
					"  background-color: #f2f2f2;\r\n" + 
					"  padding: 20px;\r\n" + 
					"  color: #000000;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"</style>\r\n" + 
					"");

			response.getWriter().println("<form action=\"/\" method=\"get\">\r\n"
					+ "<button type=\"Submit\" class=\"button1\">Back to home</button>\r\n" + "</form>");

		}
	}

}
