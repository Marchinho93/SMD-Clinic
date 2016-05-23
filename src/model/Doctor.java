package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String code;
	@Column(nullable=false, length = 20)
	private String name;
	@Column(nullable=false, length = 20)
	private String surname;
	private String fieldOfSpecialization;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Exam> exams;

	public Doctor(String name, String surname, String fieldOfSpecialization) {
		this.name = name;
		this.surname = surname;
		this.fieldOfSpecialization = fieldOfSpecialization;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
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

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
}
