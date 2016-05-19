package model;

import java.util.List;

public class Result {
	private List<ResultRow> resultsRows;
	private Exam exam;
	
	public Result(List<ResultRow> resultsRows, Exam exam) {
		this.resultsRows = resultsRows;
		this.exam = exam;
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
