package app.soal.model;

public class Vertices {

	private int weight;
	private String code;
	
	public Vertices(int weigth, String code) {
		this.weight = weigth;
		this.code = code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
