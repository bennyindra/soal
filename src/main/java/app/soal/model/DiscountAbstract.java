package app.soal.model;

public abstract class DiscountAbstract {
	
	public Double netPrice() {
		return  price -(getDiscount() * price);
	}

	abstract Double getDiscount();

	Double price;
}
