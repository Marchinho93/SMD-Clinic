package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Administrator;
import model.AdministratorFacade;

@WebServlet("/admin/*")
public class AdministratorController {
	@EJB(beanName="administratorFacade")
	private AdministratorFacade administratorFacade;
	
	private String name;
	private String surname;
	private String password;
	
	private Administrator administrator;
	private List<Administrator> administrators;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	
	public String createAdministrator(){
		this.administrator = administratorFacade.createAdministrator(this.name, this.surname, this.password);
		return "administrator";
	}
	
	public String loginAdministrator(){
		this.administrator = administratorFacade.findByCode(this.code);
		if(this.administrator.getPassword()==this.password)
			return "";
	}

}
