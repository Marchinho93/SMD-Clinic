package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class ExamTypology {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long code;
	@Column(nullable =false)
	private String name;
	private String description;
	private String price;
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@Column(nullable = false)
	private List<ResultIndicator> resultIndicators;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Exam> exams;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Prerequisite> prerequisites;
	
	public ExamTypology(String name, String description, String price, List<ResultIndicator> resultIndicators) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public List<ResultIndicator> getResultIndicators() {
		return resultIndicators;
	}
	public void setResultIndicators(List<ResultIndicator> resultIndicators) {
		this.resultIndicators = resultIndicators;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams2) {
		this.exams = exams2;
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
