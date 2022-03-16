package application;

public class Customer {
	String CustomerID; 
	String CustomerName;
	String CustomerPhone;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerID, String customerName, String customerPhone) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		CustomerPhone = customerPhone;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerPhone() {
		return CustomerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		CustomerPhone = customerPhone;
	}
	

}
