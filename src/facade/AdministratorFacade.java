package facade;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.NonUniqueResultException;

import model.Administrator;

@Stateless(name="administratorFacade")
public class AdministratorFacade {
	
	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	public Administrator createAdministrator(String username, String name, String surname, String password){
		Administrator administrator = new Administrator(username, name, surname, password);
		em.persist(administrator);
		return administrator;
	}
	
	public Administrator findByUsername(String username) throws SQLException{
		TypedQuery<Administrator> query = em.createNamedQuery("Administrator.findByUsername", Administrator.class); 
		query.setParameter("username", username);
		List<Administrator> result = query.getResultList();
		if(result.isEmpty()) return null;
		if(result.size()==1) return result.get(0);
		else
			throw new NonUniqueResultException(result.size());
		
	}
	
	public List<Administrator> findAll(){
		return em.createNamedQuery("Administrator.findAll", Administrator.class).getResultList();
	}
	
	public void removeAdministrator(Administrator administrator){
		em.remove(administrator);
	}

}
