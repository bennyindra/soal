package soal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.soal.model.Affiliate;
import app.soal.model.Bill;
import app.soal.model.BillSummary;
import app.soal.model.Employee;

public class Q3Test {
	@Test
	public void scenarioAffiliate() throws ParseException {
		Affiliate affiliate = new Affiliate("BEN", new SimpleDateFormat("ddMMyyyy").parse("01012010"));
		List<Bill> bills = new ArrayList<>();
		for (Double i = 10d; i < 150d; i+=10d) {
			Bill bill = new Bill(affiliate, i);
			bills.add(bill);
		}
		
		BillSummary billSummary = new BillSummary(bills);
		System.out.println(billSummary.netPrice());
	}
	
	@Test
	public void scenarioEmployee() throws ParseException {
		List<Bill> bills = new ArrayList<>();
		Employee employee = new Employee("BUN", new SimpleDateFormat("ddMMyyyy").parse("01012019"));
		for (Double i = 10d; i < 150d; i+=10d) {
			Bill bill = new Bill(employee, i);
			bills.add(bill);
		}
		BillSummary billSummary = new BillSummary(bills);
		System.out.println(billSummary.netPrice());
	}
}
