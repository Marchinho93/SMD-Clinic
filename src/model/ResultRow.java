package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultRow {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String value;
	@ManyToOne
	private ResultIndicator description;
	
	public ResultRow(String value, ResultIndicator description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ResultIndicator getDescription() {
		return description;
	}

	public void setDescription(ResultIndicator description) {
		this.description = description;
	}
}
