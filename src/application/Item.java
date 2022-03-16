package application;

public class Item {
	String ItemID;
	String ItemName;
	String ItemPrice;
	String HowMuch;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String itemID, String itemName, String itemPrice, String howMuch) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		ItemPrice = itemPrice;
		HowMuch = howMuch;
	}
	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(String itemPrice) {
		ItemPrice = itemPrice;
	}
	public String getHowMuch() {
		return HowMuch;
	}
	public void setHowMuch(String howMuch) {
		HowMuch = howMuch;
	}

}
