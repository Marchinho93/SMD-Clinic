package persistence;

import java.util.Date;
import java.util.List;

import model.Doctor;
import model.Exam;
import model.ExamTypology;
import model.Patient;

public interface ExamDAO {
	
	public void save(Exam exam);
	public Exam findByPrimaryKey(long code);
	public List<Exam> findAll();
	public Exam findByPatient(Patient student);
	public Exam findByDoctor(Doctor doctor);
	public Exam findByExamTypology(ExamTypology examType);
	public Exam findByExamDate(Date examDate);
	public Exam findByBookingDate(Date bookingDate);
	public void update(Exam exam);
	public void delete(Exam exam);
}
