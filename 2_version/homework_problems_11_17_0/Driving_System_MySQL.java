import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Driving_System_MySQL {
	private static String url="jdbc:mysql://127.0.0.1:3306/mysql?useSSL=true";//after MySQL 5.5, add ...
	private static String driver="com.mysql.jdbc.Driver";
	private static Connection conn;
	private static Statement comm;
	private static ResultSet rs;
	
	public static void regDriver() {
		try {
			Class.forName(driver).newInstance();
		} catch(Exception e) {
			System.out.println("Can't create driver...");
		}
	}
	public static void conBuild() {
		try {
			SqlDB.regDriver();
			conn=DriverManager.getConnection(url,"root","");//initialization
			conn.setAutoCommit(true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Can't create mysql Connection...");
		}
	}
	public static ResultSet execQuery(String stmt) {
		try {
			SqlDB.conBuild();
			comm=conn.createStatement();
			rs=comm.executeQuery(stmt);
			return rs;
		} catch(Exception e) {
			System.out.println("Can't create statement");
			return null;
		}
	}
	public static void execUpdate(String UpdateString) {
		try {
			SqlDB.conBuild();
			comm=conn.createStatement();
			comm.executeUpdate(UpdateString);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	public static void closeDB() {
		try {
			comm.close();
			conn.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void createDatasheetDRIVER() {
		Driving_System_MySQL.execUpdate(""+
		"CREATE TABLE DRIVER("+
		"name 			CHAR(20)	NOT NULL,"+ 
		"nationality    CHAR(20)	NOT NULL,"+
		"addr			CHAR(50)	NOT NULL,"+
		"birth_yy		INT			NOT NULL"+
		"birth_mm		INT			NOT NULL"+
		"birth_dd		INT			NOT NULL"+
		"driving_type	CHAR(20)	NOT NULL"+
		"first_rece_yy	INT			NOT NULL"+
		"first_rece_mm	INT			NOT NULL"+
		"first_rece_dd	INT			NOT NULL"+
		"valid_yy		INT			NOT NULL"+
		"valid_mm		INT			NOT NULL"+
		"valid_dd		INT			NOT NULL"+
		"valid_time		INT			NOT NULL"+
		"file_number	CHAR(50) PRIMARY KEY	NOT NULL"+
		"image_path		CHAR(50)	NOT NULL"+
		"");
	}
	
	public static void createDatasheetCAR() {
		Driving_System_MySQL.execUpdate(""+
				"CREATE TABLE CAR("+
				"number_plate 	CHAR(20)	NOT NULL,"+ 
				"car_type		CHAR(20)	NOT NULL,"+
				"person			CHAR(20)	NOT NULL,"+
				"address		CHAR(20)	NOT NULL"+
				"engine_number	CHAR(20)	NOT NULL"+
				"car_iden_id	CHAR(20) PRIMARY KEY	NOT NULL"+
				"PD_yy			INT			NOT NULL"+
				"PD_mm			INT			NOT NULL"+
				"PD_dd			INT			NOT NULL"+
				"image_path		CHAR(50)	NOT NULL"+
				"speed_currency	DOUBLE		NOT NULL"+
				"speed_limite	DOUBLE		NOT NULL"+
				"weight			DOUBLE		NOT NULL"+
				"load_currency	DOUBLE		NOT NULL"+
				"load_limite	DOUBLE		NOT NULL"+
				"oil_currency	DOUBLE		NOT NULL"+
				"oil_limite		DOUBLE		NOT NULL"+
				"oil_ave_use	DOUBLE		NOT NULL"+
				"vehicle_kilometer		DOUBLE		NOT NULL"+
				"car_coefficient		DOUBLE		NOT NULL"+
				"");
	}
}