import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Car_Condition_Frame extends Basic_Frame{
	//这个界面长期存在，所以创建变量合算
	int car_index;
	Car car;
	
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
	JPanel cc=new JPanel();
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
		
		this.create_jf_jp(jf_cc,cc,800,800,"汽车状态");
		this.car_conditionIfEdit();	//只用设置一次
		jf_cc.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				car.setSpeed_currency(speed_currency);
				car.setLoad_currency(load_currency);
				car.setOil_currency(oil_currency);
				car.setVehicle_kilometer(vehicle_kilometer);
				car.setOil_ave_use(oil_ave_use);
				//to database
			}
		});
		
		//top_left
		this.JButton_add(submit_car_speed_up,cc,50,50,100,50);
		this.JTextField_add(text_car_speed_modify,cc,160,50,100,50);
		this.JButton_add(submit_car_speed_down,cc,270,50,100,50);

		this.JLabel_add(pro_car_speed_currency,cc,95,110,100,50);
		this.JTextField_add(text_car_speed_currency,cc,205,110,100,50);
		this.JLabel_add(pro_car_speed_limite,cc,95,170,100,50);
		this.JTextField_add(text_car_speed_limite,cc,205,170,100,50);

		//top_right
		this.JButton_add(submit_car_load_up,cc,450,50,100,50);
		this.JTextField_add(text_car_load_modify,cc,560,50,100,50);
		this.JButton_add(submit_car_load_down,cc,670,50,100,50);

		this.JLabel_add(pro_car_load_currency,cc,495,110,100,50);
		this.JTextField_add(text_car_load_currency,cc,605,110,100,50);
		this.JLabel_add(pro_car_load_limite,cc,495,170,100,50);
		this.JTextField_add(text_car_load_limite,cc,605,170,100,50);
		
		//bottom_left
		this.JLabel_add(pro_car_oid_add,cc,50,450,100,50);
		this.JTextField_add(text_car_oil_add,cc,160,450,100,50);
		this.JButton_add(submit_car_oil_add,cc,270,450,100,50);
		
		this.JLabel_add(pro_car_runmile,cc,50,510,100,50);
		this.JTextField_add(text_car_runmile,cc,160,510,100,50);
		this.JButton_add(submit_car_runmile,cc,270,510,100,50);

		this.JLabel_add(pro_car_oil_currency,cc,95,570,100,50);
		this.JTextField_add(text_car_oil_currency,cc,205,570,100,50);
		
		this.JLabel_add(pro_car_oil_limite,cc,95,630,100,50);
		this.JTextField_add(text_car_oil_limite,cc,205,630,100,50);

		//bottom_right

		this.JLabel_add(pro_car_oil_ave_use,cc,420,460,200,50);
		this.JTextField_add(text_car_oil_ave_use,cc,630,460,100,50);
		
		this.JLabel_add(pro_car_vehicle_kilometer,cc,470,520,150,50);
		this.JTextField_add(text_car_vehicle_kilometer,cc,630,520,100,50);
		
		this.JLabel_add(pro_car_runmile_guess,cc,470,580,150,50);
		this.JTextField_add(text_car_runmile_guess,cc,630,580,100,50);

		//可以在中间设置一个动画
		//点到哪一块，哪一块会略微发亮

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
		
		text_car_speed_currency.setText(String.valueOf(car.getSpeed_currency()));
		text_car_speed_limite.setText(String.valueOf(car.getSpeed_limite()));
		text_car_load_currency.setText(String.valueOf(car.getLoad_currency()));
		text_car_load_limite.setText(String.valueOf(car.getLoad_limite()));
		text_car_oil_currency.setText(String.valueOf(car.getOil_currency()));
		text_car_oil_limite.setText(String.valueOf(car.getOil_limite()));
		text_car_vehicle_kilometer.setText(String.valueOf(car.getVehicle_kilometer()));
		text_car_oil_ave_use.setText(String.valueOf(car.getOil_ave_use()));
		text_car_runmile_guess.setText(String.valueOf(oil_currency*oil_ave_use));
		
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
				speed_modify=Double.parseDouble(text_car_speed_modify.getText());
				if (speed_currency+speed_modify>speed_limite || speed_modify<0) {
					throw new Exception("速度不正确");
				}
				else {
					speed_currency=speed_currency+speed_modify;
					oil_ave_use+=speed_modify*0.0001;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_speed_modify.setText("");
					text_car_speed_currency.setText(String.valueOf(speed_currency));
					text_car_oil_ave_use.setText(String.valueOf(oil_ave_use));
					text_car_runmile_guess.setText(String.valueOf(runmile_guess));
				}
			}
			else if (e.getSource()==submit_car_speed_down) {
				speed_modify=Double.parseDouble(text_car_speed_modify.getText());
				if (speed_currency-speed_modify<0 || speed_modify<0) {
					throw new Exception("速度不正确");
				}
				else {
					speed_currency=speed_currency-speed_modify;
					oil_ave_use-=speed_modify*0.001;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_speed_modify.setText("");
					text_car_speed_currency.setText(String.valueOf(speed_currency));
					text_car_oil_ave_use.setText(String.valueOf(oil_ave_use));
					text_car_runmile_guess.setText(String.valueOf(runmile_guess));
				}
			}
			else if (e.getSource()==submit_car_load_up) {
				load_modify=Double.parseDouble(text_car_load_modify.getText());
				if (load_currency+load_modify>load_limite || load_modify<0) {
					throw new Exception("负载不正确");
				}
				else {
					load_currency=load_currency+load_modify;
					oil_ave_use+=load_modify*0.005;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_load_modify.setText("");
					text_car_load_currency.setText(String.valueOf(load_currency));
					text_car_oil_ave_use.setText(String.valueOf(oil_ave_use));
					text_car_runmile_guess.setText(String.valueOf(runmile_guess));
				}
			}
			else if (e.getSource()==submit_car_load_down) {
				load_modify=Double.parseDouble(text_car_load_modify.getText());
				if (load_currency-load_modify<0 || load_modify<0) {
					throw new Exception("负载不正确");
				}
				else {
					load_currency=load_currency-load_modify;
					oil_ave_use-=load_modify*0.005;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_load_modify.setText("");
					text_car_load_currency.setText(String.valueOf(load_currency));
					text_car_oil_ave_use.setText(String.valueOf(oil_ave_use));
					text_car_runmile_guess.setText(String.valueOf(runmile_guess));					
				}
			}
			else if (e.getSource()==submit_car_oil_add) {
				oil_modify=Double.parseDouble(text_car_oil_add.getText());
				if (oil_currency+oil_modify>oil_total || oil_modify<0) {
					throw new Exception("油量不正确");
				}
				else {
					oil_currency=oil_currency+oil_modify;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_oil_currency.setText(String.valueOf(oil_currency));
					text_car_runmile_guess.setText(String.valueOf(runmile_guess));					
				}
			}
			else if (e.getSource()==submit_car_runmile) {
				runmile=Double.parseDouble(text_car_runmile.getText());
				oil_modify=runmile*oil_ave_use;
				if (oil_currency-oil_modify<0 || oil_modify<0) {
					throw new Exception("油量不正确");
				}
				else {
					vehicle_kilometer=vehicle_kilometer+runmile;
					oil_currency=oil_currency-oil_modify;
					runmile_guess=oil_currency*oil_ave_use;
					
					text_car_vehicle_kilometer.setText(String.valueOf(vehicle_kilometer));
					text_car_oil_currency.setText(String.valueOf(oil_currency));
					text_car_runmile_guess.setText(String.valueOf(runmile_guess));										
				}				
			}
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "信息", JOptionPane.CLOSED_OPTION);
		}
	}
	
}
