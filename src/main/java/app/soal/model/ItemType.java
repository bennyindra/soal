package app.soal.model;

public enum ItemType {

	HEALTH_AND_BEAUTY("Health And Beauty", "HAB"),
	HOUSEHOLD("Household", "HO"),
	GROCERIES("Approved", "GR"), 
	TOOLS("Rejected", "TL"),
	OTHERS("Others", "O");
	private String value;
	
	private String code;
	
	ItemType (String value, String code) {
		this.value = value;
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
