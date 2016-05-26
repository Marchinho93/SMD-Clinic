package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(sequenceName = "administratorSeq", name = "administratorSeq", initialValue=10000, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a")
})
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="administratorSeq")
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
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
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
