package app.soal.model;

import java.util.Date;

public class Affiliate extends User {

	public Affiliate(String name, Date joinDate) {
		super(name, Double.valueOf(30) / Double.valueOf(100),joinDate);
	}
	
}
