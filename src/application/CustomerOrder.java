package application;

public class CustomerOrder {
	String OrderID;
	String CustomerID;
	String DayC;
	String MonthC;
	String YearC;
	String OrderPrice;
	String DeliveryMethod;
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerOrder(String orderID, String customerID, String dayC, String monthC, String yearC, String orderPrice,
			String deliveryMethod) {
		super();
		OrderID = orderID;
		CustomerID = customerID;
		DayC = dayC;
		MonthC = monthC;
		YearC = yearC;
		OrderPrice = orderPrice;
		DeliveryMethod = deliveryMethod;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getDayC() {
		return DayC;
	}
	public void setDayC(String dayC) {
		DayC = dayC;
	}
	public String getMonthC() {
		return MonthC;
	}
	public void setMonthC(String monthC) {
		MonthC = monthC;
	}
	public String getYearC() {
		return YearC;
	}
	public void setYearC(String yearC) {
		YearC = yearC;
	}
	public String getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		OrderPrice = orderPrice;
	}
	public String getDeliveryMethod() {
		return DeliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		DeliveryMethod = deliveryMethod;
	}
	

}
