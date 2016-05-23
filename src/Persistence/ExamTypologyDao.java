package Persistence;
import java.util.List;
import model.ExamTypology;

public interface ExamTypologyDao {
	public void save(ExamTypology examTypology);  // Create
	public ExamTypology findByCode(long code);     // Retrive
	public List<ExamTypology> findAll();       
	public void update(ExamTypology examTypology); //Update
	public void delete(ExamTypology examTypology); //Delete
}
