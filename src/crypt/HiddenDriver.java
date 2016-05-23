package crypt;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;

/*Extends class Driver from Postgres Libraries to implement improved security system as password cryptation*/
public class HiddenDriver extends Driver{	
	@Override
	public Connection connect(String url, Properties info) throws SQLException{
		AesCrypt aes = new AesCrypt();
		String password = (String) info.get("password");
		info.remove("password");
		info.put("password", aes.decrypt(password));		
		return super.connect(url, info);
	}
}
