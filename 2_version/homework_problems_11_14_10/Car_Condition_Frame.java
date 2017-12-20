import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Car_Condition_Frame extends Basic_Frame{
	//������泤�ڴ��ڣ����Դ�����������
	int car_index;
	
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
	
	JFrame jf_cc=new JFrame();
	JPanel cc=new JPanel();
	//top_left
	JButton submit_speed_up=new JButton("����");
	JTextField text_speed_modify =new JTextField(20);
	JButton submit_speed_down=new JButton("����");

	JLabel pro_car_speed_currency=new JLabel("��ǰ�ٶ�");
	JTextField text_car_speed_currency=new JTextField(20);
	JLabel pro_speed_limite=new JLabel("�ٶ�����");
	JTextField text_speed_limite=new JTextField(20);

	//top_right
	JButton submit_load_up=new JButton("����");
	JTextField text_load_modify =new JTextField(20);
	JButton submit_load_down=new JButton("����");
	
	JLabel pro_car_load_currency=new JLabel("��ǰ����");
	JTextField text_car_load_currency=new JTextField(20);
	JLabel pro_car_load_limite=new JLabel("��������");
	JTextField text_car_load_limite=new JTextField(20);	
	
	//bottom_left
	JLabel pro_oid_add=new JLabel("����");
	JTextField text_oil_add=new JTextField(20);
	JButton submit_oil_add=new JButton("ȷ��");
	
	JLabel pro_runmile=new JLabel("��������");
	JTextField text_runmile=new JTextField(20);
	JButton submit_runmile=new JButton("ȷ��");
	
	JLabel pro_car_oil_currency=new JLabel("��ǰ����");
	JTextField text_car_oil_currency=new JTextField(20);
	JLabel pro_car_oil_limite=new JLabel("��������");
	JTextField text_car_oil_limite=new JTextField(20);
	
	//bottom_right

	JLabel pro_car_vehicle_kilometer=new JLabel("���г̹�����");
	JTextField text_car_vehicle_kilometer=new JTextField(20);
	
	JLabel pro_runmile_guess=new JLabel("Ԥ����������");
	JTextField text_runmile_guess=new JTextField(20);
	
	Car_Condition_Frame() {
		
		this.create_jf_jp(jf_cc,cc,800,800,"����״̬");
		this.car_conditionIfEdit();	//ֻ������һ��

		//top_left
		this.JButton_add(submit_speed_up,cc,50,50,100,50);
		this.JTextField_add(text_speed_modify,cc,160,50,100,50);
		this.JButton_add(submit_speed_down,cc,270,50,100,50);

		this.JLabel_add(pro_car_speed_currency,cc,95,110,100,50);
		this.JTextField_add(text_car_speed_currency,cc,205,110,100,50);
		this.JLabel_add(pro_speed_limite,cc,95,170,100,50);
		this.JTextField_add(text_speed_limite,cc,205,170,100,50);

		//top_right
		this.JButton_add(submit_load_up,cc,450,50,100,50);
		this.JTextField_add(text_load_modify,cc,560,50,100,50);
		this.JButton_add(submit_load_down,cc,670,50,100,50);

		this.JLabel_add(pro_car_load_currency,cc,495,110,100,50);
		this.JTextField_add(text_car_load_currency,cc,605,110,100,50);
		this.JLabel_add(pro_car_load_limite,cc,495,170,100,50);
		this.JTextField_add(text_car_load_limite,cc,605,170,100,50);
		
		//bottom_left
		this.JLabel_add(pro_oid_add,cc,50,450,100,50);
		this.JTextField_add(text_oil_add,cc,160,450,100,50);
		this.JButton_add(submit_oil_add,cc,270,450,100,50);
		
		this.JLabel_add(pro_runmile,cc,50,510,100,50);
		this.JTextField_add(text_runmile,cc,160,510,100,50);
		this.JButton_add(submit_runmile,cc,270,510,100,50);

		this.JLabel_add(pro_car_oil_currency,cc,95,570,100,50);
		this.JTextField_add(text_car_oil_currency,cc,205,570,100,50);
		
		this.JLabel_add(pro_car_oil_limite,cc,95,630,100,50);
		this.JTextField_add(text_car_oil_limite,cc,205,630,100,50);

		//bottom_right

		this.JLabel_add(pro_car_vehicle_kilometer,cc,470,520,150,50);
		this.JTextField_add(text_car_vehicle_kilometer,cc,630,520,100,50);
		
		this.JLabel_add(pro_runmile_guess,cc,470,580,150,50);
		this.JTextField_add(text_runmile_guess,cc,630,580,100,50);
		
		speed_limite=Driving_System.car[car_index].getSpeed_limite();
		load_limite=Driving_System.car[car_index].getLoad_limite();
		oil_total=Driving_System.car[car_index].getOil_total();
		oil_ave_use=Driving_System.car[car_index].getOil_ave_use();
		speed_currency=Driving_System.car[car_index].getSpeed_currency();
		load_currency=Driving_System.car[car_index].getLoad_currency();
		oil_currency=Driving_System.car[car_index].getOil_currency();
		vehicle_kilometer=Driving_System.car[car_index].getVehicle_kilometer();
		
		//�������м�����һ������
		//�㵽��һ�飬��һ�����΢����
		
		// polynomial(3x*4+e^2+c): to calculate (mile,oil,current_oil,car_type)

	}
	
	Car_Condition_Frame(Car car, int car_index) { //inquiry&modify
		this();
		this.car_index=car_index;
		this.car_conditionShow(car);
	}
	
	void car_conditionShow(Car car) {
		
		text_car_speed_currency.setText(String.valueOf(car.getSpeed_currency()));
		text_car_load_currency.setText(String.valueOf(car.getLoad_currency()));
		text_car_oil_currency.setText(String.valueOf(car.getOil_currency()));
		text_car_vehicle_kilometer.setText(String.valueOf(car.getVehicle_kilometer()));

	}
	
	void car_conditionIfEdit() {
		
		text_car_speed_currency.setEditable(false);
		text_speed_limite.setEditable(false);
		text_car_load_currency.setEditable(false);
		text_car_load_limite.setEditable(false);
		text_car_oil_currency.setEditable(false);
		text_car_oil_limite.setEditable(false);
		text_car_vehicle_kilometer.setEditable(false);
		text_runmile_guess.setEditable(false);

	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==submit_speed_up) {
				speed_modify=Double.parseDouble(text_speed_modify.getText());
				if (speed_currency+speed_modify>speed_limite || speed_modify<0) {
					throw new Exception("�ٶȲ���ȷ");
				}
				else {
					speed_currency=speed_currency+speed_modify;
				}
			}
			else if (e.getSource()==submit_speed_down) {
				speed_modify=Double.parseDouble(text_speed_modify.getText());
				if (speed_currency-speed_modify<0 || speed_modify<0) {
					throw new Exception("�ٶȲ���ȷ");
				}
				else {
					speed_currency=speed_currency-speed_modify;
				}
			}
			else if (e.getSource()==submit_load_up) {
				load_modify=Double.parseDouble(text_load_modify.getText());
				if (load_currency+load_modify>load_limite || load_modify<0) {
					throw new Exception("���ز���ȷ");
				}
				else {
					load_currency=load_currency+load_modify;
				}
			}
			else if (e.getSource()==submit_load_down) {
				load_modify=Double.parseDouble(text_load_modify.getText());
				if (load_currency-load_modify<0 || load_modify<0) {
					throw new Exception("���ز���ȷ");
				}
				else {
					load_currency=load_currency-load_modify;
				}
			}
			else if (e.getSource()==submit_oil_add) {
				oil_modify=Double.parseDouble(text_oil_add.getText());
				if (oil_currency+oil_modify>oil_total || oil_modify<0) {
					throw new Exception("��������ȷ");
				}
				else {
					oil_currency=oil_currency+oil_modify;
				}
			}
			else if (e.getSource()==submit_runmile) {
				runmile=Double.parseDouble(text_runmile.getText());
				oil_modify=runmile*oil_ave_use;
				if (oil_currency-oil_modify<0 || oil_modify<0) {
					throw new Exception("��������ȷ");
				}
				else {
					vehicle_kilometer=vehicle_kilometer+runmile;
					oil_currency=oil_currency-oil_modify;
				}				
			}
		} catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "��Ϣ", JOptionPane.CLOSED_OPTION);
		}
	}
}
