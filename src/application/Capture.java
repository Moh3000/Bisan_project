package application;

public class Capture {
	String CaptureID;
	String CID;
	String TheCapture;
	String DayCa;
	String MonthCa;
	String YearCa;
	public Capture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Capture(String captureID, String cID, String theCapture, String dayCa, String monthCa, String yearCa) {
		super();
		CaptureID = captureID;
		CID = cID;
		TheCapture = theCapture;
		DayCa = dayCa;
		MonthCa = monthCa;
		YearCa = yearCa;
	}
	public String getCaptureID() {
		return CaptureID;
	}
	public void setCaptureID(String captureID) {
		CaptureID = captureID;
	}
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getTheCapture() {
		return TheCapture;
	}
	public void setTheCapture(String theCapture) {
		TheCapture = theCapture;
	}
	public String getDayCa() {
		return DayCa;
	}
	public void setDayCa(String dayCa) {
		DayCa = dayCa;
	}
	public String getMonthCa() {
		return MonthCa;
	}
	public void setMonthCa(String monthCa) {
		MonthCa = monthCa;
	}
	public String getYearCa() {
		return YearCa;
	}
	public void setYearCa(String yearCa) {
		YearCa = yearCa;
	}
	

}
