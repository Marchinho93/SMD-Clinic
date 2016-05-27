package controller;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String password;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LoginAction loginAction = new LoginAction();
		LoginHelper loginHelper = new LoginHelper();
		String nextPage = "/try.jsp";
		System.out.println("eh");
		if(loginHelper.validateUser(request)){
			loginAction.authenticateUser(request);
			Cookie cookie = new Cookie("login", "loginSucced");
			response.addCookie(cookie);
			System.out.println("alleuia");
		}else{
			Cookie cookie = new Cookie("login", "loginError");
			response.addCookie(cookie);

			System.out.println("whyyyyy");
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
