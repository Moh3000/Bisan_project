package application;

public class EmployeeDaily {
	String HourlySalary;
	String DayWork;
	String MonthWork;
	String YearWork;
	String Hours;
	String Additional;
	String Advance;
	public EmployeeDaily() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDaily(String hourlySalary, String dayWork, String monthWork, String yearWork, String hours,
			String additional, String advance) {
		super();
		HourlySalary = hourlySalary;
		DayWork = dayWork;
		MonthWork = monthWork;
		YearWork = yearWork;
		Hours = hours;
		Additional = additional;
		Advance = advance;
	}
	public String getHourlySalary() {
		return HourlySalary;
	}
	public void setHourlySalary(String hourlySalary) {
		HourlySalary = hourlySalary;
	}
	public String getDayWork() {
		return DayWork;
	}
	public void setDayWork(String dayWork) {
		DayWork = dayWork;
	}
	public String getMonthWork() {
		return MonthWork;
	}
	public void setMonthWork(String monthWork) {
		MonthWork = monthWork;
	}
	public String getYearWork() {
		return YearWork;
	}
	public void setYearWork(String yearWork) {
		YearWork = yearWork;
	}
	public String getHours() {
		return Hours;
	}
	public void setHours(String hours) {
		Hours = hours;
	}
	public String getAdditional() {
		return Additional;
	}
	public void setAdditional(String additional) {
		Additional = additional;
	}
	public String getAdvance() {
		return Advance;
	}
	public void setAdvance(String advance) {
		Advance = advance;
	}

}
