package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute(("users"));
		if(users == null) {
			writer.write("GIRILMEDI");
		}
		// TODO : Burasý databaseden çekilen deðerler kontrol edilecek
		boolean isLogined = false;
		
		for (User u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				isLogined=true;
			}else {
				isLogined =false;
			}
		}
		if(isLogined) {
			HttpSession ses = request.getSession();
			ses.setAttribute("login", true);
			writer.write("GIRILDI");
		}else {
			writer.write("GIRILMEDI");
		}
		
		
		//if(username.equals("q") && password.equals("q")) {
			// TODO : Giriþ yaptý.
		//	HttpSession session = request.getSession();
		//	session.setAttribute("login", true);
			//	String sonuc = "GIRILDI";
		//	writer.write(sonuc);
		//} else {
			//	// TODO : Giriþ yapýlamadý.
		//	String sonuc = "GIRILMEDI";
		//	writer.write(sonuc);
			//}
	}

}
