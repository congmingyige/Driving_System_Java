
import java.sql.*;
import java.io.*;
import com.mysql.jdbc.Driver;

class SqlDB {
	private static String url="jdbc:mysql://127.0.0.1:3306/mysql?useSSL=true";//localhost 127.0.0.1
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
}

public class TestMySQL {
	public static void main(String[] args) throws SQLException {
		
		SqlDB.regDriver();
		System.out.println("1");
		SqlDB.conBuild();
		System.out.println("2");
		SqlDB.execUpdate("CREATE DATABASE IF NOT EXISTS DRIVING_SYSTEM");
		System.out.println("3");
		SqlDB.execUpdate("use DRIVING_SYSTEM");
		System.out.println("4");
		Driving_System_MySQL.createDatasheetDRIVER();
		Driving_System_MySQL.createDatasheetCAR();
		
		Driver d=new Driver("","","","",0,0,0,0,0,0,0,0,0,0,"","");
		//Driver d=new Driver();
		Car cc=new Car();
		Car c=new Car("","","","","","",0,0,0,"",0,0,0,0,0,0,0,0,0,0);
		d.setDatasheet();
		c.setDatasheet();
		
		System.out.println("5");
		ResultSet rs=SqlDB.execQuery("select * from DRIVER");
		//ResultSet rs=Driving_System_MySQL.execQuery("select * from user_all_tabls where table_name=DRIVER");
		
//		if (rs==null) {
//			Driving_System_MySQL.createDatasheetDRIVER();
//			Driving_System_MySQL.createDatasheetCAR();
//		}
		//
		
		SqlDB.execUpdate("delete from DRIVER");
		
		
		SqlDB.closeDB();
		
	}
}
