package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Register.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ArrayList<User> users;
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		
		if(username == "" || username == null || password == "" || password == null) {
			System.out.println("Geçersiz þifre veya kullanýcý adý");
			return;
		}
		
		
		users = (ArrayList<User>)getServletContext().getAttribute("users");
		
		if(users == null) {
			users= new ArrayList<>();
			getServletContext().setAttribute("users",users);
		}
		
		for(int i =0; i< users.size() ; i++){
			 if(users.get(i).getUsername().equals(username)) {
				 out.write("kayitliVar");
				 return;
			 }
		}
		
		User user = new User(username, password, name, surname);
		
		users.add(user);
		getServletContext().setAttribute("users", users);
		out.write("basarili");
	}

}
