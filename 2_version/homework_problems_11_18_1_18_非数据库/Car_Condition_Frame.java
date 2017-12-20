import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Car_Condition_Frame extends Basic_Frame{
	//这个界面长期存在，所以创建变量合算
	int car_index;
	Car car;
	int mouse_position,mouse_position_previous=-1;
	
	double speed_limite;
	double load_limite;
	double oil_total;
	double oil_ave_use;
	double speed_currency;
	double load_currency;
	double oil_currency;
	double vehicle_kilometer;
	double speed_modify;
	double load_modify;
	double oil_modify;
	double runmile;
	double runmile_guess;
	
	JFrame jf_cc=new JFrame();
//	JPanel cc=new JPanel();
	JPanel jp0=new JPanel();
	JPanel jp1=new JPanel();
	JPanel jp2=new JPanel();
	JPanel jp3=new JPanel();
	
	//top_left
	JButton submit_car_speed_up=new JButton("加速");
	JTextField text_car_speed_modify =new JTextField(20);
	JButton submit_car_speed_down=new JButton("减速");

	JLabel pro_car_speed_currency=new JLabel("当前速度");
	JTextField text_car_speed_currency=new JTextField(20);
	JLabel pro_car_speed_limite=new JLabel("速度上限");
	JTextField text_car_speed_limite=new JTextField(20);

	//top_right
	JButton submit_car_load_up=new JButton("加重");
	JTextField text_car_load_modify =new JTextField(20);
	JButton submit_car_load_down=new JButton("减重");
	
	JLabel pro_car_load_currency=new JLabel("当前负载");
	JTextField text_car_load_currency=new JTextField(20);
	JLabel pro_car_load_limite=new JLabel("负载上限");
	JTextField text_car_load_limite=new JTextField(20);	
	
	//bottom_left
	JLabel pro_car_oid_add=new JLabel("加油");
	JTextField text_car_oil_add=new JTextField(20);
	JButton submit_car_oil_add=new JButton("确定");
	
	JLabel pro_car_runmile=new JLabel("运行里数");
	JTextField text_car_runmile=new JTextField(20);
	JButton submit_car_runmile=new JButton("确定");
	
	JLabel pro_car_oil_currency=new JLabel("当前油量");
	JTextField text_car_oil_currency=new JTextField(20);
	JLabel pro_car_oil_limite=new JLabel("油箱总量");
	JTextField text_car_oil_limite=new JTextField(20);
	
	//bottom_right

	JLabel pro_car_oil_ave_use=new JLabel("每公里平均用油量");
	JTextField text_car_oil_ave_use=new JTextField(20);
	
	JLabel pro_car_vehicle_kilometer=new JLabel("总行程公里数");
	JTextField text_car_vehicle_kilometer=new JTextField(20);
	
	JLabel pro_car_runmile_guess=new JLabel("预测运行里数");
	JTextField text_car_runmile_guess=new JTextField(20);
	
	Car_Condition_Frame() {
	
		//top_left
		this.JButton_add(submit_car_speed_up,jp0,50,50,100,50);
		this.JTextField_add(text_car_speed_modify,jp0,160,50,100,50);
		this.JButton_add(submit_car_speed_down,jp0,270,50,100,50);

		this.JLabel_add(pro_car_speed_currency,jp0,95,110,100,50);
		this.JTextField_add(text_car_speed_currency,jp0,205,110,100,50);
		this.JLabel_add(pro_car_speed_limite,jp0,95,170,100,50);
		this.JTextField_add(text_car_speed_limite,jp0,205,170,100,50);

		//top_right 指的是在JPanel中的位置，若只jf.add(jp)，则jp放置在jf(0,0)处
		this.JButton_add(submit_car_load_up,jp1,50,50,100,50);
		this.JTextField_add(text_car_load_modify,jp1,160,50,100,50);
		this.JButton_add(submit_car_load_down,jp1,270,50,100,50);

		this.JLabel_add(pro_car_load_currency,jp1,95,110,100,50);
		this.JTextField_add(text_car_load_currency,jp1,205,110,100,50);
		this.JLabel_add(pro_car_load_limite,jp1,95,170,100,50);
		this.JTextField_add(text_car_load_limite,jp1,205,170,100,50);
		
		//bottom_left
		this.JLabel_add(pro_car_oid_add,jp2,50,50,100,50);
		this.JTextField_add(text_car_oil_add,jp2,160,50,100,50);
		this.JButton_add(submit_car_oil_add,jp2,270,50,100,50);
		
		this.JLabel_add(pro_car_runmile,jp2,50,110,100,50);
		this.JTextField_add(text_car_runmile,jp2,160,110,100,50);
		this.JButton_add(submit_car_runmile,jp2,270,110,100,50);

		this.JLabel_add(pro_car_oil_currency,jp2,95,170,100,50);
		this.JTextField_add(text_car_oil_currency,jp2,205,170,100,50);
		
		this.JLabel_add(pro_car_oil_limite,jp2,95,230,100,50);
		this.JTextField_add(text_car_oil_limite,jp2,205,230,100,50);

		//bottom_right
		this.JLabel_add(pro_car_oil_ave_use,jp3,20,60,200,50);
		this.JTextField_add(text_car_oil_ave_use,jp3,230,60,100,50);
		
		this.JLabel_add(pro_car_vehicle_kilometer,jp3,70,120,150,50);
		this.JTextField_add(text_car_vehicle_kilometer,jp3,230,120,100,50);
		
		this.JLabel_add(pro_car_runmile_guess,jp3,70,180,150,50);
		this.JTextField_add(text_car_runmile_guess,jp3,230,180,100,50);
		
		this.car_conditionIfEdit();	//只用设置一次
		this.create_jf_jp(jf_cc,jp0,800,800,"汽车状态");
		
		//jp0.setLayout(null);
		jp1.setLayout(null);
		jp2.setLayout(null);
		jp3.setLayout(null);
		//jf_cc.add(jp0);
		jf_cc.add(jp1);
		jf_cc.add(jp2);
		jf_cc.add(jp3);
		
		jf_cc.setLayout(new GridLayout(2,2));
		
		//把页面分成四部分，点到哪一部分，哪一块会发亮
		jf_cc.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				double x=e.getX();
				double y=e.getY();
				mouse_position_previous=mouse_position;
				mouse_position=(int) (Math.floor(x/400)+Math.floor(y/400)*2);
				if (mouse_position_previous!=mouse_position) {
					switch(mouse_position_previous) {
						case 0:
							jp0.setBackground(new Color(245,245,245));
							break;
						case 1:
							jp1.setBackground(new Color(245,245,245));
							break;
						case 2:
							jp2.setBackground(new Color(245,245,245));
							break;
						case 3:
							jp3.setBackground(new Color(245,245,245));
							break;
					}
					switch(mouse_position) {
						case 0:
							jp0.setBackground(new Color(248,248,255));
							break;
						case 1:
							jp1.setBackground(new Color(230,230,250));
							break;
						case 2:
							jp2.setBackground(new Color(0,250,154));
							break;
						case 3:
							jp3.setBackground(new Color(255,182,193));
							break;
					}
				}
			}
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});

		jf_cc.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				car.setSpeed_currency(speed_currency);
				car.setLoad_currency(load_currency);
				car.setOil_currency(oil_currency);
				car.setVehicle_kilometer(vehicle_kilometer);
				car.setOil_ave_use(oil_ave_use);
				Driving_System.car[car_index].setSpeed_currency(speed_currency);
				Driving_System.car[car_index].setLoad_currency(load_currency);
				Driving_System.car[car_index].setVehicle_kilometer(vehicle_kilometer);
				Driving_System.car[car_index].setOil_ave_use(oil_ave_use);
			}
		});
	}

	Car_Condition_Frame(int car_index) { //inquiry&modify
		this();
		this.car_index=car_index;
		car=Driving_System.car[car_index];
		speed_limite=car.getSpeed_limite();
		load_limite=car.getLoad_limite();
		oil_total=car.getOil_limite();
		oil_ave_use=car.getOil_ave_use();
		speed_currency=car.getSpeed_currency();
		load_currency=car.getLoad_currency();
		oil_currency=car.getOil_currency();
		oil_ave_use=car.getOil_ave_use();
		vehicle_kilometer=car.getVehicle_kilometer();
		
		this.car_conditionShow();
	}
	
	void car_conditionShow() {
		
		text_car_speed_currency.setText(String.format("%.2f",car.getSpeed_currency()));
		text_car_speed_limite.setText(String.format("%.2f",car.getSpeed_limite()));
		text_car_load_currency.setText(String.format("%.2f",car.getLoad_currency()));
		text_car_load_limite.setText(String.format("%.2f",car.getLoad_limite()));
		text_car_oil_currency.setText(String.format("%.2f",car.getOil_currency()));
		text_car_oil_limite.setText(String.format("%.2f",car.getOil_limite()));
		text_car_vehicle_kilometer.setText(String.format("%.2f",car.getVehicle_kilometer()));
		text_car_oil_ave_use.setText(String.format("%.4f",car.getOil_ave_use()));
		text_car_runmile_guess.setText(String.format("%.2f",oil_currency*oil_ave_use));
		
	}
		
	void car_conditionIfEdit() {
		
		text_car_speed_currency.setEditable(false);
		text_car_speed_limite.setEditable(false);
		text_car_load_currency.setEditable(false);
		text_car_load_limite.setEditable(false);
		text_car_oil_currency.setEditable(false);
		text_car_oil_limite.setEditable(false);
		text_car_vehicle_kilometer.setEditable(false);
		text_car_oil_ave_use.setEditable(false);
		text_car_runmile_guess.setEditable(false);

	}

	public void actionPerformed(ActionEvent e) {
		try {
			//oil_ave_use = car_coefficient+0.005*load_currency+(speed_currency-60)*0.0001;
			if (e.getSource()==submit_car_speed_up) {
				String str=text_car_speed_modify.getText();
				text_car_speed_modify.setText("");
				speed_modify=Double.parseDouble(str);
				if (speed_currency+speed_modify>speed_limite || speed_modify<0) {
					throw new Exception("速度不正确");
				}
				else {
					speed_currency=speed_currency+speed_modify;
					oil_ave_use+=speed_modify*0.0001;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_speed_currency.setText(String.format("%.2f",speed_currency));
					text_car_oil_ave_use.setText(String.format("%.4f",oil_ave_use));
					text_car_runmile_guess.setText(String.format("%.2f",runmile_guess));
				}
			}
			else if (e.getSource()==submit_car_speed_down) {
				String str=text_car_speed_modify.getText();
				text_car_speed_modify.setText("");
				speed_modify=Double.parseDouble(str);
				if (speed_currency-speed_modify<0 || speed_modify<0) {
					throw new Exception("速度不正确");
				}
				else {
					speed_currency=speed_currency-speed_modify;
					oil_ave_use-=speed_modify*0.001;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_speed_currency.setText(String.format("%.2f",speed_currency));
					text_car_oil_ave_use.setText(String.format("%.4f",oil_ave_use));
					text_car_runmile_guess.setText(String.format("%.2f",runmile_guess));
				}
			}
			else if (e.getSource()==submit_car_load_up) {
				String str=text_car_load_modify.getText();
				text_car_load_modify.setText("");
				load_modify=Double.parseDouble(str);
				if (load_currency+load_modify>load_limite || load_modify<0) {
					throw new Exception("负载不正确");
				}
				else {
					load_currency=load_currency+load_modify;
					oil_ave_use+=load_modify*0.005;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_load_currency.setText(String.format("%.2f",load_currency));
					text_car_oil_ave_use.setText(String.format("%.4f",oil_ave_use));
					text_car_runmile_guess.setText(String.format("%.2f",runmile_guess));
				}
			}
			else if (e.getSource()==submit_car_load_down) {
				String str=text_car_load_modify.getText();
				text_car_load_modify.setText("");
				load_modify=Double.parseDouble(str);
				if (load_currency-load_modify<0 || load_modify<0) {
					throw new Exception("负载不正确");
				}
				else {
					load_currency=load_currency-load_modify;
					oil_ave_use-=load_modify*0.005;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_load_currency.setText(String.format("%.2f",load_currency));
					text_car_oil_ave_use.setText(String.format("%.4f",oil_ave_use));
					text_car_runmile_guess.setText(String.format("%.2f",runmile_guess));					
				}
			}
			else if (e.getSource()==submit_car_oil_add) {
				String str=text_car_oil_add.getText();
				text_car_oil_add.setText("");
				oil_modify=Double.parseDouble(str);
				if (oil_currency+oil_modify>oil_total || oil_modify<0) {
					throw new Exception("油量不正确");
				}
				else {
					oil_currency=oil_currency+oil_modify;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_oil_currency.setText(String.format("%.2f",oil_currency));
					text_car_runmile_guess.setText(String.format("%.2f",runmile_guess));					
				}
			}
			else if (e.getSource()==submit_car_runmile) {
				String str=text_car_runmile.getText();
				text_car_runmile.setText("");
				runmile=Double.parseDouble(str);
				oil_modify=runmile*oil_ave_use;
				if (oil_currency-oil_modify<0 || oil_modify<0) {
					throw new Exception("运行里数不正确");
				}
				else {
					vehicle_kilometer=vehicle_kilometer+runmile;
					oil_currency=oil_currency-oil_modify;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_vehicle_kilometer.setText(String.format("%.2f",vehicle_kilometer));
					text_car_oil_currency.setText(String.format("%.2f",oil_currency));
					text_car_runmile_guess.setText(String.format("%.2f",runmile_guess));										
				}
			}
		} catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, " : 不是数字", "信息", JOptionPane.CLOSED_OPTION);
		} catch(FileNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "图片不存在", "信息", JOptionPane.CLOSED_OPTION);
		} catch(IOException e3) {
			JOptionPane.showMessageDialog(null, "文件操作错误", "信息", JOptionPane.CLOSED_OPTION);
		} catch(Exception e4) {
			 //JOptionPane.showMessageDialog(null, "未知错误", "信息", JOptionPane.CLOSED_OPTION);
		}
	}
}
