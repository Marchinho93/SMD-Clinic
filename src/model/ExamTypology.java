package model;

import java.util.List;
import java.util.Map;

public class ExamTypology {
	private long code;
	private String name;
	private String description;
	private Money price;
	
	private List<ResultIndicator> resultIndicators;
	private Map<Long, Exam> exams;
	private List<Prerequisite> prerequisites;
	
	public ExamTypology(String name, String description, Money price, List<ResultIndicator> resultIndicators) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.resultIndicators = resultIndicators;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Money getPrice() {
		return price;
	}
	public void setPrice(Money price) {
		this.price = price;
	}
	public List<ResultIndicator> getResultIndicators() {
		return resultIndicators;
	}
	public void setResultIndicators(List<ResultIndicator> resultIndicators) {
		this.resultIndicators = resultIndicators;
	}
	public Map<Long, Exam> getExams() {
		return exams;
	}
	public void setExams(Map<Long, Exam> exams) {
		this.exams = exams;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}

	public List<Prerequisite> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<Prerequisite> prerequisites) {
		this.prerequisites = prerequisites;
	}
	
	
}
