package application;

public class Employee {
	String EmployeeID;
	String EmployeeName;
	String EmployeePhone;
	String EmployeePart;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeID, String employeeName, String employeePhone, String employeePart) {
		super();
		EmployeeID = employeeID;
		EmployeeName = employeeName;
		EmployeePhone = employeePhone;
		EmployeePart = employeePart;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeePhone() {
		return EmployeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		EmployeePhone = employeePhone;
	}
	public String getEmployeePart() {
		return EmployeePart;
	}
	public void setEmployeePart(String employeePart) {
		EmployeePart = employeePart;
	}
	
	

}
