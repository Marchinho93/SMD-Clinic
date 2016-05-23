package Persistence;

import java.util.List;
import model.Prerequisite;

public interface PrerequisiteDao {
	public void save(Prerequisite prerequisite);  // Create
	public List<Prerequisite> findAll();       
	public void update(Prerequisite prerequisite); //Update
	public void delete(Prerequisite prerequisite); //Delete
}
