package persistence;

import java.util.List;

import model.Administrator;

public interface AdministratorDAO {
	
	public void save(Administrator admin);
	public Administrator findByCode(String code);
	public List<Administrator> findAll();
	public void update(Administrator admin);
	public void delete(Administrator admin);
}
