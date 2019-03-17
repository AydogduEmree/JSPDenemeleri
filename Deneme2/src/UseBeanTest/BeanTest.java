package UseBeanTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.User;

/**
 * Servlet implementation class BeanTest
 */
@WebServlet("/BeanTest")
public class BeanTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeanTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setName("Emre");
		user.setSurname("aydogdu");
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("BeanTest.jsp").forward(request, response);
		/*
		 Maven projesi için :
		 	1: Window -> Preferences 
		 	2: Filter ' a Maven yazýp-> Archetypes -> Add Remote Catalog
		 	3: Catalog File : http://repo.maven.apache.org/maven2/archetype-catalog
		 	4: Descriptions : Maven catalog
		 	5: Verify
		 	6: ok -> Apply changes
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
