package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.money.Euro;

public class Main {
	
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("models-unit");
		EntityManager em = emf.createEntityManager();
		
		Administrator admin = new Administrator("Davide", "Cassetta");
		admin.setPassword("password");
		
		Doctor doctor1 = new Doctor("Simone", "Fioroni", "Cardiologia");
		
		Date date1 = new Date(70, 11, 1);
		Patient patient1  = new Patient("Ajeje", "Brazorf", date1, "Via dei cani esplosi 8");
		
		List<ResultIndicator> resInds = new ArrayList<>();
		ResultIndicator emo = new ResultIndicator("Emoglobina");
		resInds.add(emo);
		
		ExamTypology examType = new ExamTypology("AS", "Analisi del sangue", new Euro(80).toString(),resInds);
		Prerequisite pre1 = new Prerequisite("NM", "Non Morto");
		List<Prerequisite> pres = new ArrayList<>();
		pres.add(pre1);
		examType.setPrerequisites(pres);
		
		Date date2 = new Date();
		Date date3 = new Date(90, 10, 3);
		Exam exam1 = new Exam(date3, patient1, doctor1, examType);
		List<Exam> exams = new ArrayList<>();
		exams.add(exam1);
		System.out.println("where the fuck am i:"+exam1.getCode());
		examType.setExams(exams);
		doctor1.setExams(exams);
		patient1.setExams(exams);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(admin);
		em.persist(exam1);
		tx.commit();
		em.close();
		emf.close();
	}

}
