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
	JLabel pro_title=new JLabel("��ʻϵͳ",JLabel.CENTER);
	//driver
	JLabel pro_driver=new JLabel("��ʻԱ",JLabel.CENTER);
	JButton submit_driver_create=new JButton("����");
	JButton submit_driver_inquiry=new JButton("��ѯ");
	JButton submit_driver_modify=new JButton("�޸�");
	//car
	JLabel pro_car=new JLabel("����",JLabel.CENTER);
	JButton submit_car_create=new JButton("����");
	JButton submit_car_inquiry=new JButton("��ѯ");
	JButton submit_car_modify=new JButton("�޸�");
	JButton submit_car_condition=new JButton("״̬");
	
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
		//trim() : ɾ���ַ���������ʼ�ͽ�β�Ŀո�
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
		//submit_creator.setFocusPainted(false); //ȥ����
		submit_creator.setBorderPainted(false); //ȥ�߿�
		
		this.create_jf_jp(jf_m,m,800,800,"������");
		//�����ڹرգ��ͻ�������У����������ڹرգ������������
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
				JOptionPane.showMessageDialog(null, new JLabel("<html><h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ӭ��ʹ�øü�ʻϵͳ</h2><h2>Creator : ���ݴ�ѧ ��ϢѧԺ �¹ڱ�</h2><h2>Contact : 1249591860@qq.com</h2></html>"));
				//JOptionPane.showMessageDialog(null, "���ݴ�ѧ ��ϢѧԺ �¹ڱ�\n��ӭ��ʹ�øü�ʻϵͳ\nContact : 1249591860@qq.com", "��Ϣ", JOptionPane.CLOSED_OPTION);
			}
			
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
