package model;

import java.util.Map;

public class SMDClinic {
	private Map<Long, Doctor> doctors;
	private Map<Long, Exam> exams;
	private Map<Long, ExamTypology> examTypologies;
	private Map<Long, Patient> patients;
	private Map<Long, Administrator> administrators;
	
	public SMDClinic() {
	}

	public Map<Long, Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Map<Long, Doctor> doctors) {
		this.doctors = doctors;
	}

	public Map<Long, Exam> getExams() {
		return exams;
	}

	public void setExams(Map<Long, Exam> exams) {
		this.exams = exams;
	}

	public Map<Long, ExamTypology> getExamTypologies() {
		return examTypologies;
	}

	public void setExamTypologies(Map<Long, ExamTypology> examTypologies) {
		this.examTypologies = examTypologies;
	}

	public Map<Long, Patient> getPatients() {
		return patients;
	}

	public void setPatients(Map<Long, Patient> patients) {
		this.patients = patients;
	}

	public Map<Long, Administrator> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Map<Long, Administrator> administrators) {
		this.administrators = administrators;
	}
}
