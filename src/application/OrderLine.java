package application;

public class OrderLine {
	String ItemName;
	String ItemQuantity;
	String PriceLine;
	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderLine(String itemName, String itemQuantity, String priceLine) {
		super();
		ItemName = itemName;
		ItemQuantity = itemQuantity;
		PriceLine = priceLine;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemQuantity() {
		return ItemQuantity;
	}
	public void setItemQuantity(String itemQuantity) {
		ItemQuantity = itemQuantity;
	}
	public String getPriceLine() {
		return PriceLine;
	}
	public void setPriceLine(String priceLine) {
		PriceLine = priceLine;
	}
	

}
