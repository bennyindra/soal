package app.soal.model;

import java.util.Date;

public class Employee extends User {

	public Employee(String name, Date joinDate) {
		super(name, Double.valueOf(10) / Double.valueOf(100),joinDate);
	}

}
