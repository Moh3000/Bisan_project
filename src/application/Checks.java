package application;

public class Checks {
	String ChecksID;
	String CustomerID;
	String CheckMuch;
	String CheckDay;
	String CheckMonth;
	String CheckYear;
	public Checks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Checks(String checksID, String customerID, String checkMuch, String checkDay, String checkMonth,
			String checkYear) {
		super();
		ChecksID = checksID;
		CustomerID = customerID;
		CheckMuch = checkMuch;
		CheckDay = checkDay;
		CheckMonth = checkMonth;
		CheckYear = checkYear;
	}
	public String getChecksID() {
		return ChecksID;
	}
	public void setChecksID(String checksID) {
		ChecksID = checksID;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getCheckMuch() {
		return CheckMuch;
	}
	public void setCheckMuch(String checkMuch) {
		CheckMuch = checkMuch;
	}
	public String getCheckDay() {
		return CheckDay;
	}
	public void setCheckDay(String checkDay) {
		CheckDay = checkDay;
	}
	public String getCheckMonth() {
		return CheckMonth;
	}
	public void setCheckMonth(String checkMonth) {
		CheckMonth = checkMonth;
	}
	public String getCheckYear() {
		return CheckYear;
	}
	public void setCheckYear(String checkYear) {
		CheckYear = checkYear;
	}

}
