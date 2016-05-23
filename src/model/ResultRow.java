package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResultRow {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String value;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
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
