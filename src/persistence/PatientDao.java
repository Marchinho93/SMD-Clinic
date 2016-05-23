package persistence;

import java.util.List;
import model.Patient;

public interface PatientDao {

		public void save(Patient patient);  // Create
		public Patient findByPrimaryKey(long code);     // Retrieve
		public List<Patient> findAll();       
		public void update(Patient patient); //Update
		public void delete(Patient patient); //Delete

}