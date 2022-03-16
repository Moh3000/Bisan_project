package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class home {
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "0598786818*";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "accounting";
	private Connection con;
	ObservableList<String> dayList= FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
	ObservableList<String> monthList= FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
	
	public static String Dayenter;
	public static String Monthenter;
	public static String Yearenter;
	
    @FXML
	private ChoiceBox<String> day;

    @FXML
	private ChoiceBox<String> month;
    
    @FXML
    private TextField year;
	    
    @FXML
	private PasswordField pasword;
	
	@FXML
    private Button enter;

    @FXML
    private TextField phone;
	
	@FXML
    void login(ActionEvent event) throws IOException, SQLException {
		Dayenter=day.getValue();
		Monthenter=month.getValue();
		Yearenter=year.getText();
		String returned;
		if(!(phone.getText().isEmpty())) {
			String mystring= "Select EmployeeID as CheckE from Employee where EmployeeID = " +'"' + phone.getText() +'"' + ";";
	    	PreparedStatement stmt = con.prepareStatement(mystring);
			ResultSet rs = stmt.executeQuery(); 
			if(rs.next()) {
				returned = rs.getString("CheckE");
			    	String mystring1= "Select EmployeePart as Checkp from Employee where EmployeeID = " +'"' + phone.getText() +'"' + ";";
			    	PreparedStatement stmt1 = con.prepareStatement(mystring1);
					ResultSet rs1 = stmt1.executeQuery();
					if(rs1.next()) {
			    	returned=rs1.getString("Checkp");}
					else {
						System.out.println("noooooo");
					}
			    	if(returned.equals("acounting")) {
			    		if(pasword.getText().equals("1234")) {
			    			System.out.println("test");
					        TabPane Parent = FXMLLoader.load(getClass().getResource("InAll.fxml"));
					        Scene ViewScene = new Scene(Parent);
					        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					        window.setScene(ViewScene);
					        window.show();
			    		}
			    		else {
			    			JOptionPane.showMessageDialog(null, "pasword is incorrect");
			    		}
			    		
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(null, "you dont have an acses");
			    	}
			    	
			   
			}
			else
			{
				JOptionPane.showMessageDialog(null, "This employee not found");
			}
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You must enter the data");
		}
    }
	
	 @FXML
		void initialize() throws ClassNotFoundException, SQLException {
			connectDB();
			day.setItems(dayList);
			month.setItems(monthList);
			Date date=new Date();
			SimpleDateFormat dateForm = new SimpleDateFormat("MM/dd/YYYY");
			String[] date1 = dateForm.format(date).split("/");
			String Monthe=date1[0];
			String daye=date1[1];
			String yeare=date1[2];
			day.setValue(daye);
			month.setValue(Monthe);
			year.setText(yeare);
			assert phone != null
					: "fx:id=\"Passwordtxt\" was not injected: check your FXML file 'WelcomeScreen.fxml'.";

		}

		public void connectDB() throws ClassNotFoundException, SQLException {

			dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";

			Properties p = new Properties();
			p.setProperty("user", dbUsername);
			p.setProperty("password", dbPassword);
			p.setProperty("useSSL", "false");
			p.setProperty("autoReconnect", "true");
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(dbURL, p);

		}

}
