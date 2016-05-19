package model;

public class ResultRow {
	private String value;
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
