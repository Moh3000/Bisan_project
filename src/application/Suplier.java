package application;

public class Suplier {
	String SuplierID;
	String SupllierName;
	String SuplierPhone;
	public Suplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suplier(String suplierID, String supllierName, String suplierPhone) {
		super();
		SuplierID = suplierID;
		SupllierName = supllierName;
		SuplierPhone = suplierPhone;
	}
	public String getSuplierID() {
		return SuplierID;
	}
	public void setSuplierID(String suplierID) {
		SuplierID = suplierID;
	}
	public String getSupllierName() {
		return SupllierName;
	}
	public void setSupllierName(String supllierName) {
		SupllierName = supllierName;
	}
	public String getSuplierPhone() {
		return SuplierPhone;
	}
	public void setSuplierPhone(String suplierPhone) {
		SuplierPhone = suplierPhone;
	}

}
