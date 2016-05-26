package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "examTypologyFacade")
public class ExamTypologyFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public ExamTypology createExamTypology(String name, String description,String price, List<ResultIndicator> resultIndicators, List<Prerequisite> prerequisites){
		ExamTypology examTypology = new ExamTypology(name, description, price, resultIndicators, prerequisites);
		em.persist(examTypology);
		return examTypology;
	}

	public ExamTypology findByCode(long code){
		ExamTypology examTypology = em.find(ExamTypology.class, code);
		return examTypology;
	}
	
	public List<ExamTypology> findAll(){
		return em.createNamedQuery("ExamTypology.findAll", ExamTypology.class).getResultList();
	}
}
