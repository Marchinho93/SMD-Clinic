package controller;

import java.io.IOException;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LoginAction loginAction = new LoginAction();
		LoginHelper loginHelper = new LoginHelper();
		String nextPage = "/index.jsp";;
		if(loginHelper.validateUser(request)){
			loginAction.authenticateUser(request);
			Cookie cookie = new Cookie("login", "loginSucced");
			response.addCookie(cookie);
		}else{
			Cookie cookie = new Cookie("login", "loginError");
			response.addCookie(cookie);
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
