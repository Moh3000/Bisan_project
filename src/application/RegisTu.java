package application;

public class RegisTu {
	String RegisID;
	String CustomerID;
	String DayC;
	String MonthC;
	String YearC;
	String RegisMuch;
	public RegisTu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisTu(String regisID, String customerID, String dayC, String monthC, String yearC, String regisMuch) {
		super();
		RegisID = regisID;
		CustomerID = customerID;
		DayC = dayC;
		MonthC = monthC;
		YearC = yearC;
		RegisMuch = regisMuch;
	}
	public String getRegisID() {
		return RegisID;
	}
	public void setRegisID(String regisID) {
		RegisID = regisID;
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
	public String getRegisMuch() {
		return RegisMuch;
	}
	public void setRegisMuch(String regisMuch) {
		RegisMuch = regisMuch;
	}
	

}
