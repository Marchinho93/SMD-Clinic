package facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Doctor;

@Stateless(name = "doctorFacade")
public class DoctorFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public Doctor createDoctor(String name, String surname, String fieldOfSpecialization){
		Doctor doctor = new Doctor(name, surname, fieldOfSpecialization);
		em.persist(doctor);
		return doctor;
	}
	
	public Doctor findByCode(String code){
		Doctor doctor = em.find(Doctor.class, code);
		return doctor;
	}
	
	public List<Doctor> findAll(){
		return em.createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
	}
	
	public void removeDoctor(Doctor doctor){
		em.remove(doctor);
	}
}
