package application;

public class Currancy {
	String CurruncyID;
	String CurruncyName;
	String CurruncyValue;
	public Currancy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Currancy(String curruncyID, String curruncyName, String curruncyValue) {
		super();
		CurruncyID = curruncyID;
		CurruncyName = curruncyName;
		CurruncyValue = curruncyValue;
	}
	public String getCurruncyID() {
		return CurruncyID;
	}
	public void setCurruncyID(String curruncyID) {
		CurruncyID = curruncyID;
	}
	public String getCurruncyName() {
		return CurruncyName;
	}
	public void setCurruncyName(String curruncyName) {
		CurruncyName = curruncyName;
	}
	public String getCurruncyValue() {
		return CurruncyValue;
	}
	public void setCurruncyValue(String curruncyValue) {
		CurruncyValue = curruncyValue;
	}
	

}
