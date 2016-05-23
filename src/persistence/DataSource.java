package persistence;

import java.sql.*;

import javax.persistence.PersistenceException;

public class DataSource {
	private String dbURI = "jdbc:postgresql://localhost/postgres";
	private String userName = "postgres";
	private String password = "0000";

	public Connection getConnection() throws PersistenceException {
		Connection connection = null;
		try {
		    Class.forName("org.postgresql.Driver");
		    connection = DriverManager.getConnection(dbURI,userName, password);
		} catch (ClassNotFoundException e) {
			throw new PersistenceException(e.getMessage());
		} catch(SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return connection;
	}
}
