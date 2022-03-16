package application;

public class Bank {
	String BankID;
	String BankName;
	String BankPalance;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(String bankID, String bankName, String bankPalance) {
		super();
		BankID = bankID;
		BankName = bankName;
		BankPalance = bankPalance;
	}
	public String getBankID() {
		return BankID;
	}
	public void setBankID(String bankID) {
		BankID = bankID;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBankPalance() {
		return BankPalance;
	}
	public void setBankPalance(String bankPalance) {
		BankPalance = bankPalance;
	}
	

}
