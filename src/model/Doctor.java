package model;

import java.util.Map;

public class Doctor {
	private long code;
	private String password;
	private String name;
	private String surname;
	private String fieldOfSpecialization;
	
	private Map<Long, Exam> exams;

	public Doctor(String name, String surname, String fieldOfSpecialization) {
		this.name = name;
		this.surname = surname;
		this.fieldOfSpecialization = fieldOfSpecialization;
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

	public String getFieldOfSpecialization() {
		return fieldOfSpecialization;
	}

	public void setFieldOfSpecialization(String fieldOfSpecialization) {
		this.fieldOfSpecialization = fieldOfSpecialization;
	}

	public Map<Long, Exam> getExams() {
		return exams;
	}

	public void setExams(Map<Long, Exam> exams) {
		this.exams = exams;
	}
}
