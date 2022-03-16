package application;

public class ClintData {
	String ClintName;
	String ClintBill;
	String ClintCapture;
	String ClintRegisTo;
	String ClintRegisOn;
	String ClintBalance;
	String Cday;
	String CMonth;
	String CYear;
	public ClintData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClintData(String clintName, String clintBill, String clintCapture, String clintRegisTo, String clintRegisOn,
			String clintBalance, String cday, String cMonth, String cYear) {
		super();
		ClintName = clintName;
		ClintBill = clintBill;
		ClintCapture = clintCapture;
		ClintRegisTo = clintRegisTo;
		ClintRegisOn = clintRegisOn;
		ClintBalance = clintBalance;
		Cday = cday;
		CMonth = cMonth;
		CYear = cYear;
	}
	public String getClintName() {
		return ClintName;
	}
	public void setClintName(String clintName) {
		ClintName = clintName;
	}
	public String getClintBill() {
		return ClintBill;
	}
	public void setClintBill(String clintBill) {
		ClintBill = clintBill;
	}
	public String getClintCapture() {
		return ClintCapture;
	}
	public void setClintCapture(String clintCapture) {
		ClintCapture = clintCapture;
	}
	public String getClintRegisTo() {
		return ClintRegisTo;
	}
	public void setClintRegisTo(String clintRegisTo) {
		ClintRegisTo = clintRegisTo;
	}
	public String getClintRegisOn() {
		return ClintRegisOn;
	}
	public void setClintRegisOn(String clintRegisOn) {
		ClintRegisOn = clintRegisOn;
	}
	public String getClintBalance() {
		return ClintBalance;
	}
	public void setClintBalance(String clintBalance) {
		ClintBalance = clintBalance;
	}
	public String getCday() {
		return Cday;
	}
	public void setCday(String cday) {
		Cday = cday;
	}
	public String getCMonth() {
		return CMonth;
	}
	public void setCMonth(String cMonth) {
		CMonth = cMonth;
	}
	public String getCYear() {
		return CYear;
	}
	public void setCYear(String cYear) {
		CYear = cYear;
	}
	

}
