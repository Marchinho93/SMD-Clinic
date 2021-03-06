package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prerequisite {
	@Id
	private String name;
	@Column(nullable = false)
	private String description;
	
	public Prerequisite(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Prerequisite() {
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
	
	
}
