
import java.sql.*;
import java.io.*;
import com.mysql.jdbc.Driver;

class SqlDB {
	private static String url="jdbc:mysql://127.0.0.1:3306/mysql";//localhost 127.0.0.1
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
	public static void main(String[] args) {
		
		SqlDB.regDriver();
		SqlDB.conBuild();
		//SqlDB.execQuery();
		//SqlDB.execUpdate();
			//System.out.println("OK");
		SqlDB.closeDB();
		
	}
}
