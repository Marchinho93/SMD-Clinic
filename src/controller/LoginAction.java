package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Administrator;

public class LoginAction {

	public String authenticateUser(HttpServletRequest request){
		String username = (String) request.getParameter("username");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("models-unit");
		EntityManager em = emf.createEntityManager();
		Administrator administrator = ((Administrator) em.createNamedQuery("Administrator.findByUsername", Administrator.class).setParameter("username", username).getSingleResult());
		System.out.println(administrator.getName());
		em.close();
		emf.close();
		if(administrator!=null){
			HttpSession session = request.getSession();
			session.setAttribute("username",administrator.getName());
			session.setAttribute("name",administrator.getName());
			session.setAttribute("surname",administrator.getSurname());
			session.setAttribute("code",administrator.getCode());
			return "";
		}
		return "";
	}
}
