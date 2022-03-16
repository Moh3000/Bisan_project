package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController {
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "0598786818*";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "accounting";
	private Connection con;

	private ObservableList<Employee> EmployeeList = FXCollections.observableArrayList();
	private ObservableList<EmployeeDaily> EDailyList = FXCollections.observableArrayList();
	private ObservableList<Bank> BankList = FXCollections.observableArrayList();
	private ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
	private ObservableList<CustomerOrder> OrderList = FXCollections.observableArrayList();
	private ObservableList<OrderLine> OrderLineList = FXCollections.observableArrayList();
	private ObservableList<Item> ItemList = FXCollections.observableArrayList();
	private ObservableList<ClintData> ClintDataList = FXCollections.observableArrayList();
	private ObservableList<AllClints> AllClintsList = FXCollections.observableArrayList();
	private ObservableList<Capture> CaptureList = FXCollections.observableArrayList();
	private ObservableList<Exchanges> ExchangesList = FXCollections.observableArrayList();
	private ObservableList<Suplier> SuplierList = FXCollections.observableArrayList();
	private ObservableList<RegisOu> RegisOuList = FXCollections.observableArrayList();
	private ObservableList<RegisTu> RegisTuList = FXCollections.observableArrayList();
	private ObservableList<SuplierOrder> SuplierOrderList = FXCollections.observableArrayList();
	private ObservableList<SOrderLine> SOrderLineList = FXCollections.observableArrayList();
	private ObservableList<Checks> ChecksList = FXCollections.observableArrayList();
	private ObservableList<Currancy> CurrancyList = FXCollections.observableArrayList();

	private ObservableList<String> From = FXCollections.observableArrayList("cash", "Bank");
	private ObservableList<String> Delivary = FXCollections.observableArrayList("He took", "We deliver");
	private ObservableList<String> CurrancyO = FXCollections.observableArrayList("NIS");
	private ObservableList<String> Pay = FXCollections.observableArrayList("cash", "Check", "both");
	private ObservableList<String> FromW = FXCollections.observableArrayList("S", "E", "060", "B", "C", "T");
	private ObservableList<String> Op = FXCollections.observableArrayList("Return", "Damege");
	ObservableList<String> dayList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
			"28", "29", "30", "31");
	ObservableList<String> monthList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12");

	String[][] Or = new String[20][4];
	String[][] SOr = new String[20][3];

	public static String CCID;
	public static String CM;

	@FXML
	private ChoiceBox<String> CUChoice;

	@FXML
	private TableColumn<Currancy, String> CUID;

	@FXML
	private TextField CUIDText;

	@FXML
	private TableColumn<Currancy, String> CUName;

	@FXML
	private TextField CUNameText;

	@FXML
	private TextField CUNewValue;

	@FXML
	private TableView<Currancy> CUTable;

	@FXML
	private TableColumn<Currancy, String> CUValue;

	@FXML
	private TextField CUValueText;

	@FXML
	private ChoiceBox<String> CACChoice;

	@FXML
	private TreeView treeView;

	@FXML
	private TextField EXsum;

	@FXML
	private ChoiceBox<String> CHCIDChoice;

	@FXML
	private ChoiceBox<String> CHDayChoiceF;

	@FXML
	private ChoiceBox<String> CHDayChoiceT;

	@FXML
	private ChoiceBox<String> CHMonthChoiceF;

	@FXML
	private ChoiceBox<String> CHMonthChoiceT;

	@FXML
	private TextField CHYearTextF;

	@FXML
	private TextField CHYearTextT;

	@FXML
	private TextArea CusOrdTArea;

	@FXML
	private TextArea SupOrdTArea;

	@FXML
	private ChoiceBox<String> Oparation;

	@FXML
	private ChoiceBox<String> OUitemID;

	@FXML
	private TableColumn<Checks, String> checkyear;

	@FXML
	private TableColumn<Checks, String> checkmonth;

	@FXML
	private TableColumn<Checks, String> checkday;

	@FXML
	private TableView<Checks> checkTable;

	@FXML
	private TableColumn<Checks, String> checkID;

	@FXML
	private TableColumn<Checks, String> ccID;

	@FXML
	private TableColumn<Checks, String> checkvalue;

	@FXML
	private TableColumn<SOrderLine, String> SPriceLine;

	@FXML
	private TableView<SOrderLine> SOrderLineTable;

	@FXML
	private TableColumn<SOrderLine, String> SOItemQuantity;

	@FXML
	private TableColumn<SOrderLine, String> SItemName;

	@FXML
	private ChoiceBox<String> SuplierNameChoice;

	@FXML
	private TableColumn<SuplierOrder, String> SYear;

	@FXML
	private TableColumn<SuplierOrder, String> SOrderID;

	@FXML
	private TableColumn<SuplierOrder, String> SOrderPrice;

	@FXML
	private TableView<SuplierOrder> SOrderTable;

	@FXML
	private TableColumn<SuplierOrder, String> SMonth;

	@FXML
	private TableColumn<SuplierOrder, String> SDay;

	@FXML
	private TableColumn<SuplierOrder, String> SID;

	@FXML
	private TextField SPriceText;

	@FXML
	private ChoiceBox<String> SItemIDChoice;

	@FXML
	private TextField SItemPriceText;

	@FXML
	private TextField SItemQuantity;

	@FXML
	private ChoiceBox<String> ROCIDChoice;

	@FXML
	private TableColumn<RegisOu, String> ROCustomerID;

	@FXML
	private TableColumn<RegisOu, String> RODay;

	@FXML
	private ChoiceBox<String> RODayChoiceF;

	@FXML
	private ChoiceBox<String> RODayChoiceT;

	@FXML
	private TableColumn<RegisOu, String> ROID;

	@FXML
	private TableColumn<RegisOu, String> ROMonth;

	@FXML
	private ChoiceBox<String> ROMonthChoiceF;

	@FXML
	private ChoiceBox<String> ROMonthChoiceT;

	@FXML
	private TableColumn<RegisOu, String> ROMuch;

	@FXML
	private TextField ROMuchText;

	@FXML
	private TableColumn<RegisOu, String> ROYear;

	@FXML
	private TextField ROYearChoiceF;

	@FXML
	private TextField ROYearChoiceT;

	@FXML
	private ChoiceBox<String> RTCIDChoice;

	@FXML
	private TableColumn<RegisTu, String> RTCustomerID;

	@FXML
	private TableColumn<RegisTu, String> RTDay;

	@FXML
	private ChoiceBox<String> RTDayChoiceF;

	@FXML
	private ChoiceBox<String> RTDayChoiceT;

	@FXML
	private TableColumn<RegisTu, String> RTID;

	@FXML
	private TableColumn<RegisTu, String> RTMonth;

	@FXML
	private ChoiceBox<String> RTMonthChoiceF;

	@FXML
	private ChoiceBox<String> RTMonthChoiceT;

	@FXML
	private TableColumn<RegisTu, String> RTMuch;

	@FXML
	private TextField RTMuchText;

	@FXML
	private TableColumn<RegisTu, String> RTYear;

	@FXML
	private TextField RTYearChoiceF;

	@FXML
	private TextField RTYearChoiceT;

	@FXML
	private TableView<RegisOu> RegisOuTable;

	@FXML
	private TableView<RegisTu> RegisTuTable;

	@FXML
	private TextField ExYearF;

	@FXML
	private TextField ExYearT;

	@FXML
	private ChoiceBox<String> ExMonthF;

	@FXML
	private ChoiceBox<String> ExMonthT;

	@FXML
	private ChoiceBox<String> ExDayF;

	@FXML
	private ChoiceBox<String> ExDayT;

	@FXML
	private TextField CaDescribe;

	@FXML
	private TextField CaMuch;

	@FXML
	private TextField EYearF;

	@FXML
	private TextField EYearT;

	@FXML
	private TextField ESalaryText;

	@FXML
	private TextField EPaiedText;

	@FXML
	private ChoiceBox<String> EMonthF;

	@FXML
	private ChoiceBox<String> EMonthT;

	@FXML
	private ChoiceBox<String> EDayF;

	@FXML
	private ChoiceBox<String> EDayT;

	@FXML
	private TextField EAdvanseText;

	@FXML
	private TextField ENameText;

	@FXML
	private TextField EPartText;

	@FXML
	private TextField EPhone;

	@FXML
	private ChoiceBox<String> Fromwho;

	@FXML
	private TextField SNameText;

	@FXML
	private TextField SPhoneText;

	@FXML
	private TextField CheckPayText;

	@FXML
	private TableColumn<Suplier, String> SuplierID;

	@FXML
	private TableColumn<Suplier, String> SuplierPhone;

	@FXML
	private TableView<Suplier> SuplierTable;

	@FXML
	private TableColumn<Suplier, String> SuplierName;

	@FXML
	private TableColumn<Exchanges, String> ExCyrr;

	@FXML
	private TableColumn<Exchanges, String> ExDay;

	@FXML
	private TableColumn<Exchanges, String> ExDes;

	@FXML
	private TableColumn<Exchanges, String> ExFrom;

	@FXML
	private TableColumn<Exchanges, String> ExFromID;

	@FXML
	private TableColumn<Exchanges, String> ExID;

	@FXML
	private TableColumn<Exchanges, String> ExMonth;

	@FXML
	private TableColumn<Exchanges, String> ExMuch;

	@FXML
	private TableColumn<Exchanges, String> ExYear;

	@FXML
	private TableView<Exchanges> ExchangeTable;

	@FXML
	private TextField YearTCa;

	@FXML
	private TextField YearFCa;

	@FXML
	private ChoiceBox<String> MonthTCa;

	@FXML
	private ChoiceBox<String> MonthFCa;

	@FXML
	private TextField HMCa;

	@FXML
	private ChoiceBox<String> DayTCa;

	@FXML
	private ChoiceBox<String> DayFCa;

	@FXML
	private ChoiceBox<String> CChoice;

	@FXML
	private TableColumn<Capture, String> YearCa;

	@FXML
	private TableColumn<Capture, String> TheCapture;

	@FXML
	private TableColumn<Capture, String> MonthCa;

	@FXML
	private TableColumn<Capture, String> DayCa;

	@FXML
	private TableColumn<Capture, String> CaptureID;

	@FXML
	private TableView<Capture> CaptureTable;

	@FXML
	private TableColumn<Capture, String> CID;

	@FXML
	private TableColumn<AllClints, String> AllClintBalance;

	@FXML
	private TableColumn<AllClints, String> AllClintName;

	@FXML
	private TableView<AllClints> AllClintsTable;

	@FXML
	private TableColumn<ClintData, String> CMonth;

	@FXML
	private TableColumn<ClintData, String> CYear;

	@FXML
	private TableColumn<ClintData, String> Cday;

	@FXML
	private TableColumn<ClintData, String> ClintBalance;

	@FXML
	private TableColumn<ClintData, String> ClintBill;

	@FXML
	private TableColumn<ClintData, String> ClintCapture;

	@FXML
	private TableColumn<ClintData, String> ClintName;

	@FXML
	private TableColumn<ClintData, String> ClintRegisOn;

	@FXML
	private TableColumn<ClintData, String> ClintRegisTo;

	@FXML
	private TableView<ClintData> DataClintTable;

	@FXML
	private TextField YearFC;

	@FXML
	private TextField YearTC;

	@FXML
	private ChoiceBox<String> MonthFC;

	@FXML
	private ChoiceBox<String> MonthTC;

	@FXML
	private ChoiceBox<String> DayFC;

	@FXML
	private ChoiceBox<String> DayTC;

	@FXML
	private ChoiceBox<String> ClintData;

	@FXML
	private ChoiceBox<String> PayMethod;

	@FXML
	private ChoiceBox<String> CurrancyChoice;

	@FXML
	private ChoiceBox<String> CustomerNameChoice;

	@FXML
	private ChoiceBox<String> DelivaryMethodChoice;

	@FXML
	private TableColumn<CustomerOrder, String> OrderID;

	@FXML
	private TableView<OrderLine> OrderLineTable;

	@FXML
	private TableColumn<CustomerOrder, String> OrderPrice;

	@FXML
	private TableView<CustomerOrder> OrderTable;

	@FXML
	private TableColumn<OrderLine, String> PriceLine;

	@FXML
	private TableColumn<CustomerOrder, String> YearC;

	@FXML
	private TableColumn<CustomerOrder, String> MonthC;

	@FXML
	private TableColumn<CustomerOrder, String> DayC;

	@FXML
	private TableColumn<CustomerOrder, String> CustomerIDO;

	@FXML
	private TableColumn<CustomerOrder, String> DeliveryMethod;

	@FXML
	private TableColumn<OrderLine, String> ItemNameO;

	@FXML
	private TableColumn<OrderLine, String> ItemQuantity;

	@FXML
	private TableColumn<Customer, String> CustomerID;

	@FXML
	private TableColumn<Customer, String> CustomerName;

	@FXML
	private TableColumn<Customer, String> CustomerPhone;

	@FXML
	private TableView<Customer> CustomerTable;

	@FXML
	private TextField CNameText;

	@FXML
	private TextField CPhoneText;

	@FXML
	private TextField OrderPriceO;

	@FXML
	private TableColumn<Item, String> HowMuch;

	@FXML
	private TextField HowMuchText;

	@FXML
	private TableColumn<Item, String> ItemID;

	@FXML
	private TableColumn<Item, String> ItemName;

	@FXML
	private TextField ItemNameText;

	@FXML
	private TableColumn<Item, String> ItemPrice;

	@FXML
	private TextField ItemPriceText;

	@FXML
	private TableView<Item> ItemTable;

	@FXML
	private TableView<Item> ItemTableS;

	@FXML
	private TableColumn<Item, String> HowMuchS;

	@FXML
	private TableColumn<Item, String> ItemIDS;

	@FXML
	private TableColumn<Item, String> ItemNameS;

	@FXML
	private TableColumn<Item, String> ItemPriceS;

	@FXML
	private ChoiceBox<String> FromE;

	@FXML
	private ChoiceBox<String> BanksNameO;

	@FXML
	private TextField HSText;

	@FXML
	private TextField HWText;

	@FXML
	private ChoiceBox<String> EIDText;

	@FXML
	private TextField AHText;

	@FXML
	private TextField ASText;

	@FXML
	private TableView<Bank> BankTable;

	@FXML
	private TableColumn<Bank, String> BankID;

	@FXML
	private TableColumn<Bank, String> BankName;

	@FXML
	private TextField BankNameText;

	@FXML
	private TextField CashPalance;

	@FXML
	private TableColumn<Bank, String> BankPalance;

	@FXML
	private TextField BankPalanceText;

	@FXML
	private TableColumn<EmployeeDaily, String> Additional;

	@FXML
	private TableColumn<EmployeeDaily, String> Advance;

	@FXML
	private TableColumn<EmployeeDaily, String> DayWork;

	@FXML
	private TableView<EmployeeDaily> EDTable;

	@FXML
	private TableView<Employee> ETable;

	@FXML
	private TableColumn<Employee, String> EmployeeID;

	@FXML
	private TableColumn<Employee, String> EmployeeName;

	@FXML
	private TableColumn<Employee, String> EmployeePart;

	@FXML
	private TableColumn<Employee, String> EmployeePhone;

	@FXML
	private TableColumn<EmployeeDaily, String> HourlySalary;

	@FXML
	private TableColumn<EmployeeDaily, String> Hours;

	@FXML
	private TableColumn<EmployeeDaily, String> MonthWork;

	@FXML
	private TableColumn<EmployeeDaily, String> YearWork;

	@FXML
	private TextField QuantityText;

	@FXML
	private TextField CustomerPayText;

	@FXML
	private TextField ChequeCostText;

	@FXML
	private TextField taxPercentage;

	@FXML
	void initialize() throws ClassNotFoundException, SQLException {
		TreeItem<String> rootItem = new TreeItem<>("Arithmatic Tree");
		TreeItem<String> Sales = new TreeItem<>("Sales");
		TreeItem<String> ItemSales = new TreeItem<>("Item Sales");
		TreeItem<String> Purchses = new TreeItem<>("Purchses");
		TreeItem<String> PurchsesItem = new TreeItem<>("Purchses Item");
		TreeItem<String> Exchanges = new TreeItem<>("Exchanges");
		TreeItem<String> Bills = new TreeItem<>("Bills");
		TreeItem<String> Water = new TreeItem<>("Water");
		TreeItem<String> Electric = new TreeItem<>("Electric");
		TreeItem<String> insurance = new TreeItem<>("insurance");
		TreeItem<String> phone = new TreeItem<>("phone");
		TreeItem<String> municipalityFees = new TreeItem<>("municipality fees");
		TreeItem<String> tax = new TreeItem<>("tax");
		TreeItem<String> BankCommissions = new TreeItem<>("Bank commissions");
		TreeItem<String> FixedAssets = new TreeItem<>("Fixed Assets");
		TreeItem<String> Salary = new TreeItem<>("Salary");
		TreeItem<String> DaliyExchange = new TreeItem<>("Daliy Exchange");
		TreeItem<String> GasAndMaintenance = new TreeItem<>("Gas And Maintenance");
		TreeItem<String> SomeStuf = new TreeItem<>("Some Stuf");
		TreeItem<String> Bonds = new TreeItem<>("Bonds");
		TreeItem<String> Capture = new TreeItem<>("Capture");
		TreeItem<String> Exchange = new TreeItem<>("Exchange");
		TreeItem<String> Limitation = new TreeItem<>("Limitation");
		TreeItem<String> TheBox = new TreeItem<>("The Box");
		TreeItem<String> CashBox = new TreeItem<>("Cash Box");
		TreeItem<String> CheckBox = new TreeItem<>("Checks Box");
		TreeItem<String> TheBanks = new TreeItem<>("The Banks");

		TheBox.getChildren().addAll(CashBox, CheckBox);
		Bonds.getChildren().addAll(Capture, Exchange, Limitation);
		Bills.getChildren().addAll(Water, Electric, insurance, phone, municipalityFees, tax, BankCommissions);
		Exchanges.getChildren().addAll(Bills, FixedAssets, Salary, DaliyExchange, GasAndMaintenance, SomeStuf);
		Purchses.getChildren().addAll(ItemSales);
		Sales.getChildren().addAll(PurchsesItem);
		rootItem.getChildren().addAll(Sales, Purchses, Exchanges, Bonds, TheBox, TheBanks);
		treeView.setRoot(rootItem);

		QuantityText.setText("0");
		OrderPriceO.setText("0");
		CustomerPayText.setText("0");
		CheckPayText.setText("0");
		DayFC.setItems(dayList);
		DayTC.setItems(dayList);
		EDayT.setItems(dayList);
		EDayF.setItems(dayList);
		DayFCa.setItems(dayList);
		DayTCa.setItems(dayList);
		ExDayT.setItems(dayList);
		ExDayF.setItems(dayList);
		CHDayChoiceT.setItems(dayList);
		CHDayChoiceF.setItems(dayList);
		RODayChoiceF.setItems(dayList);
		RODayChoiceT.setItems(dayList);
		RTDayChoiceF.setItems(dayList);
		RTDayChoiceT.setItems(dayList);
		CHMonthChoiceF.setItems(monthList);
		CHMonthChoiceT.setItems(monthList);
		ROMonthChoiceT.setItems(monthList);
		ROMonthChoiceF.setItems(monthList);
		RTMonthChoiceT.setItems(monthList);
		RTMonthChoiceF.setItems(monthList);
		MonthFC.setItems(monthList);
		MonthTC.setItems(monthList);
		EMonthF.setItems(monthList);
		EMonthT.setItems(monthList);
		MonthFCa.setItems(monthList);
		MonthTCa.setItems(monthList);
		ExMonthT.setItems(monthList);
		ExMonthF.setItems(monthList);
		Oparation.setItems(Op);
		connectDB();
		FromE.setItems(From);
		DelivaryMethodChoice.setItems(Delivary);
		CurrancyChoice.setItems(CurrancyO);
		CACChoice.setItems(CurrancyO);
		CUChoice.setItems(CurrancyO);
		Fromwho.setItems(FromW);
		PayMethod.setItems(Pay);
		String mystring = "select BankName from Bank;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			BanksNameO.getItems().add(rs.getString(1));
			PayMethod.getItems().add(rs.getString(1));
		}
		mystring = "select CustomerName from Customer";
		stmt = con.createStatement();
		rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			CustomerNameChoice.getItems().add(rs.getString(1));
			ClintData.getItems().add(rs.getString(1));
		}
		mystring = "select EmployeeID from Employee";
		stmt = con.createStatement();
		rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			EIDText.getItems().add(String.valueOf(rs.getInt(1)));
		}

		mystring = "select CustomerID from Customer";
		stmt = con.createStatement();
		rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			CChoice.getItems().add(String.valueOf(rs.getInt(1)));
			ROCIDChoice.getItems().add(String.valueOf(rs.getInt(1)));
			RTCIDChoice.getItems().add(String.valueOf(rs.getInt(1)));
			CHCIDChoice.getItems().add(String.valueOf(rs.getInt(1)));
		}
		mystring = "select ItemID from Item";
		stmt = con.createStatement();
		rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			SItemIDChoice.getItems().add(String.valueOf(rs.getInt(1)));
			OUitemID.getItems().add(String.valueOf(rs.getInt(1)));
		}
		mystring = "select SuplierName from Suplier";
		stmt = con.createStatement();
		rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			SuplierNameChoice.getItems().add(rs.getString(1));
		}
		mystring = "select CurruncyID from Curruncy";
		stmt = con.createStatement();
		rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			CurrancyChoice.getItems().add(rs.getString(1));
			// CACChoice.getItems().add(rs.getString(1));
			// CUChoice.getItems().add(rs.getString(1));
		}
		while (rs.next()) {
			// CurrancyChoice.getItems().add(rs.getString(1));
			CACChoice.getItems().add(rs.getString(1));
			// CUChoice.getItems().add(rs.getString(1));
		}
		while (rs.next()) {
			// CurrancyChoice.getItems().add(rs.getString(1));
			// CACChoice.getItems().add(rs.getString(1));
			CUChoice.getItems().add(rs.getString(1));
		}
		mystring = "select taxValue from Tax";
		stmt = con.createStatement();
		rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			taxPercentage.setText(Double.toString(rs.getDouble(1)));
		}

		getRegisTu();
		getRegisOu();
		getEmployee();
		getBank();
		getItem();
		getCustomer();
		getCustomerOrder();
		getSuplierOrder();
		getAllClints();
		getCapture();
		getExchange();
		getSuplier();
		getChecks();
		getCurrancy();

	}

	private void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName
				+ "?verifyServerCertificate=false&allowPublicKeyRetrieval=true";

		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.cj.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	private void getCurrancy() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from Curruncy";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			CurrancyList.add(new Currancy(rs.getString(1), rs.getString(2), rs.getString(3)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(CurrancyList.isEmpty());

		CUID.setCellValueFactory(new PropertyValueFactory<>("CurruncyID"));
		CUName.setCellValueFactory(new PropertyValueFactory<>("CurruncyName"));
		CUValue.setCellValueFactory(new PropertyValueFactory<>("CurruncyValue"));

		CUTable.setItems(CurrancyList);
		// System.out.println(OrderPrice.getText());

	}

	private void refreshTableCurrancy() {
		// TODO Auto-generated method stub
		try {
			CurrancyList.clear();

			String mystring = "select * from Curruncy";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				CurrancyList.add(new Currancy(rs.getString(1), rs.getString(2), rs.getString(3)));

				// one tuple at a time
				CUTable.setItems(CurrancyList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	private void getChecks() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from checks";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			ChecksList.add(new Checks(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(ChecksList.isEmpty());

		checkID.setCellValueFactory(new PropertyValueFactory<>("ChecksID"));
		ccID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		checkvalue.setCellValueFactory(new PropertyValueFactory<>("CheckMuch"));
		checkday.setCellValueFactory(new PropertyValueFactory<>("CheckDay"));
		checkmonth.setCellValueFactory(new PropertyValueFactory<>("CheckMonth"));
		checkyear.setCellValueFactory(new PropertyValueFactory<>("CheckYear"));

		checkTable.setItems(ChecksList);
		// System.out.println(OrderPrice.getText());

	}

	private void getExchange() throws SQLException {
		// TODO Auto-generated method stub
		int SUM = 0;
		String mystring = "select * from Exchanges";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			SUM = SUM + rs.getInt(8);
			ExchangesList.add(new Exchanges(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(ExchangesList.isEmpty());

		ExID.setCellValueFactory(new PropertyValueFactory<>("ExID"));
		ExFrom.setCellValueFactory(new PropertyValueFactory<>("ExFrom"));
		ExFromID.setCellValueFactory(new PropertyValueFactory<>("ExFromID"));
		ExDes.setCellValueFactory(new PropertyValueFactory<>("ExDes"));
		ExDay.setCellValueFactory(new PropertyValueFactory<>("ExDay"));
		ExMonth.setCellValueFactory(new PropertyValueFactory<>("ExMonth"));
		ExYear.setCellValueFactory(new PropertyValueFactory<>("ExYear"));
		ExMuch.setCellValueFactory(new PropertyValueFactory<>("ExMuch"));
		ExCyrr.setCellValueFactory(new PropertyValueFactory<>("ExCyrr"));

		ExchangeTable.setItems(ExchangesList);
		EXsum.setText(Integer.toString(SUM));
		// System.out.println(OrderPrice.getText());

	}

	@FXML
	void ExShowAll(ActionEvent event) throws SQLException {
		ExchangesList.clear();
		getExchange();
	}

	@FXML
	void refChecks(ActionEvent event) throws SQLException {
		ChecksList.clear();
		getChecks();
	}

	private void getCapture() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from Capture";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			CaptureList.add(new Capture(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(CaptureList.isEmpty());

		CaptureID.setCellValueFactory(new PropertyValueFactory<>("CaptureID"));
		CID.setCellValueFactory(new PropertyValueFactory<>("CID"));
		TheCapture.setCellValueFactory(new PropertyValueFactory<>("TheCapture"));
		DayCa.setCellValueFactory(new PropertyValueFactory<>("DayCa"));
		MonthCa.setCellValueFactory(new PropertyValueFactory<>("MonthCa"));
		YearCa.setCellValueFactory(new PropertyValueFactory<>("YearCa"));

		CaptureTable.setItems(CaptureList);
		// System.out.println(OrderPrice.getText());

	}

	private void getRegisTu() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from RegisUs";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			RegisTuList.add(new RegisTu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(RegisTuList.isEmpty());

		RTID.setCellValueFactory(new PropertyValueFactory<>("RegisID"));
		RTCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		RTDay.setCellValueFactory(new PropertyValueFactory<>("DayC"));
		RTMonth.setCellValueFactory(new PropertyValueFactory<>("MonthC"));
		RTYear.setCellValueFactory(new PropertyValueFactory<>("YearC"));
		RTMuch.setCellValueFactory(new PropertyValueFactory<>("RegisMuch"));

		RegisTuTable.setItems(RegisTuList);
		// System.out.println(OrderPrice.getText());

	}

	@FXML
	void ROShowALL(ActionEvent event) throws SQLException {
		RegisOuList.clear();
		getRegisOu();

	}

	@FXML
	void RTShowALL(ActionEvent event) throws SQLException {
		RegisTuList.clear();
		getRegisTu();

	}

	private void getRegisOu() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from RegisNotUs";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			RegisOuList.add(new RegisOu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(RegisOuList.isEmpty());

		ROID.setCellValueFactory(new PropertyValueFactory<>("RegisID"));
		ROCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		RODay.setCellValueFactory(new PropertyValueFactory<>("DayC"));
		ROMonth.setCellValueFactory(new PropertyValueFactory<>("MonthC"));
		ROYear.setCellValueFactory(new PropertyValueFactory<>("YearC"));
		ROMuch.setCellValueFactory(new PropertyValueFactory<>("RegisMuch"));

		RegisOuTable.setItems(RegisOuList);
		// System.out.println(OrderPrice.getText());

	}

	private void getAllClints() throws SQLException {
		// TODO Auto-generated method stub
		double Op = 0, Ca = 0, Ru = 0, Nu = 0, Ba = 0;
		String mystring = "select CustomerID,CustomerName from Customer";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			String mystring1 = "select OrderPrice from CustomerOrder Co,Customer c where c.CustomerID=Co.CustomerID && Co.CustomerID="
					+ rs.getInt(1) + ";";
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery(mystring1);
			String mystring2 = "select TheCapture from Capture Ca,Customer c where c.CustomerID=Ca.CustomerID && Ca.CustomerID="
					+ rs.getInt(1) + ";";
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(mystring2);
			String mystring3 = "select RegisMuch from RegisNotUs Nu,Customer c where c.CustomerID=Nu.CustomerID && Nu.CustomerID="
					+ rs.getInt(1) + ";";
			Statement stmt3 = con.createStatement();
			ResultSet rs3 = stmt3.executeQuery(mystring3);
			String mystring4 = "select RegisMuch from RegisUs Ru,Customer c where c.CustomerID=Ru.CustomerID && Ru.CustomerID="
					+ rs.getInt(1) + ";";
			Statement stmt4 = con.createStatement();
			ResultSet rs4 = stmt4.executeQuery(mystring4);

			while (rs1.next()) {
				Op = Op + rs1.getDouble(1);
			}
			while (rs2.next()) {
				Ca = Ca + rs2.getDouble(1);
			}
			while (rs3.next()) {
				Nu = Nu + rs3.getDouble(1);
			}
			while (rs4.next()) {
				Ru = Ru + rs4.getDouble(1);
			}
			Ba = Op + Ru - Nu - Ca;
			AllClintsList.add(new AllClints(rs.getString(2), String.valueOf(Ba)));
			Op = Ca = Ru = Nu = 0;
		}

		System.out.println(AllClintsList.isEmpty());

		AllClintName.setCellValueFactory(new PropertyValueFactory<>("ClintName"));
		AllClintBalance.setCellValueFactory(new PropertyValueFactory<>("ClintBalance"));

		AllClintsTable.setItems(AllClintsList);
		// System.out.println(OrderPrice.getText());

	}

	private void refreshTableAllClints() {
		// TODO Auto-generated method stub
		try {
			AllClintsList.clear();

			double Op = 0, Ca = 0, Ru = 0, Nu = 0, Ba = 0;
			String mystring = "select CustomerID,CustomerName from Customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				String mystring1 = "select OrderPrice from CustomerOrder Co,Customer c where c.CustomerID=Co.CustomerID && Co.CustomerID="
						+ rs.getInt(1) + ";";
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt1.executeQuery(mystring1);
				String mystring2 = "select TheCapture from Capture Ca,Customer c where c.CustomerID=Ca.CustomerID && Ca.CustomerID="
						+ rs.getInt(1) + ";";
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(mystring2);
				String mystring3 = "select RegisMuch from RegisNotUs Nu,Customer c where c.CustomerID=Nu.CustomerID && Nu.CustomerID="
						+ rs.getInt(1) + ";";
				Statement stmt3 = con.createStatement();
				ResultSet rs3 = stmt3.executeQuery(mystring3);
				String mystring4 = "select RegisMuch from RegisUs Ru,Customer c where c.CustomerID=Ru.CustomerID && Ru.CustomerID="
						+ rs.getInt(1) + ";";
				Statement stmt4 = con.createStatement();
				ResultSet rs4 = stmt4.executeQuery(mystring4);

				while (rs1.next()) {
					Op = Op + rs1.getDouble(1);
				}
				while (rs2.next()) {
					Ca = Ca + rs2.getDouble(1);
				}
				while (rs3.next()) {
					Nu = Nu + rs3.getDouble(1);
				}
				while (rs4.next()) {
					Ru = Ru + rs4.getDouble(1);
				}
				Ba = Op + Ru - Nu - Ca;
				AllClintsList.add(new AllClints(rs.getString(2), String.valueOf(Ba)));
				Op = Ca = Ru = Nu = 0;
				AllClintsTable.setItems(AllClintsList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}
	}

	private void getBank() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from Bank";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			BankList.add(new Bank(rs.getString(1), rs.getString(2), rs.getString(3)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(EmployeeList.isEmpty());

		BankID.setCellValueFactory(new PropertyValueFactory<>("BankID"));
		BankName.setCellValueFactory(new PropertyValueFactory<>("BankName"));
		BankPalance.setCellValueFactory(new PropertyValueFactory<>("BankPalance"));

		BankTable.setItems(BankList);
		// System.out.println(OrderPrice.getText());

		String mystring1 = "select * from Cash";

		double PA = 0;
		Statement stmt1 = con.createStatement();
		ResultSet rs1 = stmt1.executeQuery(mystring1);
		if (rs1.next()) {
			PA = rs1.getDouble(1);
			CashPalance.setText(String.valueOf(PA));
		}
		CashPalance.setEditable(false);

	}

	private void getCustomer() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from Customer";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			CustomerList.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(CustomerList.isEmpty());

		CustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		CustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
		CustomerPhone.setCellValueFactory(new PropertyValueFactory<>("CustomerPhone"));

		CustomerTable.setItems(CustomerList);
		// System.out.println(OrderPrice.getText());

	}

	private void getSuplier() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from Suplier";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			SuplierList.add(new Suplier(rs.getString(1), rs.getString(2), rs.getString(3)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(SuplierList.isEmpty());

		SuplierID.setCellValueFactory(new PropertyValueFactory<>("SuplierID"));
		SuplierName.setCellValueFactory(new PropertyValueFactory<>("SupllierName"));
		SuplierPhone.setCellValueFactory(new PropertyValueFactory<>("SuplierPhone"));

		SuplierTable.setItems(SuplierList);
		// System.out.println(OrderPrice.getText());

	}

	private void getEmployee() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from Employee";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			EmployeeList.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

		}
		System.out.println(EmployeeList.isEmpty());

		EmployeeID.setCellValueFactory(new PropertyValueFactory<>("EmployeeID"));
		EmployeeName.setCellValueFactory(new PropertyValueFactory<>("EmployeeName"));
		EmployeePhone.setCellValueFactory(new PropertyValueFactory<>("EmployeePhone"));
		EmployeePart.setCellValueFactory(new PropertyValueFactory<>("EmployeePart"));

		ETable.setItems(EmployeeList);
		// System.out.println(OrderPrice.getText());

	}

	private void getItem() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from Item";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			ItemList.add(new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

		}
		System.out.println(EmployeeList.isEmpty());

		ItemID.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
		ItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
		ItemPrice.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
		HowMuch.setCellValueFactory(new PropertyValueFactory<>("HowMuch"));
		ItemIDS.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
		ItemNameS.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
		ItemPriceS.setCellValueFactory(new PropertyValueFactory<>("ItemPrice"));
		HowMuchS.setCellValueFactory(new PropertyValueFactory<>("HowMuch"));

		ItemTable.setItems(ItemList);
		ItemTableS.setItems(ItemList);
		// System.out.println(OrderPrice.getText());

	}

	private void getCustomerOrder() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from CustomerOrder";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			OrderList.add(new CustomerOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(OrderList.isEmpty());

		OrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
		CustomerIDO.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		DayC.setCellValueFactory(new PropertyValueFactory<>("DayC"));
		MonthC.setCellValueFactory(new PropertyValueFactory<>("MonthC"));
		YearC.setCellValueFactory(new PropertyValueFactory<>("YearC"));
		OrderPrice.setCellValueFactory(new PropertyValueFactory<>("OrderPrice"));
		DeliveryMethod.setCellValueFactory(new PropertyValueFactory<>("DeliveryMethod"));

		OrderTable.setItems(OrderList);
		// System.out.println(OrderPrice.getText());

	}

	private void getSuplierOrder() throws SQLException {
		// TODO Auto-generated method stub
		String mystring = "select * from SuplierOrder";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			SuplierOrderList.add(new SuplierOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(SuplierOrderList.isEmpty());

		SOrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
		SID.setCellValueFactory(new PropertyValueFactory<>("SuplierID"));
		SDay.setCellValueFactory(new PropertyValueFactory<>("DayC"));
		SMonth.setCellValueFactory(new PropertyValueFactory<>("MonthC"));
		SYear.setCellValueFactory(new PropertyValueFactory<>("YearC"));
		SOrderPrice.setCellValueFactory(new PropertyValueFactory<>("OrderPrice"));

		SOrderTable.setItems(SuplierOrderList);
		// System.out.println(OrderPrice.getText());

	}

	@FXML
	void VeiwOrderLine(MouseEvent event) throws SQLException {
		OrderLineList.clear();
		CustomerOrder E = OrderTable.getSelectionModel().getSelectedItem();
		String Eid = E.getOrderID();
		System.out.println(Eid + "rrrrrrrrr");

		String mystring = "select ItemName,ItemQuantity,PriceLine from OrderLine O,Item I  where I.ItemID=O.ItemID && O.OrderID="
				+ Eid + ";";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			OrderLineList.add(new OrderLine(rs.getString(1), rs.getString(2), rs.getString(3)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(EDailyList.isEmpty());

		ItemNameO.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
		ItemQuantity.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
		PriceLine.setCellValueFactory(new PropertyValueFactory<>("PriceLine"));

		OrderLineTable.setItems(OrderLineList);

	}

	@FXML
	void SVeiwOrderLine(MouseEvent event) throws SQLException {
		SOrderLineList.clear();
		SuplierOrder E = SOrderTable.getSelectionModel().getSelectedItem();
		String Eid = E.getOrderID();
		System.out.println(Eid + "rrrrrrrrr");

		String mystring = "select ItemName,ItemQuantity,PriceLine from SuplierOrderLine O,Item I  where I.ItemID=O.ItemID && O.OrderID="
				+ Eid + ";";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			SOrderLineList.add(new SOrderLine(rs.getString(1), rs.getString(2), rs.getString(3)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}
		System.out.println(SOrderLineList.isEmpty());

		SItemName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
		SOItemQuantity.setCellValueFactory(new PropertyValueFactory<>("ItemQuantity"));
		SPriceLine.setCellValueFactory(new PropertyValueFactory<>("PriceLine"));

		SOrderLineTable.setItems(SOrderLineList);

	}

	@FXML
	void VeiwDaily(MouseEvent event) throws SQLException {
		EDailyList.clear();
		Employee E = ETable.getSelectionModel().getSelectedItem();
		String Eid = E.getEmployeeID();
		System.out.println(Eid + "rrrrrrrrr");

		String mystring = "select * from EmployeeDaily  where EmployeeID=" + '"' + Eid + '"' + ";";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);

		while (rs.next()) {
			EDailyList.add(new EmployeeDaily(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8)));

			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));

		}
		System.out.println(EDailyList.isEmpty());

		HourlySalary.setCellValueFactory(new PropertyValueFactory<>("HourlySalary"));
		DayWork.setCellValueFactory(new PropertyValueFactory<>("DayWork"));
		MonthWork.setCellValueFactory(new PropertyValueFactory<>("MonthWork"));
		YearWork.setCellValueFactory(new PropertyValueFactory<>("YearWork"));
		Hours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
		Additional.setCellValueFactory(new PropertyValueFactory<>("Additional"));
		Advance.setCellValueFactory(new PropertyValueFactory<>("Advance"));
		EDTable.setItems(EDailyList);

	}

	@FXML
	void ShowEDFT(ActionEvent event) throws SQLException {
		EDailyList.clear();
		Employee E = ETable.getSelectionModel().getSelectedItem();
		String Eid = E.getEmployeeID();
		System.out.println(Eid + "rrrrrrrrr");
		double SA = 0, AD = 0;
		int d, m, y, de, me;
		d = Integer.parseInt(EDayF.getValue());
		m = Integer.parseInt(EMonthF.getValue());

		for (y = Integer.parseInt(EYearF.getText()); y <= Integer.parseInt(EYearT.getText()); y++) {
			if (y == Integer.parseInt(EYearT.getText())) {
				me = Integer.parseInt(EMonthT.getValue());
			} else {
				me = 12;
			}
			for (; m <= me; m++) {
				if (y == Integer.parseInt(EYearT.getText()) && m == Integer.parseInt(EMonthT.getValue())) {
					de = Integer.parseInt(EDayT.getValue());
				} else {
					de = 31;
				}
				for (; d <= de; d++) {
					String mystring1 = "select * from EmployeeDaily where DayWork=" + d + "&& EmployeeID=" + Eid
							+ "&& MonthWork=" + m + "&& YearWork=" + y + ";";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(mystring1);
					if (rs1.next()) {
						EDailyList.add(new EmployeeDaily(rs1.getString(2), rs1.getString(3), rs1.getString(4),
								rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8)));
						SA = SA + ((rs1.getInt(6) + (rs1.getInt(7) * 1.5)) * rs1.getInt(2));
						AD = AD + rs1.getInt(8);
					}
				}
				d = 1;
			}
			m = 1;
		}
		System.out.println(EDailyList.isEmpty());

		ESalaryText.setText(String.valueOf(SA));
		EAdvanseText.setText(String.valueOf(AD));
		EPaiedText.setText(String.valueOf(SA - AD));
		HourlySalary.setCellValueFactory(new PropertyValueFactory<>("HourlySalary"));
		DayWork.setCellValueFactory(new PropertyValueFactory<>("DayWork"));
		MonthWork.setCellValueFactory(new PropertyValueFactory<>("MonthWork"));
		YearWork.setCellValueFactory(new PropertyValueFactory<>("YearWork"));
		Hours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
		Additional.setCellValueFactory(new PropertyValueFactory<>("Additional"));
		Advance.setCellValueFactory(new PropertyValueFactory<>("Advance"));
		EDTable.setItems(EDailyList);

	}

	@FXML
	void ConfirmPay(ActionEvent event) throws SQLException {
		Employee E = ETable.getSelectionModel().getSelectedItem();
		String Eid = E.getEmployeeID();
		String mystring = "insert into Exchanges values(0," + '"' + "E" + '"' + "," + Eid + "," + '"' + "Salary" + '"'
				+ "," + home.Dayenter + "," + home.Monthenter + "," + home.Yearenter + "," + EPaiedText.getText() + ","
				+ '"' + "NIS" + '"' + ");";
		Statement TOEXstmt = con.createStatement();
		System.out.println(mystring);
		TOEXstmt.execute(mystring);
		refreshExgange();

	}

	@FXML
	void saveED(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		double ALL = 0;
		String mystring = "insert into EmployeeDaily values(" + EIDText.getValue() + "," + HSText.getText() + ","
				+ home.Dayenter + "," + home.Monthenter + "," + home.Yearenter + "," + HWText.getText() + ","
				+ AHText.getText() + "," + ASText.getText() + ");";
		System.out.print(mystring);
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		if (FromE.getValue() == "Bank") {
			ALL = Integer.parseInt(ASText.getText());
			String TOEX = "insert into Exchanges values(0," + '"' + "E" + '"' + "," + EIDText.getValue() + "," + '"'
					+ "advance" + '"' + "," + home.Dayenter + "," + home.Monthenter + "," + home.Yearenter + "," + ALL
					+ "," + '"' + "NIS" + '"' + ");";
			Statement TOEXstmt = con.createStatement();
			System.out.println(TOEX);
			TOEXstmt.execute(TOEX);
			String mystring0 = "select BankPalance from Bank where BankName=" + '"' + BanksNameO.getValue() + '"' + ";";
			Statement stmt0 = con.createStatement();
			stmt0.execute(mystring0);
			ResultSet rs = stmt0.executeQuery(mystring0);
			if (rs.next()) {
				ALL = rs.getDouble(1) - Integer.parseInt(ASText.getText());
				String mystring1 = "update Bank set BankPalance=" + ALL + " where BankName=" + '"'
						+ BanksNameO.getValue() + '"' + ";";
				Statement stmt1 = con.createStatement();
				stmt1.execute(mystring1);
				// ResultSet rs1 = stmt0.executeQuery(mystring1);
				refreshTableBank();
			}
		} else {
			ALL = Integer.parseInt(ASText.getText());
			String TOEX = "insert into Exchanges values(0," + '"' + "E" + '"' + "," + EIDText.getValue() + "," + '"'
					+ "advance" + '"' + "," + home.Dayenter + "," + home.Monthenter + "," + home.Yearenter + "," + ALL
					+ "," + '"' + "NIS" + '"' + ");";
			Statement TOEXstmt = con.createStatement();
			System.out.print(TOEX);
			TOEXstmt.execute(TOEX);
			String mystring0 = "select CashPalance from Cash;";
			Statement stmt0 = con.createStatement();
			stmt0.execute(mystring0);
			ResultSet rs = stmt0.executeQuery(mystring0);
			if (rs.next()) {
				ALL = rs.getDouble(1) - Integer.parseInt(ASText.getText());
				;
				String mystring1 = "update Cash set CashPalance=" + ALL + ";";
				Statement stmt1 = con.createStatement();
				stmt1.execute(mystring1);
				CashPalance.setText(String.valueOf(ALL));
				refreshTableBank();
			}
		}
		refreshExgange();
		EIDText.setValue("");
		HSText.setText("");
		HWText.setText("");
		AHText.setText("");
		ASText.setText("");
		FromE.setValue("");
		BanksNameO.setValue("");
	}

	@FXML
	void CancelED(ActionEvent event) {
		EIDText.setValue("");
		FromE.setValue("");
		BanksNameO.setValue("");
		HSText.setText("");
		HWText.setText("");
		AHText.setText("");
		ASText.setText("");

	}

	@FXML
	void AddBank(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "Insert into Bank  values(0," + '"' + BankNameText.getText() + '"' + ","
				+ BankPalanceText.getText() + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		BanksNameO.getItems().add(BankNameText.getText());
		PayMethod.getItems().add(BankNameText.getText());
		refreshTableBank();

	}

	@FXML
	void DeleteBank(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		Bank e = BankTable.getSelectionModel().getSelectedItem();

		String BB = "select BankPalance from Bank where BankID=" + '"' + e.getBankID() + '"' + ";";
		Statement stmtB = con.createStatement();
		ResultSet rs = stmtB.executeQuery(BB);
		if (rs.next()) {
			CashPalance.setText(String.valueOf(Integer.parseInt(CashPalance.getText()) + rs.getDouble(1)));
		}

		String mystring = "delete from  Bank where BankID =" + '"' + e.getBankID() + '"' + ";";
		System.out.println(mystring);
		Statement stmt = con.createStatement();
		stmt.execute(mystring);

		refreshTableBank();

	}

	private void refreshTableBank() {
		// TODO Auto-generated method stub
		try {
			BankList.clear();

			String mystring = "select * from Bank";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				BankList.add(new Bank(rs.getString(1), rs.getString(2), rs.getString(3)));

				// one tuple at a time
				BankTable.setItems(BankList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void AddNewE(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "Insert into Employee  values(0," + '"' + ENameText.getText() + '"' + "," + EPhone.getText()
				+ "," + '"' + EPartText.getText() + '"' + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		mystring = "select EmployeeID from Employee";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			EIDText.getItems().add(String.valueOf(rs.getInt(1)));
		}
		refreshTableEmployee();
	}

	@FXML
	void DeleteE(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		Employee e = ETable.getSelectionModel().getSelectedItem();

		String mystring = "delete from  Employee where EmployeeID =" + '"' + e.getEmployeeID() + '"' + ";";
		System.out.println(mystring);
		Statement stmt = con.createStatement();
		stmt.execute(mystring);

		refreshTableEmployee();

	}

	private void refreshTableEmployee() {
		// TODO Auto-generated method stub
		try {
			EmployeeList.clear();

			String mystring = "select * from Employee";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				EmployeeList.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

				// one tuple at a time
				ETable.setItems(EmployeeList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void ADDItem(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "Insert into Item  values(0," + '"' + ItemNameText.getText() + '"' + ","
				+ ItemPriceText.getText() + "," + '"' + HowMuchText.getText() + '"' + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		mystring = "select ItemID from Item where ItemName=" + '"' + ItemNameText.getText() + '"' + ";";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			SItemIDChoice.getItems().add(String.valueOf(rs.getInt(1)));
			OUitemID.getItems().add(String.valueOf(rs.getInt(1)));
		}
		refreshTableItem();

	}

	@FXML
	void DeleteItem(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		Item e = ItemTable.getSelectionModel().getSelectedItem();

		String mystring = "delete from  Item where ItemID =" + '"' + e.getItemID() + '"' + ";";
		System.out.println(mystring);
		Statement stmt = con.createStatement();
		stmt.execute(mystring);

		refreshTableItem();

	}

	private void refreshTableItem() {
		// TODO Auto-generated method stub
		try {
			ItemList.clear();

			String mystring = "select * from Item";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				ItemList.add(new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

				// one tuple at a time
				ItemTable.setItems(ItemList);
				ItemTableS.setItems(ItemList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void ADDCustomer(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "Insert into Customer  values(0," + '"' + CNameText.getText() + '"' + ","
				+ CPhoneText.getText() + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		CustomerNameChoice.getItems().add(CNameText.getText());
		ClintData.getItems().add(CNameText.getText());
		mystring = "select CustomerID from Customer where CustomerName = " + '"' + CNameText.getText() + '"' + ";";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);
		while (rs.next()) {
			CChoice.getItems().add(String.valueOf(rs.getInt(1)));
			ROCIDChoice.getItems().add(String.valueOf(rs.getInt(1)));
			RTCIDChoice.getItems().add(String.valueOf(rs.getInt(1)));
		}
		refreshTableCustomer();

	}

	@FXML
	void DeleteCustomer(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		Customer e = CustomerTable.getSelectionModel().getSelectedItem();

		String mystring = "delete from  Customer where CustomerID =" + '"' + e.getCustomerID() + '"' + ";";
		System.out.println(mystring);
		Statement stmt = con.createStatement();
		stmt.execute(mystring);

		refreshTableCustomer();

	}

	private void refreshTableCustomer() {
		// TODO Auto-generated method stub
		try {
			CustomerList.clear();

			String mystring = "select * from Customer";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				CustomerList.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3)));

				// one tuple at a time
				CustomerTable.setItems(CustomerList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}
	}

	@FXML
	void ADDSuplier(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "Insert into Suplier  values(0," + '"' + SNameText.getText() + '"' + ","
				+ SPhoneText.getText() + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		SuplierNameChoice.getItems().add(SNameText.getText());
		refreshTableSuplier();
	}

	@FXML
	void DeleteSuplier(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		Suplier e = SuplierTable.getSelectionModel().getSelectedItem();

		String mystring = "delete from  Suplier where SuplierID =" + '"' + e.getSuplierID() + '"' + ";";
		System.out.println(mystring);
		Statement stmt = con.createStatement();
		stmt.execute(mystring);

		refreshTableSuplier();

	}

	private void refreshTableSuplier() {
		// TODO Auto-generated method stub
		try {
			SuplierList.clear();

			String mystring = "select * from Suplier";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				SuplierList.add(new Suplier(rs.getString(1), rs.getString(2), rs.getString(3)));

				// one tuple at a time
				SuplierTable.setItems(SuplierList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}
	}

	@FXML
	void AddToOrder(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		Item e = ItemTableS.getSelectionModel().getSelectedItem();
		int i, price = 0;
		for (i = 0; i < 20; i++) {
			System.out.println(i);
			if (Or[i][0] == null || Or[i][0] == "no") {
				Or[i][0] = e.getItemID();
				Or[i][1] = e.getItemName();
				Or[i][2] = e.getItemPrice();
				Or[i][3] = QuantityText.getText();

				break;
			}
			// System.out.println(itemID.getCellData(e));

		}

		CusOrdTArea.setText("");
		StringBuilder fieldCont = new StringBuilder("");
		for (i = 0; i < 20; i++) {
			if (Or[i][0] == null || Or[i][0] == "no") {
				break;
			}
			int P = 0;
			P = Integer.parseInt(Or[i][2]) * Integer.parseInt(Or[i][3]);
			fieldCont.append("\n" + Or[i][1] + "...." + Or[i][2] + "...." + Or[i][3] + "....." + P + "\n");
		}

		for (i = 0; i < 20; i++) {
			if (Or[i][0] == null || Or[i][0] == "no") {
				break;
			}
			System.out.println(i);
			System.out.println(Or[i][0]);
			System.out.println(Or[i][1]);
			System.out.println(Or[i][2]);
			System.out.println(Or[i][3]);
			price = price + (Integer.parseInt(Or[i][2]) * Integer.parseInt(Or[i][3]));

		}
		OrderPriceO.setText(Integer.toString(price));
		fieldCont.append("\nTotal: " + OrderPriceO.getText());
		CusOrdTArea.setText("Name/price/quantity/priceLine" + "\n\n\n" + fieldCont.toString());
		fieldCont.setLength(0);

	}

	@FXML
	void SAddToOrder(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		int i, price = 0;
		for (i = 0; i < 20; i++) {
			System.out.println(i);
			if (SOr[i][0] == null || SOr[i][0] == "no") {
				SOr[i][0] = SItemIDChoice.getValue();
				SOr[i][1] = SItemPriceText.getText();
				SOr[i][2] = SItemQuantity.getText();

				break;
			}

		}

		// System.out.println(itemID.getCellData(e));
		SupOrdTArea.setText("");
		StringBuilder fieldCont = new StringBuilder("");
		for (i = 0; i < 20; i++) {
			if (SOr[i][0] == null || SOr[i][0] == "no") {
				break;
			}
			int P = 0;
			P = Integer.parseInt(SOr[i][1]) * Integer.parseInt(SOr[i][2]);
			fieldCont.append("\n" + SOr[i][0] + "...." + SOr[i][1] + "...." + SOr[i][2] + "...." + "....." + P + "\n");
		}

		for (i = 0; i < 20; i++) {
			if (SOr[i][0] == null || SOr[i][0] == "no") {
				break;
			}
			System.out.println(i);
			System.out.println(SOr[i][0]);
			System.out.println(SOr[i][1]);
			System.out.println(SOr[i][2]);
			price = price + (Integer.parseInt(SOr[i][1]) * Integer.parseInt(SOr[i][2]));

		}
		SPriceText.setText(Integer.toString(price));
		fieldCont.append("\nTotal: " + SPriceText.getText());
		SupOrdTArea.setText("ID/price/quantity/priceLine" + "\n\n\n" + fieldCont.toString());
		fieldCont.setLength(0);

	}

	@FXML
	void DeleteFromOrder(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		Item e = ItemTableS.getSelectionModel().getSelectedItem();
		int i, price;
		price = Integer.parseInt(OrderPriceO.getText());
		for (i = 0; i < 20; i++) {
			System.out.println(i);
			if (Or[i][0] == e.getItemID()) {
				price = price - (Integer.parseInt(Or[i][2]) * Integer.parseInt(Or[i][3]));
				while (i < 19) {
					if (Or[i + 1][0] == null && Or[i][0] != null || Or[i][0] == "no" && Or[i][0] != "no") {
						Or[i][0] = null;
						Or[i][1] = null;
						Or[i][2] = null;
						Or[i][3] = null;
						break;
					} else {
						Or[i][0] = Or[i + 1][0];
						Or[i][1] = Or[i + 1][1];
						Or[i][2] = Or[i + 1][2];
						Or[i][3] = Or[i + 1][3];
						i++;
					}
				}
				break;
			}
			// System.out.println(itemID.getCellData(e));

		}

		CusOrdTArea.setText("");
		StringBuilder fieldCont = new StringBuilder("");
		for (i = 0; i < 20; i++) {
			if (Or[i][0] == null || Or[i][0] == "no") {
				break;
			}
			int P = 0;
			P = Integer.parseInt(Or[i][2]) * Integer.parseInt(Or[i][3]);
			fieldCont.append("\n" + Or[i][1] + "...." + Or[i][2] + "...." + Or[i][3] + "....." + P + "\n");
		}

		for (i = 0; i < 20; i++) {
			if (Or[i][0] == null || Or[i][0] == "no") {
				break;
			}
			System.out.println(i);
			System.out.println(Or[i][0]);
			System.out.println(Or[i][1]);
			System.out.println(Or[i][2]);
			System.out.println(Or[i][3]);
			// price=price-(Integer.parseInt(Or[i][2])*Integer.parseInt(Or[i][4]));

		}
		OrderPriceO.setText(Integer.toString(price));
		fieldCont.append("\nTotal: " + OrderPriceO.getText());
		CusOrdTArea.setText("Name/price/quantity/priceLine" + "\n\n\n" + fieldCont.toString());
		fieldCont.setLength(0);

	}

	@FXML
	void SDeleteFromOrder(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		int i, price;
		price = Integer.parseInt(SPriceText.getText());
		for (i = 0; i < 20; i++) {
			System.out.println(i);
			if (SOr[i][0] == SItemIDChoice.getValue()) {
				price = price - (Integer.parseInt(SOr[i][1]) * Integer.parseInt(SOr[i][2]));
				while (i < 19) {
					if (SOr[i + 1][0] == null && SOr[i][0] != null || SOr[i][0] == "no" && SOr[i][0] != "no") {
						SOr[i][0] = null;
						SOr[i][1] = null;
						SOr[i][2] = null;
						break;
					} else {
						SOr[i][0] = SOr[i + 1][0];
						SOr[i][1] = SOr[i + 1][1];
						SOr[i][2] = SOr[i + 1][2];
						i++;
					}
				}
				break;
			}
			// System.out.println(itemID.getCellData(e));

		}
		SupOrdTArea.setText("");
		StringBuilder fieldCont = new StringBuilder("");
		for (i = 0; i < 20; i++) {
			if (SOr[i][0] == null || SOr[i][0] == "no") {
				break;
			}
			int P = 0;
			P = Integer.parseInt(SOr[i][1]) * Integer.parseInt(SOr[i][2]);
			fieldCont.append("\n" + SOr[i][0] + "...." + SOr[i][1] + "...." + SOr[i][2] + "...." + "....." + P + "\n");
		}
		fieldCont.append("\nTotal: " + SPriceText.getText());

		SupOrdTArea.setText("ID/price/quantity/priceLine" + "\n\n\n" + fieldCont.toString());
		for (i = 0; i < 20; i++) {
			if (SOr[i][0] == null || SOr[i][0] == "no") {
				break;
			}
			System.out.println(i);
			System.out.println(SOr[i][0]);
			System.out.println(SOr[i][1]);
			System.out.println(SOr[i][2]);
			// price=price-(Integer.parseInt(Or[i][2])*Integer.parseInt(Or[i][4]));

		}
		SPriceText.setText(Integer.toString(price));

	}

	@FXML
	void ConfirmSale(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		int returned = 0;
		double p = 0;
		if (CurrancyChoice.getValue() != "NIS") {
			String CS = "select CurruncyValue from Curruncy where CurruncyID = " + '"' + CurrancyChoice.getValue() + '"'
					+ ";";
			Statement CSstmt = con.createStatement();
			ResultSet CSrs = CSstmt.executeQuery(CS);
			if (CSrs.next()) {
				p = CSrs.getDouble(1);
			}
		} else {
			p = 1;
		}
		String CID = "select CustomerID from Customer where CustomerName=" + '"' + CustomerNameChoice.getValue() + '"'
				+ ";";
		Statement stmt0 = con.createStatement();
		ResultSet rs0 = stmt0.executeQuery(CID);
		if (rs0.next()) {
			double OT = (Double.parseDouble(OrderPriceO.getText()) * Double.parseDouble(taxPercentage.getText()) / 100)
					+ Double.parseDouble(OrderPriceO.getText());
			String mystring = "insert into CustomerOrder values(0," + rs0.getInt(1) + "," + home.Dayenter + ","
					+ home.Monthenter + "," + home.Yearenter + "," + OT + "," + '"' + DelivaryMethodChoice.getValue()
					+ '"' + ");";
			Statement stmt = con.createStatement();
			stmt.execute(mystring);
			// ResultSet rs = stmt.executeQuery(mystring);
			refreshTableCustomerOrder();
			String mystring1 = "select max(OrderID) as max_id from CustomerOrder;";
			PreparedStatement stmt1 = con.prepareStatement(mystring1);
			ResultSet rs = stmt1.executeQuery();
			if (rs.next()) {
				returned = rs.getInt("max_id");
			}
			for (int i = 0; i < 20; i++) {
				if (Or[i][0] == null || Or[i][0] == "no") {
					break;
				}
				Double f = (Double.parseDouble(Or[i][2])) * (Double.parseDouble(Or[i][3]));
				String mystring2 = "Insert into OrderLine  values(" + Integer.toString(returned) + "," + Or[i][3] + ","
						+ Or[i][0] + "," + f + ");";
				Statement stmt2 = con.createStatement();
				stmt2.execute(mystring2);
				System.out.println(i);
				System.out.println(Or[i][0]);
				System.out.println(Or[i][1]);
				System.out.println(Or[i][2]);
				System.out.println(Or[i][3]);
				String ItemString = "update Item set HowMuch=HowMuch-" + Or[i][3] + " where ItemID=" + Or[i][0] + ";";
				Statement Istmt = con.createStatement();
				Istmt.execute(ItemString);
				// price=price+(Integer.parseInt(Or[i][2])*Integer.parseInt(Or[i][4]));

			}
			refreshTableItem();
			double all = 0;
			all = Integer.parseInt(CustomerPayText.getText()) * p + Integer.parseInt(CheckPayText.getText());
			String mystring3 = "insert into Capture values(0," + rs0.getInt(1) + "," + all + "," + home.Dayenter + ","
					+ home.Monthenter + "," + home.Yearenter + ");";
			Statement stmt3 = con.prepareStatement(mystring3);
			stmt3.execute(mystring3);

			if (PayMethod.getValue() == "cash" || PayMethod.getValue() == "both" || PayMethod.getValue() == "Check") {
				double All = 0;
				String mystring11 = "select CashPalance from Cash;";
				Statement stmt11 = con.createStatement();
				stmt11.execute(mystring11);
				ResultSet rs11 = stmt11.executeQuery(mystring11);
				if (rs11.next()) {
					All = rs11.getDouble(1) + Integer.parseInt(CustomerPayText.getText()) * p
							+ Integer.parseInt(CheckPayText.getText());
					String mystring12 = "update Cash set CashPalance=" + All + ";";
					Statement stmt12 = con.createStatement();
					stmt12.execute(mystring12);
					CashPalance.setText(String.valueOf(All));
					refreshTableBank();
				}
			} else {
				double All = 0;
				String Bankstring = "select BankPalance from Bank where BankName=" + '"' + PayMethod.getValue() + '"'
						+ ";";
				Statement Bankstmt = con.createStatement();
				Bankstmt.execute(Bankstring);
				ResultSet Bankrs = stmt0.executeQuery(Bankstring);
				if (Bankrs.next()) {
					All = Bankrs.getDouble(1) + Integer.parseInt(CustomerPayText.getText()) * p
							+ Integer.parseInt(CheckPayText.getText());
					String Bstring1 = "update Bank set BankPalance=" + All + " where BankName=" + '"'
							+ PayMethod.getValue() + '"' + ";";
					Statement Bstmt1 = con.createStatement();
					Bstmt1.execute(Bstring1);
					// ResultSet rs1 = stmt0.executeQuery(mystring1);
					refreshTableBank();
				}
			}

			refreshTableAllClints();
			refreshCapture();

		}
		QuantityText.setText("0");
		DelivaryMethodChoice.setValue("");
		CustomerNameChoice.setValue("");
		CurrancyChoice.setValue("");
		PayMethod.setValue("");
		CustomerPayText.setText("0");
		OrderPriceO.setText("0");
		CheckPayText.setText("0");
		CusOrdTArea.setText("");

		for (int i = 0; i < 20; i++) {
			Or[i][0] = "no";
			Or[i][1] = "no";
			Or[i][2] = "no";
			Or[i][3] = "no";

		}

	}

	@FXML
	void ConfirmPurchas(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		int returned = 0;
		String SID = "select SuplierID from Suplier where SuplierName=" + '"' + SuplierNameChoice.getValue() + '"'
				+ ";";
		Statement stmt0 = con.createStatement();
		ResultSet rs0 = stmt0.executeQuery(SID);
		if (rs0.next()) {
			String mystring = "insert into SuplierOrder values(0," + rs0.getInt(1) + "," + home.Dayenter + ","
					+ home.Monthenter + "," + home.Yearenter + "," + SPriceText.getText() + ");";
			Statement stmt = con.createStatement();
			stmt.execute(mystring);
			// ResultSet rs = stmt.executeQuery(mystring);
			refreshTableSuplierOrder();
			String mystring1 = "select max(OrderID) as max_id from SuplierOrder;";
			PreparedStatement stmt1 = con.prepareStatement(mystring1);
			ResultSet rs = stmt1.executeQuery();
			if (rs.next()) {
				returned = rs.getInt("max_id");
			}
			for (int i = 0; i < 20; i++) {
				if (SOr[i][0] == null || SOr[i][0] == "no") {
					break;
				}
				int f = (Integer.parseInt(SOr[i][1])) * (Integer.parseInt(SOr[i][2]));
				String mystring2 = "Insert into SuplierOrderLine  values(" + Integer.toString(returned) + ","
						+ SOr[i][2] + "," + SOr[i][0] + "," + f + ");";
				Statement stmt2 = con.createStatement();
				stmt2.execute(mystring2);
				System.out.println(i);
				System.out.println(SOr[i][0]);
				System.out.println(SOr[i][1]);
				System.out.println(SOr[i][2]);
				String ItemString = "update Item set HowMuch=HowMuch+" + SOr[i][2] + " where ItemID=" + SOr[i][0] + ";";
				Statement Istmt = con.createStatement();
				Istmt.execute(ItemString);
				// price=price+(Integer.parseInt(Or[i][2])*Integer.parseInt(Or[i][4]));

			}
			refreshTableItem();
			double all = 0;
			all = Integer.parseInt(SPriceText.getText());
			String mystring3 = "insert into Exchanges values(0," + '"' + "S" + '"' + "," + rs0.getInt(1) + "," + '"'
					+ "Purchase" + '"' + "," + home.Dayenter + "," + home.Monthenter + "," + home.Yearenter + "," + all
					+ "," + '"' + "NIS" + '"' + ");";
			System.out.println(mystring3);
			Statement stmt3 = con.prepareStatement(mystring3);
			stmt3.execute(mystring3);

			double All = 0;
			String mystring11 = "select CashPalance from Cash;";
			Statement stmt11 = con.createStatement();
			stmt11.execute(mystring11);
			ResultSet rs11 = stmt11.executeQuery(mystring11);
			if (rs11.next()) {
				All = rs11.getDouble(1) - Integer.parseInt(SPriceText.getText());
				String mystring12 = "update Cash set CashPalance=" + All + ";";
				Statement stmt12 = con.createStatement();
				stmt12.execute(mystring12);
				CashPalance.setText(String.valueOf(All));
			}

			refreshExgange();

		}
		SItemPriceText.setText("");
		SuplierNameChoice.setValue("");
		SItemIDChoice.setValue("");
		SItemQuantity.setText("");
		SPriceText.setText("0");
		SupOrdTArea.setText("");

		for (int i = 0; i < 20; i++) {
			SOr[i][0] = "no";
			SOr[i][1] = "no";
			SOr[i][2] = "no";

		}

	}

	@FXML
	void CanceleOrder(ActionEvent event) {
		QuantityText.setText("0");
		DelivaryMethodChoice.setValue("");
		CustomerNameChoice.setValue("");
		CurrancyChoice.setValue("");
		PayMethod.setValue("");
		CustomerPayText.setText("0");
		OrderPriceO.setText("0");
		CheckPayText.setText("0");
		CusOrdTArea.setText("");

		for (int i = 0; i < 20; i++) {
			Or[i][0] = "no";
			Or[i][1] = "no";
			Or[i][2] = "no";
			Or[i][3] = "no";

		}

	}

	@FXML
	void CancelPurchas(ActionEvent event) {
		SItemPriceText.setText("0");
		SuplierNameChoice.setValue("");
		SItemIDChoice.setValue("");
		SItemQuantity.setText("");
		SPriceText.setText("0");
		SupOrdTArea.setText("");

		for (int i = 0; i < 20; i++) {
			SOr[i][0] = "no";
			SOr[i][1] = "no";
			SOr[i][2] = "no";

		}
	}

	private void refreshTableCustomerOrder() {
		// TODO Auto-generated method stub
		try {
			OrderList.clear();

			String mystring = "select * from CustomerOrder";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				OrderList.add(new CustomerOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));

				// one tuple at a time
				CustomerTable.setItems(CustomerList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	private void refreshTableSuplierOrder() {
		// TODO Auto-generated method stub
		try {
			SuplierOrderList.clear();

			String mystring = "select * from SuplierOrder";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				SuplierOrderList.add(new SuplierOrder(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6)));

				// one tuple at a time
				SOrderTable.setItems(SuplierOrderList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void ShowData(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		ClintDataList.clear();
		int d, m, y, de, me, CID = 0;
		double Co = 0, Ca = 0, Ru = 0, Nu = 0;
		double Ba = 0;
		String CIDstring = "select CustomerID from Customer where CustomerName=" + '"' + ClintData.getValue() + '"'
				+ ";";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(CIDstring);
		if (rs.next()) {
			CID = rs.getInt(1);
		}
		d = Integer.parseInt(DayFC.getValue());
		m = Integer.parseInt(MonthFC.getValue());
		for (y = Integer.parseInt(YearFC.getText()); y <= Integer.parseInt(YearTC.getText()); y++) {
			if (y == Integer.parseInt(YearTC.getText())) {
				me = Integer.parseInt(MonthTC.getValue());
			} else {
				me = 12;
			}
			for (; m <= me; m++) {
				if (y == Integer.parseInt(YearTC.getText()) && m == Integer.parseInt(MonthTC.getValue())) {
					de = Integer.parseInt(DayTC.getValue());
				} else {
					de = 31;
				}
				for (; d <= de; d++) {
					String mystring1 = "select TheCapture from Capture CA,Customer CU  where CA.DayCa=" + d
							+ "&& CU.CustomerID=" + CID + "&& CU.CustomerID=CA.CustomerID" + "&& CA.MonthCa=" + m
							+ "&& CA.YearCa=" + y + ";";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(mystring1);
					String mystring2 = "select OrderPrice from CustomerOrder CO,Customer CU  where CO.DayC=" + d
							+ "&& CU.CustomerID=" + CID + "&& CO.CustomerID=CU.CustomerID" + "&& CO.MonthC=" + m
							+ "&& CO.YearC=" + y + ";";
					Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(mystring2);
					String mystring3 = "select RegisMuch from RegisUs RU,Customer CU  where RU.DayC=" + d
							+ "&& RU.CustomerID=" + CID + "&& RU.CustomerID=CU.CustomerID" + "&& RU.MonthC=" + m
							+ "&& RU.YearC=" + y + ";";
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery(mystring3);
					String mystring4 = "select RegisMuch from RegisNotUs NU,Customer CU  where NU.DayC=" + d
							+ "&& NU.CustomerID=" + CID + "&& NU.CustomerID=CU.CustomerID" + "&& NU.MonthC=" + m
							+ "&& NU.YearC=" + y + ";";
					Statement stmt4 = con.createStatement();
					ResultSet rs4 = stmt4.executeQuery(mystring4);

					if (rs1.next()) {
						Ca = rs1.getDouble(1);
					}
					if (rs2.next()) {
						Co = rs2.getFloat(1);
					}
					if (rs3.next()) {
						Ru = rs3.getDouble(1);
					}
					if (rs4.next()) {
						Nu = rs4.getDouble(1);
					}

					if (Ca != 0 || Co != 0 || Ru != 0 || Nu != 0) {
						System.out.println(Ca + " " + Co + " " + Ru + " " + Nu);
						Ba = Ba + Co + Ru - Ca - Nu;
						ClintDataList.add(new ClintData(ClintData.getValue(), String.valueOf(Co), String.valueOf(Ca),
								String.valueOf(Nu), String.valueOf(Ru), String.valueOf(Ba), String.valueOf(d),
								String.valueOf(m), String.valueOf(y)));

					}
					Ca = Co = Nu = Ru = 0;
				}
				d = 1;
			}
			m = 1;
		}
		ClintName.setCellValueFactory(new PropertyValueFactory<>("ClintName"));
		ClintBill.setCellValueFactory(new PropertyValueFactory<>("ClintBill"));
		ClintCapture.setCellValueFactory(new PropertyValueFactory<>("ClintCapture"));
		ClintRegisTo.setCellValueFactory(new PropertyValueFactory<>("ClintRegisTo"));
		ClintRegisOn.setCellValueFactory(new PropertyValueFactory<>("ClintRegisOn"));
		ClintBalance.setCellValueFactory(new PropertyValueFactory<>("ClintBalance"));
		Cday.setCellValueFactory(new PropertyValueFactory<>("Cday"));
		CMonth.setCellValueFactory(new PropertyValueFactory<>("CMonth"));
		CYear.setCellValueFactory(new PropertyValueFactory<>("CYear"));
		DataClintTable.setItems(ClintDataList);

	}

	@FXML
	void ShowCaFT(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		CaptureList.clear();
		int d, m, y, de, me, Cid = 0;
		Cid = Integer.parseInt(CChoice.getValue());

		d = Integer.parseInt(DayFCa.getValue());
		m = Integer.parseInt(MonthFCa.getValue());
		for (y = Integer.parseInt(YearFCa.getText()); y <= Integer.parseInt(YearTCa.getText()); y++) {
			if (y == Integer.parseInt(YearTCa.getText())) {
				me = Integer.parseInt(MonthTCa.getValue());
			} else {
				me = 12;
			}
			for (; m <= me; m++) {
				if (y == Integer.parseInt(YearTCa.getText()) && m == Integer.parseInt(MonthTCa.getValue())) {
					de = Integer.parseInt(DayTCa.getValue());
				} else {
					de = 31;
				}
				for (; d <= de; d++) {
					String mystring1 = "select * from Capture where DayCa=" + d + "&& CustomerID=" + Cid + "&& MonthCa="
							+ m + "&& YearCa=" + y + ";";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(mystring1);
					if (rs1.next()) {
						CaptureList.add(new Capture(rs1.getString(1), rs1.getString(2), rs1.getString(3),
								rs1.getString(4), rs1.getString(5), rs1.getString(6)));
					}
				}
				d = 1;
			}
			m = 1;
		}
		System.out.println(CaptureList.isEmpty());

		CaptureID.setCellValueFactory(new PropertyValueFactory<>("CaptureID"));
		CID.setCellValueFactory(new PropertyValueFactory<>("CID"));
		TheCapture.setCellValueFactory(new PropertyValueFactory<>("TheCapture"));
		DayCa.setCellValueFactory(new PropertyValueFactory<>("DayCa"));
		MonthCa.setCellValueFactory(new PropertyValueFactory<>("MonthCa"));
		YearCa.setCellValueFactory(new PropertyValueFactory<>("YearCa"));

		CaptureTable.setItems(CaptureList);

	}

	@FXML
	void ShowChecks(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		ChecksList.clear();
		int d, m, y, de, me, Cid = 0;
		Cid = Integer.parseInt(CHCIDChoice.getValue());

		d = Integer.parseInt(CHDayChoiceF.getValue());
		m = Integer.parseInt(CHMonthChoiceF.getValue());
		for (y = Integer.parseInt(CHYearTextF.getText()); y <= Integer.parseInt(CHYearTextT.getText()); y++) {
			if (y == Integer.parseInt(CHYearTextT.getText())) {
				me = Integer.parseInt(CHMonthChoiceT.getValue());
			} else {
				me = 12;
			}
			for (; m <= me; m++) {
				if (y == Integer.parseInt(CHYearTextT.getText()) && m == Integer.parseInt(CHMonthChoiceT.getValue())) {
					de = Integer.parseInt(CHDayChoiceT.getValue());
				} else {
					de = 31;
				}
				for (; d <= de; d++) {
					String mystring1 = "select * from checks where DayC=" + d + "&& CustomerID=" + Cid + "&& MonthC="
							+ m + "&& YearC=" + y + ";";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(mystring1);
					if (rs1.next()) {
						ChecksList.add(new Checks(rs1.getString(1), rs1.getString(2), rs1.getString(3),
								rs1.getString(4), rs1.getString(5), rs1.getString(6)));
					}
				}
				d = 1;
			}
			m = 1;
		}
		System.out.println(ChecksList.isEmpty());

		checkID.setCellValueFactory(new PropertyValueFactory<>("ChecksID"));
		ccID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		checkvalue.setCellValueFactory(new PropertyValueFactory<>("CheckMuch"));
		checkday.setCellValueFactory(new PropertyValueFactory<>("CheckDay"));
		checkmonth.setCellValueFactory(new PropertyValueFactory<>("CheckMonth"));
		checkyear.setCellValueFactory(new PropertyValueFactory<>("CheckYear"));

		checkTable.setItems(ChecksList);

	}

	@FXML
	void ShowAllCa(ActionEvent event) throws SQLException {
		CaptureList.clear();
		getCapture();
	}

	@FXML
	void AddCa(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		double p = 0;
		if (CACChoice.getValue() != "NIS") {
			String CS = "select CurruncyValue from Curruncy where CurruncyID = " + '"' + CACChoice.getValue() + '"'
					+ ";";
			Statement CSstmt = con.createStatement();
			ResultSet CSrs = CSstmt.executeQuery(CS);
			if (CSrs.next()) {
				p = CSrs.getDouble(1);
			}
		} else {
			p = 1;
		}
		String mystring = "Insert into Capture  values(0," + CChoice.getValue() + ","
				+ Integer.parseInt(HMCa.getText()) * p + "," + home.Dayenter + "," + home.Monthenter + ","
				+ home.Yearenter + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		refreshCapture();
		refreshTableAllClints();

	}

	private void refreshCapture() {
		// TODO Auto-generated method stub
		try {
			CaptureList.clear();

			String mystring = "select * from Capture";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				CaptureList.add(new Capture(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));

				// one tuple at a time
				CaptureTable.setItems(CaptureList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void AddEx(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "insert into Exchanges values(0," + '"' + Fromwho.getValue() + '"' + "," + 0 + "," + '"'
				+ CaDescribe.getText() + '"' + "," + home.Dayenter + "," + home.Monthenter + "," + home.Yearenter + ","
				+ CaMuch.getText() + "," + '"' + "NIS" + '"' + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		double ALL = Integer.parseInt(CaMuch.getText());
		String mystring0 = "select CashPalance from Cash;";
		Statement stmt0 = con.createStatement();
		stmt0.execute(mystring0);
		ResultSet rs = stmt0.executeQuery(mystring0);
		if (rs.next()) {
			ALL = rs.getDouble(1) - Integer.parseInt(CaMuch.getText());
			;
			String mystring1 = "update Cash set CashPalance=" + ALL + ";";
			Statement stmt1 = con.createStatement();
			stmt1.execute(mystring1);
			CashPalance.setText(String.valueOf(ALL));
		}
		refreshExgange();
		refreshTableAllClints();

	}

	private void refreshExgange() {
		// TODO Auto-generated method stub
		try {
			ExchangesList.clear();
			int SUM = 0;

			String mystring = "select * from Exchanges";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				SUM = SUM + rs.getInt(8);
				ExchangesList.add(new Exchanges(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));

				// one tuple at a time
				ExchangeTable.setItems(ExchangesList);
			}
			EXsum.setText(Integer.toString(SUM));

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void ShowExFT(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		ExchangesList.clear();
		int d, m, y, de, me, SUM = 0;

		d = Integer.parseInt(ExDayF.getValue());
		m = Integer.parseInt(ExMonthF.getValue());
		for (y = Integer.parseInt(ExYearF.getText()); y <= Integer.parseInt(ExYearT.getText()); y++) {
			if (y == Integer.parseInt(ExYearT.getText())) {
				me = Integer.parseInt(ExMonthT.getValue());
			} else {
				me = 12;
			}
			for (; m <= me; m++) {
				if (y == Integer.parseInt(ExYearT.getText()) && m == Integer.parseInt(ExMonthT.getValue())) {
					de = Integer.parseInt(ExDayT.getValue());
				} else {
					de = 31;
				}
				for (; d <= de; d++) {
					String mystring1 = "select * from Exchanges where DayEx=" + d + "&& FromWEx=" + '"'
							+ Fromwho.getValue() + '"' + "&& MonthEx=" + m + "&& YearEx=" + y + ";";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(mystring1);
					if (rs1.next()) {
						SUM = SUM + rs1.getInt(8);
						ExchangesList.add(new Exchanges(rs1.getString(1), rs1.getString(2), rs1.getString(3),
								rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7),
								rs1.getString(8), rs1.getString(9)));
					}
				}
				d = 1;
			}
			m = 1;
		}
		System.out.println(ExchangesList.isEmpty());

		ExID.setCellValueFactory(new PropertyValueFactory<>("ExID"));
		ExFrom.setCellValueFactory(new PropertyValueFactory<>("ExFrom"));
		ExFromID.setCellValueFactory(new PropertyValueFactory<>("ExFromID"));
		ExDes.setCellValueFactory(new PropertyValueFactory<>("ExDes"));
		ExDay.setCellValueFactory(new PropertyValueFactory<>("ExDay"));
		ExMonth.setCellValueFactory(new PropertyValueFactory<>("ExMonth"));
		ExYear.setCellValueFactory(new PropertyValueFactory<>("ExYear"));
		ExMuch.setCellValueFactory(new PropertyValueFactory<>("ExMuch"));
		ExCyrr.setCellValueFactory(new PropertyValueFactory<>("ExCyrr"));

		ExchangeTable.setItems(ExchangesList);
		EXsum.setText(Integer.toString(SUM));

	}

	@FXML
	void RTShow(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		RegisTuList.clear();
		int d, m, y, de, me, Cid = 0;
		Cid = Integer.parseInt(RTCIDChoice.getValue());

		d = Integer.parseInt(RTDayChoiceF.getValue());
		m = Integer.parseInt(RTMonthChoiceF.getValue());
		for (y = Integer.parseInt(RTYearChoiceF.getText()); y <= Integer.parseInt(RTYearChoiceT.getText()); y++) {
			if (y == Integer.parseInt(RTYearChoiceT.getText())) {
				me = Integer.parseInt(RTMonthChoiceT.getValue());
			} else {
				me = 12;
			}
			for (; m <= me; m++) {
				if (y == Integer.parseInt(RTYearChoiceT.getText())
						&& m == Integer.parseInt(RTMonthChoiceT.getValue())) {
					de = Integer.parseInt(RTDayChoiceT.getValue());
				} else {
					de = 31;
				}
				for (; d <= de; d++) {
					String mystring1 = "select * from RegisUs where DayC=" + d + "&& CustomerID=" + Cid + "&& MonthC="
							+ m + "&& YearC=" + y + ";";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(mystring1);
					if (rs1.next()) {
						RegisTuList.add(new RegisTu(rs1.getString(1), rs1.getString(2), rs1.getString(3),
								rs1.getString(4), rs1.getString(5), rs1.getString(6)));
					}
				}
				d = 1;
			}
			m = 1;
		}
		System.out.println(RegisTuList.isEmpty());

		RTID.setCellValueFactory(new PropertyValueFactory<>("RegisID"));
		RTCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		RTDay.setCellValueFactory(new PropertyValueFactory<>("DayC"));
		RTMonth.setCellValueFactory(new PropertyValueFactory<>("MonthC"));
		RTYear.setCellValueFactory(new PropertyValueFactory<>("YearC"));
		RTMuch.setCellValueFactory(new PropertyValueFactory<>("RegisMuch"));

		RegisTuTable.setItems(RegisTuList);

	}

	@FXML
	void RTADD(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "Insert into RegisUs  values(0," + RTCIDChoice.getValue() + "," + home.Dayenter + ","
				+ home.Monthenter + "," + home.Yearenter + "," + RTMuchText.getText() + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		refreshRegisTu();
		refreshTableAllClints();

	}

	private void refreshRegisTu() {
		// TODO Auto-generated method stub
		try {
			RegisTuList.clear();

			String mystring = "select * from RegisUs";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				RegisTuList.add(new RegisTu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));

				// one tuple at a time
				RegisTuTable.setItems(RegisTuList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void ROShow(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		RegisOuList.clear();
		int d, m, y, de, me, Cid = 0;
		Cid = Integer.parseInt(ROCIDChoice.getValue());

		d = Integer.parseInt(RODayChoiceF.getValue());
		m = Integer.parseInt(ROMonthChoiceF.getValue());
		for (y = Integer.parseInt(ROYearChoiceF.getText()); y <= Integer.parseInt(ROYearChoiceT.getText()); y++) {
			if (y == Integer.parseInt(ROYearChoiceT.getText())) {
				me = Integer.parseInt(ROMonthChoiceT.getValue());
			} else {
				me = 12;
			}
			for (; m <= me; m++) {
				if (y == Integer.parseInt(ROYearChoiceT.getText())
						&& m == Integer.parseInt(ROMonthChoiceT.getValue())) {
					de = Integer.parseInt(RODayChoiceT.getValue());
				} else {
					de = 31;
				}
				for (; d <= de; d++) {
					String mystring1 = "select * from RegisNotUs where DayC=" + d + "&& CustomerID=" + Cid
							+ "&& MonthC=" + m + "&& YearC=" + y + ";";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(mystring1);
					if (rs1.next()) {
						RegisOuList.add(new RegisOu(rs1.getString(1), rs1.getString(2), rs1.getString(3),
								rs1.getString(4), rs1.getString(5), rs1.getString(6)));
					}
				}
				d = 1;
			}
			m = 1;
		}
		System.out.println(RegisOuList.isEmpty());

		ROID.setCellValueFactory(new PropertyValueFactory<>("RegisID"));
		ROCustomerID.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
		RODay.setCellValueFactory(new PropertyValueFactory<>("DayC"));
		ROMonth.setCellValueFactory(new PropertyValueFactory<>("MonthC"));
		ROYear.setCellValueFactory(new PropertyValueFactory<>("YearC"));
		ROMuch.setCellValueFactory(new PropertyValueFactory<>("RegisMuch"));

		RegisOuTable.setItems(RegisOuList);

	}

	@FXML
	void ROADD(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		int IID = 0;
		double ROM = 0;
		String MY = "select ItemPrice from Item where ItemID=" + OUitemID.getValue() + ";";
		Statement stmtMY = con.createStatement();
		ResultSet rs = stmtMY.executeQuery(MY);
		if (rs.next()) {
			IID = rs.getInt(1);
		}
		ROM = IID * Integer.parseInt(ROMuchText.getText());
		String mystring = "Insert into RegisNotUs  values(0," + ROCIDChoice.getValue() + "," + home.Dayenter + ","
				+ home.Monthenter + "," + home.Yearenter + "," + ROM + ");";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		refreshRegisOu();
		if (Oparation.getValue() == "Return") {
			String ItemString = "update Item set HowMuch=HowMuch+" + ROMuchText.getText() + " where ItemID="
					+ OUitemID.getValue() + ";";
			Statement Istmt = con.createStatement();
			Istmt.execute(ItemString);
		}
		refreshTableItem();
		refreshTableAllClints();

	}

	private void refreshRegisOu() {
		// TODO Auto-generated method stub
		try {
			RegisOuList.clear();

			String mystring = "select * from RegisNotUs";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mystring);
			while (rs.next()) {
				RegisOuList.add(new RegisOu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));

				// one tuple at a time
				RegisOuTable.setItems(RegisOuList);
			}

		} catch (SQLException ex) {
			// TODO: handle exception
		}

	}

	@FXML
	void AddCu(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();

		String mystring = "Insert into Curruncy  values(" + '"' + CUIDText.getText() + '"' + "," + '"'
				+ CUNameText.getText() + '"' + "," + CUValueText.getText() + ");";

		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();

		stmt.execute(mystring);
		add_CUChoice();
		add_CACChoice();
		add_CurrancyChoice();

		refreshTableCurrancy();

	}

	void add_CUChoice() {
		CUChoice.getItems().add(CUIDText.getText());

	}

	void add_CACChoice() {
		CACChoice.getItems().add(CUIDText.getText());
	}

	void add_CurrancyChoice() {
		CurrancyChoice.getItems().add(CUIDText.getText());
	}

	@FXML
	void UpdateCu(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "update Curruncy set CurruncyValue= " + CUNewValue.getText() + " where CurruncyID=" + '"'
				+ CUChoice.getValue() + '"' + ";";
		System.out.println(mystring);
		// ExecuteStatement("Insert into Suppliers
		// values("+Integer.parseInt(idtxt.getText())+","+nametxt.getText()+","+phonetxt.getText()+","+emailtxt.getText()+","+locationtxt.getText());
		Statement stmt = con.createStatement();
		stmt.execute(mystring);
		refreshTableCurrancy();

	}

	@FXML
	void updateTax(ActionEvent event) throws ClassNotFoundException, SQLException {
		connectDB();
		String mystring = "update Tax set taxValue= " + taxPercentage.getText() + ";";
		System.out.println(mystring);
		Statement stmt = con.createStatement();
		stmt.execute(mystring);

	}

	@FXML
	void ManegeCheck(ActionEvent event) throws IOException, SQLException {
		String mystring = "select CustomerID from Customer where CustomerName=" + '"' + CustomerNameChoice.getValue()
				+ '"' + ";";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(mystring);
		if (rs.next()) {
			CCID = Integer.toString(rs.getInt(1));
		}
		CM = CheckPayText.getText();

		final Stage primaryStage = null;
		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.initOwner(primaryStage);
		Pane pane = (Pane) FXMLLoader.load(getClass().getResource("Checks.fxml"));
		// pane.getChildren().add(new Text("This is a Dialog"));
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		dialog.setScene(scene);
		dialog.show();

	}

}
