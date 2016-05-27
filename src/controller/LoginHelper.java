package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import model.Administrator;

public class LoginHelper {

	public boolean validateUser(HttpServletRequest request){
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("models-unit");
		EntityManager em = emf.createEntityManager();
		Administrator administrator = ((Administrator) em.createNamedQuery("Administrator.findByUsername", Administrator.class).setParameter("username", username).getSingleResult());
		System.out.println(administrator.getPassword() + " " + password);
		em.close();
		emf.close();
		if(administrator.getPassword().equals(password))
			return true;		
		return false;
	}
}
