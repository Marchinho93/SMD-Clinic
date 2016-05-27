package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.money.Euro;

public class Main {
	
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("models-unit");
		EntityManager em = emf.createEntityManager();
		
		Administrator admin = new Administrator("davCass","Davide", "Cassetta", "password");
		
		Doctor doctor1 = new Doctor("Simone", "Fioroni", "Cardiologia");
		
		Date date1 = new Date(70, 11, 1);
		Patient patient1  = new Patient("Ajeje", "Brazorf", date1, "Via dei cani esplosi 8");
		
		List<ResultIndicator> resInds = new ArrayList<>();
		ResultIndicator emo = new ResultIndicator("Emoglobina");
		resInds.add(emo);
		List<Prerequisite> pres = new ArrayList<>();
		Prerequisite pre1 = new Prerequisite("NM", "Non Morto");
		pres.add(pre1);
		
		ExamTypology examType = new ExamTypology("AS", "Analisi del sangue", new Euro(80).toString(),resInds, pres);


		examType.setPrerequisites(pres);
		
		Date date3 = new Date(90, 10, 3);
		Exam exam1 = new Exam(date3, patient1, doctor1, examType);
		List<Exam> exams = new ArrayList<>();
		exams.add(exam1);
		System.out.println("where the fuck am i:"+exam1.getCode());
		examType.setExams(exams);
		doctor1.setExams(exams);
		patient1.setExams(exams);
		
		Result res1 = new Result(exam1);
		List<ResultRow> resRows1 = new ArrayList<>();
		resRows1.add(new ResultRow(0, "8mg", emo, res1));
		res1.setResultsRows(resRows1);
		resRows1.add(new ResultRow(1,"5f", emo, res1));
		
		exam1.setResult(res1);
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(admin);
		em.persist(exam1);
		tx.commit();
		Exam exam2 = new Exam(new Date(), patient1, doctor1, examType);
		Result res2 = new Result(exam2);
		System.out.println("code:"+exam1.getCode());
		tx.begin();
		em.persist(exam2);
		em.persist(exam1);
		exam1.setResult(res1);
		exam2.setResult(res2);		
		tx.commit();
		
		System.out.println(((Administrator) em.createNamedQuery("Administrator.findByUsername", Administrator.class).setParameter("username", "davCass").getSingleResult()).getName());
		em.close();
		emf.close();

		
		
	}

}
