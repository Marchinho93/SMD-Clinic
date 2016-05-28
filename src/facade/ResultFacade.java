package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Exam;
import model.Result;

@Stateless(name = "ResultFacade")
public class ResultFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public Result crearePrerequisite(Exam exam){
		Result result = new Result(exam);
		em.persist(result);
		return result;
	}
	
	public Result findByCode(long code){
		Result result = em.find(Result.class, code);
		
		return result;
	}
	
	public List<Result> findAll(){
		return em.createNamedQuery("Result.findAll", Result.class).getResultList();
	}
	
	public void removePrerequisite(Result result){
		em.remove(result);
	}
}