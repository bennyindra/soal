package soal;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import app.soal.model.Affiliate;
import app.soal.model.Bill;
import app.soal.model.Employee;
import app.soal.model.ItemType;

public class Q3Test {
	
	Affiliate affiliate;
	Bill bill;
	Employee employee;

	@Before
	public void before() throws ParseException {
		affiliate =new Affiliate("BEN", new SimpleDateFormat("ddMMyyyy").parse("01012010"));
		employee = new Employee("BUN", new SimpleDateFormat("ddMMyyyy").parse("01012019"));
	}
	//==============================================================================================================
	@Test
	public void testScenarioAffiliateNonGroceries() throws ParseException {
		bill = new Bill(affiliate, 150d, ItemType.TOOLS, 100d, 5d);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(100), bill.netPrice());
	}
	
	@Test
	public void testScenarioAffiliateNonGroceriesUnconfigured() throws ParseException {
		bill = new Bill(affiliate, 150d, ItemType.TOOLS);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(105.0), bill.netPrice());
	}


	@Test
	public void testScenarioAffiliateGroceries() throws ParseException {
		Bill bill = new Bill(affiliate, 150d, ItemType.GROCERIES, 100d, 5d);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(145), bill.netPrice());

	}
	
	@Test
	public void testScenarioAffiliateGroceriesUnconfigured() throws ParseException {
		bill = new Bill(affiliate, 150d, ItemType.GROCERIES);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(150), bill.netPrice());
	}
	//==============================================================================================================
	@Test
	public void testScenarioEmployeeNonGroceries() throws ParseException {
		bill = new Bill(employee, 150d, ItemType.TOOLS, 100d, 5d);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(137.5), bill.netPrice());
	}
	
	@Test
	public void testScenarioEmployeeNonGroceriesUnconfigured() throws ParseException {
		bill = new Bill(employee, 150d, ItemType.TOOLS);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(142.5), bill.netPrice());
	}


	@Test
	public void testScenarioEmployeeGroceries() throws ParseException {
		Bill bill = new Bill(employee, 150d, ItemType.GROCERIES, 100d, 5d);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(145), bill.netPrice());

	}
	
	@Test
	public void testScenarioEmployeeGroceriesUnconfigured() throws ParseException {
		bill = new Bill(employee, 150d, ItemType.GROCERIES);
		System.out.println("net = " + bill.netPrice());
		System.out.println("============================");
		assertEquals(Double.valueOf(150), bill.netPrice());
	}

}
