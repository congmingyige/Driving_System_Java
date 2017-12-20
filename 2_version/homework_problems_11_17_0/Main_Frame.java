import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Main_Frame extends Basic_Frame {
	
	JFrame jf_m=new JFrame();
	JPanel m=new JPanel();
	//title
	JLabel pro_title=new JLabel("驾驶系统",JLabel.CENTER);
	//driver
	JLabel pro_driver=new JLabel("驾驶员",JLabel.CENTER);
	JButton submit_driver_create=new JButton("创建");
	JButton submit_driver_inquiry=new JButton("查询");
	JButton submit_driver_modify=new JButton("修改");
	//car
	JLabel pro_car=new JLabel("汽车",JLabel.CENTER);
	JButton submit_car_create=new JButton("创建");
	JButton submit_car_inquiry=new JButton("查询");
	JButton submit_car_modify=new JButton("修改");
	JButton submit_car_condition=new JButton("状态");
	
	JButton submit_creator=new JButton("@creator");

	public static void getDatabaseData() throws SQLException {
		ResultSet rs=Driving_System_MySQL.execQuery("select * from DRIVER");
		if (rs!=null) {
			while (rs.next()) {
				Driving_System.driver_count++;
				Driving_System.driver[Driving_System.driver_count]=new Driver();
				Driving_System.driver[Driving_System.driver_count].getDatasheet(rs);
			}			
		}
		
		rs=Driving_System_MySQL.execQuery("select * from CAR");
		if (rs!=null) {
			while (rs.next()) {
				Driving_System.car_count++;
				Driving_System.car[Driving_System.car_count]=new Car();
				Driving_System.car[Driving_System.car_count].getDatasheet(rs);
			}
		}
		if (rs!=null)
			rs.close();
	}
	
	public static void setDatabaseData() {
		//trim() : 删除字符串所有起始和结尾的空格
		Driving_System_MySQL.execUpdate("delete from DRIVER");
		Driving_System_MySQL.execUpdate("delete from CAR");
		for (int i=1;i<=Driving_System.driver_count;i++)
			Driving_System_MySQL.execUpdate(Driving_System.driver[i].setDatasheet());
		for (int i=1;i<=Driving_System.car_count;i++)
			Driving_System_MySQL.execUpdate(Driving_System.car[i].setDatasheet());
	}
	
	Main_Frame() {
		try {
			Driving_System_MySQL.regDriver();
			Driving_System_MySQL.conBuild();
			
			Driving_System_MySQL.execUpdate("create DATABASE if not exists DRIVING_SYSTEM");
			Driving_System_MySQL.execUpdate("use DRIVING_SYSTEM");
			ResultSet rs=Driving_System_MySQL.execQuery("select * from USER_ALL_TABLES where table_name='DRIVER'");
			if (rs==null) {
				Driving_System_MySQL.createDatasheetDRIVER();
				Driving_System_MySQL.createDatasheetCAR();
			}
			else
				Main_Frame.getDatabaseData();
			
			jf_m.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					Main_Frame.setDatabaseData();
					Driving_System_MySQL.closeDB();
				}
			});
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
		//title
		this.JLabel_add(pro_title,m,100,50,600,50);
		pro_title.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		//driver_operation
		this.JLabel_add(pro_driver,m,100,150,600,100);
		pro_driver.setBorder(BorderFactory.createLineBorder(Color.red));
		this.JButton_add(submit_driver_create,m,100,250,150,100);
		this.JButton_add(submit_driver_inquiry,m,250,250,150,100);
		this.JButton_add(submit_driver_modify,m,400,250,150,100);

		//car
		this.JLabel_add(pro_car,m,100,400,600,100);
		pro_car.setBorder(BorderFactory.createLineBorder(Color.red));
		this.JButton_add(submit_car_create,m,100,500,150,100);
		this.JButton_add(submit_car_inquiry,m,250,500,150,100);
		this.JButton_add(submit_car_modify,m,400,500,150,100);
		this.JButton_add(submit_car_condition,m,550,500,150,100);
		
		this.JButton_add(submit_creator,m,550,650,150,50);
		//submit_creator.setFocusPainted(false); //去焦点
		submit_creator.setBorderPainted(false); //去边框
		
		this.create_jf_jp(jf_m,m,800,800,"主界面");
		//主窗口关闭，就会结束运行，而其它窗口关闭，不会结束运行
		jf_m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			//driver
			if (e.getSource()==submit_driver_create) {
				Driver_Frame df=new Driver_Frame(1);
			}
			else if (e.getSource()==submit_driver_inquiry) {
				Driver_Verify_Frame dvf=new Driver_Verify_Frame(2);
			}
			else if (e.getSource()==submit_driver_modify) {
				Driver_Verify_Frame dvf=new Driver_Verify_Frame(3);
			}
			//car
			else if (e.getSource()==submit_car_create) {
				Car_Frame df=new Car_Frame(1);
			}
			else if (e.getSource()==submit_car_inquiry) {
				Car_Verify_Frame cvf=new Car_Verify_Frame(2);
			}
			else if (e.getSource()==submit_car_modify) {
				Car_Verify_Frame cvf=new Car_Verify_Frame(3);
			}
			else if (e.getSource()==submit_car_condition) {
				Car_Verify_Frame cvf=new Car_Verify_Frame(4);
			}
			//author
			else if (e.getSource()==submit_creator) {
				JOptionPane.showMessageDialog(null, new JLabel("<html><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您使用该驾驶系统</h2><h2>Creator : 兰州大学 信息学院 陈冠斌</h2><h2>Contact : 1249591860@qq.com</h2></html>"));
				//JOptionPane.showMessageDialog(null, "兰州大学 信息学院 陈冠斌\n欢迎您使用该驾驶系统\nContact : 1249591860@qq.com", "信息", JOptionPane.CLOSED_OPTION);
			}
			
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
