package controller;

import java.sql.SQLException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import facade.AdministratorFacade;
import facade.PatientFacade;
import model.Administrator;
import model.Patient;

@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController{

	@EJB
	AdministratorFacade administratorFacade;
	@EJB
	PatientFacade patientFacade;	
	//utility variables
	long code;
	String name;
	String surname;
	//required to login
	String username;
	String password;
	
	String userRole = "";
	String loginString = "Login";

	Administrator admin;
	Patient patient;

	public LoginController() {
	}

	public String login() throws SQLException{
		Administrator administrator = administratorFacade.findByUsername(username);
		String nextPage = "";
		HttpServletResponse cookie =  (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		if(administrator!=null){
			if(administrator.getPassword().equals(password)){
				this.admin = administrator;
				nextPage = "";
				loginString = "Hello, " + this.admin.getName();
				userRole = "admin";
				Cookie loginCookie = new Cookie("login","admin");
				cookie.addCookie(loginCookie);
			}
		}			
		else{
			Patient patient = patientFacade.findByUsername(username);
				if(patient!=null){
					if(patient.getPassword().equals(password)){
						this.patient = patient;
						nextPage = "";	
						userRole = "patient";
						loginString = "Hello, " + this.patient.getName();
						Cookie loginCookie = new Cookie("login","patient");
						cookie.addCookie(loginCookie);
					}
				}
				else{
					nextPage ="";
					userRole = "error";
					loginString = "Login";
					Cookie loginCookie = new Cookie("login","fail");
					cookie.addCookie(loginCookie);
				}
		}
		return nextPage;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLoginString() {
		return loginString;
	}

	public void setLoginString(String loginString) {
		this.loginString = loginString;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
