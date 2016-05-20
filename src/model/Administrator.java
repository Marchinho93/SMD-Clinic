package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long code;
	@Column(nullable=true, length=30)
	private String password;
	@Column(nullable=false, length=20)
	private String name;
	@Column(nullable=false, length=20)
	private String surname;
	
	public Administrator(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
