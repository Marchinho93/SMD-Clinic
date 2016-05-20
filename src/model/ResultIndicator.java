package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResultIndicator {
	@Id
	private String description;

	public ResultIndicator(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
