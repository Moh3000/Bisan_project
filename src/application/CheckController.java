package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CheckController {
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "0598786818*";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "accounting";
	private Connection con;
	
	ObservableList<String> dayList= FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
	ObservableList<String> monthList= FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
	
	 @FXML
	    private TextField AllCheckQuantity;

	    @FXML
	    private ChoiceBox<String> CheckDay;

	    @FXML
	    private ChoiceBox<String> CheckMonth;

	    @FXML
	    private TextField CheckQuantity;

	    @FXML
	    private TextField CheckYear;

	   
	
	@FXML
	void initialize() throws ClassNotFoundException, SQLException {
		connectDB();
		CheckDay.setItems(dayList);
		CheckMonth.setItems(monthList);
		AllCheckQuantity.setText(SampleController.CM);
	}
	
	
	 private void connectDB() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";

			Properties p = new Properties();
			p.setProperty("user", dbUsername);
			p.setProperty("password", dbPassword);
			p.setProperty("useSSL", "false");
			p.setProperty("autoReconnect", "true");
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(dbURL, p);
			
		}
	 
	 @FXML
	    void AddCheck(ActionEvent event) throws ClassNotFoundException, SQLException {
		 connectDB();
		 int All=0;
		 if(Integer.parseInt(CheckQuantity.getText())<=Integer.parseInt(AllCheckQuantity.getText())) {
			 All=Integer.parseInt(AllCheckQuantity.getText())-Integer.parseInt(CheckQuantity.getText());
			 AllCheckQuantity.setText(String.valueOf(All));
			 
			 String mystring="insert into checks values(0,"+SampleController.CCID+","+CheckQuantity.getText()+","
		          +CheckDay.getValue()+","+CheckMonth.getValue()+","+CheckYear.getText()+");";
			 System.out.println(mystring);
			 Statement stmt = con.createStatement();
			 stmt.execute(mystring);
		 }
		 else {
 			JOptionPane.showMessageDialog(null, "U must enter a lower value");
 		}

	    }

}
