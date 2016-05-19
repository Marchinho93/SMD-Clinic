package model;

import java.util.Date;
import java.util.Map;

public class Patient {
	private long code;
	private String password;
	private String name;
	private String surname;
	private Date dateOfBirth;
	private String address;
	
	private Map<Long, Exam> exams;
	
	public Patient(String name, String surname, Date dateOfBirth, String address) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Map<Long, Exam> getExams() {
		return exams;
	}
	public void setExams(Map<Long, Exam> exams) {
		this.exams = exams;
	}
}
