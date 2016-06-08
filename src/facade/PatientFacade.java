package facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Patient;

@Stateless(name = "patientFacade")
public class PatientFacade {

	@PersistenceContext(unitName = "models-unit")
	EntityManager em;
	
	public Patient createPatient(String username, String name, String surname, Date dateOfBirth, String address, String password){
		Patient patient = new Patient(username, name, surname, dateOfBirth, address, password);
		em.persist(patient);
		return patient;
	}
	
	public Patient findByCode(long code){
		return em.find(Patient.class, code);
	}
	
	public List<Patient> findAll(){
		return em.createNamedQuery("Patient.findAll", Patient.class).getResultList();
	}
	
	public void removePatient(Patient patient){
		em.remove(patient);
	}

	public Patient findByUsername(String username){
		TypedQuery<Patient> query = em.createNamedQuery("Patient.findByUsername", Patient.class); 
		query.setParameter("username", username);
		List<Patient> result = query.getResultList();
		if(result.isEmpty()) return null;
		if(result.size()==1) return result.get(0);
		else
			throw new NonUniqueResultException();
		//return (Patient) em.createNamedQuery("Patient.findByUsername", Patient.class).setParameter("username", username).getSingleResult();
	}
	

}
