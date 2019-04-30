package app.soal.model;

import java.util.ArrayList;
import java.util.List;

public class BillSummary extends DiscountAbstract{
	
	private List<Bill> bills = new ArrayList<>();
	
	public BillSummary(List<Bill> bills) {
		this.bills = bills;
		Double sum = Double.valueOf(0);
		for (Bill bill : bills) {
			sum+=bill.netPrice();
		}
		price = sum;
	}
	
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
	public List<Bill> getBills() {
		return bills;
	}
	
	@Override
	public Double getDiscount() {
		return 0d;
	}

	
}
