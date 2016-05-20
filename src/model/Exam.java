package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exam {
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date examDate;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long code;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@Column(nullable = false)
	private Patient patient;
	@OneToOne(cascade = {CascadeType.PERSIST})
	@Column(nullable = false)
	private Result result;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@Column(nullable = false)
	private Doctor doctor;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@Column(nullable = false)
	private ExamTypology examTypology;
	
	public Exam(Date examDate, Patient patient, Doctor doctor, ExamTypology examTypology) {
		this.bookingDate = new Date();
		this.examDate = examDate;
		this.patient = patient;
		this.doctor = doctor;
		this.examTypology = examTypology;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public ExamTypology getExamTypology() {
		return examTypology;
	}

	public void setExamTypology(ExamTypology examTypology) {
		this.examTypology = examTypology;
	}
}
