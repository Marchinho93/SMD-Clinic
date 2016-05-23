package persistence;

import it.uniroma3.persistence.PersistenceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Doctor;
import model.Exam;

public class DoctorDaoJdbc implements DoctorDao{

	@Override
	public void save(Doctor doctor) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into studente(matricola, nome, cognome, datanascita) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, studente.getMatricola());
			statement.setString(2, studente.getNome());
			statement.setString(3, studente.getCognome());
			long secs = studente.getDataNascita().getTime();
			statement.setDate(4, new java.sql.Date(secs));
			logger.info(statement);
			statement.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error(e);
				throw new PersistenceException(e.getMessage());
			}
		}
		
	}

	@Override
	public Doctor findByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Doctor> findByExam(Exam exam) {
		// TODO Auto-generated method stub
		return null;
	}

}
