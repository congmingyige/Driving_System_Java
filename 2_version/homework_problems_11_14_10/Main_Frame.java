import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	Main_Frame() {

		this.create_jf_jp(jf_m,m,800,800,"主界面");
		//主窗口关闭，就会结束运行，而其它窗口关闭，不会结束运行
		jf_m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
