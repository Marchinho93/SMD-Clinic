package persistence;

import java.util.List;
import model.ResultRow;

public interface ResultRowDao {
	public void save(ResultRow resultRow);  // Create
	public ResultRow findByCode(String code);     // Retrive
	public List<ResultRow> findAll();       
	public void update(ResultRow resultRow); //Update
	public void delete(ResultRow resultRow); //Delete
}
