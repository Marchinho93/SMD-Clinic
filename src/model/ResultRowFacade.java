package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "ResultRowFacade")
public class ResultRowFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public ResultRow crearePrerequisite(long id, String value, ResultIndicator resultIndicator, Result result){
		ResultRow resultRow = new ResultRow(id, value, resultIndicator, result);
		em.persist(resultRow);
		return resultRow;
	}
	
	public ResultRow findByCode(long code){
		ResultRow resultRow = em.find(ResultRow.class, code);

		return resultRow;
	}
	
	public List<ResultRow> findAll(){
		return em.createNamedQuery("ResultRow.findAll", ResultRow.class).getResultList();
	}
	
	public void removePrerequisite(ResultRow resultRow){
		em.remove(resultRow);
	}
}