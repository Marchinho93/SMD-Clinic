package model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long code;
	@Column(nullable=false, length = 20)
	private String name;
	@Column(nullable=false, length = 20)
	private String surname;
	private String fieldOfSpecialization;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
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
