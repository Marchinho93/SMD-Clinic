package persistence;

import java.util.List;
import model.Result;

public interface ResultDao {
	
		public void save(Result result);  // Create
		public Result findByPrimaryKey(long code);     // Retrieve
		public List<Result> findAll();       
		public void update(Result result); //Update
		public void delete(Result result); //Delete
}
