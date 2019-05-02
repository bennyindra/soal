package app.soal.model;

import java.util.Calendar;
import java.util.Date;

public class User extends DiscountAbstract {
	private Date joinDate;
	private String name;
	private Double discount;

	
	public User(String name, Double discount,Date joinDate) {
		this.name = name;
		this.discount = discount;
		this.joinDate = joinDate;
	}
	
	public Date getJoinDate() {
		return joinDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	Double getUserDiscount() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getJoinDate());
		calendar.add(Calendar.YEAR, +2);
		Date date = calendar.getTime();
		
		return date.before(new Date())? discount:Double.valueOf(5) / Double.valueOf(100);
	}

}
