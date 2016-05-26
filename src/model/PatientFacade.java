package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "patientFacade")
public class PatientFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public Patient createPatient(String name, String surname, Date dateOfBirth, String address){
		Patient patient = new Patient(name, surname, dateOfBirth, address);
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

}
