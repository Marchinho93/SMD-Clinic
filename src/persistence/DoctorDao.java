package persistence;

import java.util.List;

import model.Doctor;
import model.Exam;

public interface DoctorDao {
	public void save(Doctor doctor);  // Create
	public Doctor findByCode(String code);     // Retrive
	public List<Doctor> findAll();       
	public void update(Doctor doctor); //Update
	public void delete(Doctor doctor); //Delete
	public List<Doctor> findByExam(Exam exam);
}
