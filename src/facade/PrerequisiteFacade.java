package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Prerequisite;

@Stateless(name = "PrerequisiteFacade")
public class PrerequisiteFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public Prerequisite crearePrerequisite(String name, String description){
		Prerequisite prerequisite = new Prerequisite(name, description);
		em.persist(prerequisite);
		return prerequisite;
	}
	
	public Prerequisite findByName(String name){
		Prerequisite prerequisite = em.find(Prerequisite.class, name);
		return prerequisite;
	}
	
	public List<Prerequisite> findAll(){
		return em.createNamedQuery("Prerequisite.findAll", Prerequisite.class).getResultList();
	}
	
	public void removePrerequisite(Prerequisite prerequisite){
		em.remove(prerequisite);
	}
}
