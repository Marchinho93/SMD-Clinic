package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Administrator;

@Stateless(name="administratorFacade")
public class AdministratorFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public Administrator createAdministrator(String username, String name, String surname, String password){
		Administrator administrator = new Administrator(username, name, surname, password);
		em.persist(administrator);
		return administrator;
	}
	
	public Administrator findByUsername(String username){
		return (Administrator) em.createNamedQuery("Administrator.findByUsername", Administrator.class).setParameter("username", username).getSingleResult();
	}
	
	public List<Administrator> findAll(){
		return em.createNamedQuery("Administrator.findAll", Administrator.class).getResultList();
	}
	
	public void removeAdministrator(Administrator administrator){
		em.remove(administrator);
	}

}
