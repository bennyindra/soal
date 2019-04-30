package app.soal.model;

public class Bill extends DiscountAbstract {

	public Bill(User user, Double price) {
		this.price = price;
		this.user = user;
	}

	private User user;

	public User getUser() {
		return user;
	}

	@Override
	public Double getDiscount() {
		return price > 100d ?  getUser().getDiscount() : Double.valueOf(5) / Double.valueOf(100);
	}

}
