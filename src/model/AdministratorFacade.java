package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="administratorFacade")
public class AdministratorFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public Administrator createAdministrator(String name, String surname, String password){
		Administrator administrator = new Administrator(name, surname);
		administrator.setPassword(password);
		em.persist(administrator);
		return administrator;
	}
	
	public Administrator findByCode(String code){
		Administrator administrator = em.find(Administrator.class, code);
		return administrator;
	}
	
	public List<Administrator> findAll(){
		return em.createNamedQuery("Administrator.findAll", Administrator.class).getResultList();
	}
	
	public void removeAdministrator(Administrator administrator){
		em.remove(administrator);
	}

}
