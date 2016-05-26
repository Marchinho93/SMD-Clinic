package model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="examFacade")
public class ExamFacade {
	EntityManager em;
	
	@PersistenceContext(unitName = "models-unit")
	public Exam createExam(Date examDate, Patient patient, Doctor doctor, ExamTypology examTypology){
		Exam exam = new Exam(examDate, patient, doctor, examTypology);
		em.persist(exam);
		return exam;
	}
	
	public Exam findByCode(long code){
		Exam exam = em.find(Exam.class, code);
		return exam;
	}
	
	public List<Exam> findByPatient(Patient patient){
		return em.createNamedQuery("Exam.findByPatient", Exam.class).setParameter("patient_code", patient.getCode()).getResultList();
	}
	
	public List<Exam> findByDoctor(Doctor doctor){
		return em.createNamedQuery("Exam.findByDoctor", Exam.class).setParameter("doctor_code", doctor.getCode()).getResultList();
	}
	
	public void removeExam(Exam exam){
		em.remove(exam);
	}
}
