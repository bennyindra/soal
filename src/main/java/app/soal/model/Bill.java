package app.soal.model;

public class Bill extends DiscountAbstract {
	

	public Bill(User user, Double price, ItemType itemType) {
		this.price = price;
		this.user = user;
		this.itemType = itemType;
		this.forEveryDiscountBillAmount = 0d;
		this.extraDiscount = 0d;
		calculateNetPrice();
	}
	
	public Bill(User user, Double price, ItemType itemType,Double forEveryDiscountBillAmount,Double extraDiscount) {
		this.price = price;
		this.user = user;
		this.itemType = itemType;
		this.forEveryDiscountBillAmount = forEveryDiscountBillAmount;
		this.extraDiscount = extraDiscount;
		calculateNetPrice();
	}
	
	private ItemType itemType;
	
	private Double forEveryDiscountBillAmount;
	
	private Double extraDiscount;

	private User user;

	public User getUser() {
		return user;
	}
	
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
	public ItemType getItemType() {
		return itemType;
	}
	
	@Override
	public boolean applyExtraDiscount() {
		return price>getForEveryDiscountBillAmount();
	}

	@Override
	public Double getUserDiscount() {
		if (itemType!=null && !itemType.equals(ItemType.GROCERIES)) {
			System.out.println("User Category = "+getUser().getClass().getName());
			return getUser().getUserDiscount();
		}
		return 0d;
	}
	
	@Override
	public Double getForEveryDiscountBillAmount() {
		return forEveryDiscountBillAmount; 
	}
	
	@Override
	public Double getExtraDiscount() {
		return extraDiscount;
	}
	
	public void setExtraDiscount(Double extraDiscount) {
		this.extraDiscount = extraDiscount;
	}
	
	public void setForEveryDiscountBillAmount(Double forEveryDiscountBillAmount) {
		this.forEveryDiscountBillAmount = forEveryDiscountBillAmount;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public void calculateNetPrice() {
		super.calculateNetPrice();
	}
	


}
