
import java.sql.*;

class SqlDB {
	private static String url="jdbc:mysql://127.0.0.1:3306/driving_system?useSSL=true"; 
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
			comm.executeUpdate(UpdateString);	//int
		} catch(Exception e) {
			e.getMessage();
		}
		//return -1;
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
		SqlDB.conBuild();
		
		Driving_System_MySQL.regDriver();
		Driving_System_MySQL.conBuild();
		
		SqlDB.execUpdate("CREATE DATABASE IF NOT EXISTS DRIVING_SYSTEM");
		SqlDB.execUpdate("use DRIVING_SYSTEM");
		
//		String str=""+
//				"CREATE TABLE DRIVER1("+
//				"id				int			NOT NULL auto_increment,"+
//				"name 			CHAR(20)	NOT NULL,"+
//				"nationality    CHAR(20)	NOT NULL,"+
//				"addr			CHAR(50)	NOT NULL,"+
//				"birth_yy		INT			NOT NULL,"+
//				"birth_mm		INT			NOT NULL,"+
//				"birth_dd		INT			NOT NULL,"+
//				"PRIMARY KEY (id)"+
//				")";		
//		SqlDB.execUpdate(str);
		
		Driving_System_MySQL.createTableDRIVER();
		Driving_System_MySQL.createTableCAR();
		
		//已经存在内设的java函数，需要把类名从Driver改为其它才行		//Driver d=new Driver("","","",0,0,0,"",0,0,0,0,0,0,0,"","");
		CarDriver d=new CarDriver("","","",0,0,0,"",0,0,0,0,0,0,0,"","");
//		System.out.println("1");
		Car c=new Car("","","","","","",0,0,0,"",0,0,0,0,0,0,0,0,0,0);
//		System.out.println("2");
		d.setTable();
		c.setTable();
//		System.out.println("3");
		
		//ResultSet rs=Driving_System_MySQL.execQuery("select * from user_all_tables where table_name=DRIVER");
//		ResultSet rs1=SqlDB.execQuery("SELECT * FROM DRIVER");
//		ResultSet rs2=SqlDB.execQuery("SELECT * FROM CAR");
		
		//ResultSet rs=Driving_System_MySQL.execQuery("select * from user_all_tables where table_name=DRIVER");
		
//		if (rs==null) {
//			Driving_System_MySQL.createDatasheetDRIVER();
//			Driving_System_MySQL.createDatasheetCAR();
//		}
		//
		
//		SqlDB.execUpdate("delete from DRIVER");
//		SqlDB.execUpdate("delete from CAR");
		
		SqlDB.closeDB();
		Driving_System_MySQL.closeDB();
		
	}
}
