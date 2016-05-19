package model;

import java.util.Date;


public class Exam {
	private Date bookingDate;
	private Date examDate;
	private long code;
	private Patient patient;
	private Doctor doctor;
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
