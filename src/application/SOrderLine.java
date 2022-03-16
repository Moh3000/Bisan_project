package application;

public class SOrderLine {
	String ItemName;
	String ItemQuantity;
	String PriceLine;
	public SOrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SOrderLine(String itemName, String itemQuantity, String priceLine) {
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
