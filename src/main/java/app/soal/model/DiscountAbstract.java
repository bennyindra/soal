package app.soal.model;

public abstract class DiscountAbstract {
	
	private Double calculateBillDiscount(Double price) {
		try {
			return Double.valueOf(Math.floorDiv(price.intValue(), getForEveryDiscountBillAmount().intValue())*getExtraDiscount());
		} catch (java.lang.ArithmeticException e) {
			System.err.println("unconfigured extra discount");
			return 0d;
		}
		
	}
	
	private Double netPrice;
	
	protected void calculateNetPrice() {
		System.out.println(applyExtraDiscount());
		Double userDiscount = getUserDiscount();
		System.out.println("User Discount = " + userDiscount+"%");
		if (applyExtraDiscount()) {
			Double userDiscountAmount = price -(userDiscount * price);
			Double discountBill =calculateBillDiscount(userDiscountAmount);
			netPrice = userDiscountAmount -  discountBill;
			System.out.println("Bill Discount = $" + discountBill);
			
		} else {
			netPrice =  price -(userDiscount * price);	
		}
	
	}
	
	public Double netPrice() {
		return netPrice;
	}

	abstract Double getUserDiscount();
	
	public Double getForEveryDiscountBillAmount() {
		return 0d;
	}
	
	public Double getExtraDiscount() {
		return 0d;
	}
	
	public boolean applyExtraDiscount() {
		return false;
	}

	Double price =0d;
	
	Double priceAfterBillDiscount =0d;
	
}
