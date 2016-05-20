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
import javax.persistence.OneToOne;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long code;
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private List<ResultRow> resultsRows;
	@OneToOne(fetch = FetchType.EAGER)
	private Exam exam;
	
	public Result(List<ResultRow> resultsRows, Exam exam) {
		this.resultsRows = resultsRows;
		this.exam = exam;
	}
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public List<ResultRow> getResultsRows() {
		return resultsRows;
	}
	public void setResultsRows(List<ResultRow> resultsRows) {
		this.resultsRows = resultsRows;
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
}
