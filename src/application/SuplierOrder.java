package application;

public class SuplierOrder {
	String OrderID;
	String SuplierID;
	String DayC;
	String MonthC;
	String YearC;
	String OrderPrice;
	public SuplierOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SuplierOrder(String orderID, String suplierID, String dayC, String monthC, String yearC,
			String orderPrice) {
		super();
		OrderID = orderID;
		SuplierID = suplierID;
		DayC = dayC;
		MonthC = monthC;
		YearC = yearC;
		OrderPrice = orderPrice;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getSuplierID() {
		return SuplierID;
	}
	public void setSuplierID(String customerID) {
		SuplierID = customerID;
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
	

}
