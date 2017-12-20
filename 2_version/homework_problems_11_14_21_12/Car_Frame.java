import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Car_Frame extends Basic_Frame {
	int mode; //1:create 2:inquiry 3:modify
	int car_index;
	Car car;
	
	JFrame jf_c=new JFrame();
	JPanel c=new JPanel();
	//first
	JLabel pro_number_plate=new JLabel("汽车号牌");
	JTextField text_number_plate=new JTextField(20);
	
	JLabel pro_car_type=new JLabel("车辆类型");
	JTextField text_car_type=new JTextField(20);
	
	JLabel pro_person=new JLabel("拥有者");
	JTextField text_person=new JTextField(20);
	//second
	JLabel pro_car_address=new JLabel("地址");
	JTextField text_car_address=new JTextField(20);	
	//third
	JLabel pro_engine_number=new JLabel("发动机号码");
	JTextField text_engine_number=new JTextField(20);
	
	JLabel pro_car_iden_id=new JLabel("车辆识别号");
	JTextField text_car_iden_id=new JTextField(20);
	//fourth
	JLabel pro_PD=new JLabel("生产日期");
	JTextField text_PD=new JTextField(20);
	
	JLabel pro_oil_limite=new JLabel("油箱容量");
	JTextField text_oil_limite=new JTextField(20);
	
	//fifth
	JLabel pro_weight=new JLabel("重量");
	JTextField text_weight=new JTextField(20);
	
	JLabel pro_load_limite=new JLabel("载重量");
	JTextField text_load_limite=new JTextField(20);	
	
	JButton submit_car_photo=new JButton("选择照片");	
	JFileChooser chooser_car_photo=new JFileChooser();
	JLabel pro_car_photo=new JLabel();
	
	JButton submit_c=new JButton("提交");

	
	Car_Frame() {
		this.create_jf_jp(jf_c,c,800,800,"汽车");
		
		//first
		this.JLabel_add(pro_number_plate,c,50,50,100,50);
		this.JTextField_add(text_number_plate,c,160,50,150,50);
		this.JLabel_add(pro_car_type,c,320,50,100,50);
		this.JTextField_add(text_car_type,c,430,50,100,50);
		this.JLabel_add(pro_person,c,540,50,75,50);
		this.JTextField_add(text_person,c,625,50,105,50);
		
		//second
		this.JLabel_add(pro_car_address,c,50,120,50,50);
		this.JTextField_add(text_car_address,c,110,120,620,50);
		
		//third
		this.JLabel_add(pro_engine_number,c,50,190,125,50);
		this.JTextField_add(text_engine_number,c,185,190,150,50);
		this.JLabel_add(pro_car_iden_id,c,345,190,125,50);
		this.JTextField_add(text_car_iden_id,c,480,190,250,50);
		
		//fourth
		this.JLabel_add(pro_PD,c,50,260,125,50);
		this.JTextField_add(text_PD,c,185,260,200,50);
		this.JLabel_add(pro_oil_limite,c,395,260,125,50);
		this.JTextField_add(text_oil_limite,c,530,260,200,50);
		
		//fifth
		this.JLabel_add(pro_weight,c,50,330,125,50);
		this.JTextField_add(text_weight,c,185,330,200,50);
		this.JLabel_add(pro_load_limite,c,395,330,125,50);
		this.JTextField_add(text_load_limite,c,530,330,200,50);
		
		//sixth
		this.JButton_add(submit_car_photo,c,325,440,150,50);
		
		//seventh
		this.JButton_add(submit_c,c,350,650,100,50);
	}
	
	Car_Frame(int mode) { //create
		this();
		this.mode=mode;
		car=new Car();
		jf_c.setVisible(true);
		carIfEdit(true);
		submit_c.setVisible(true);
	}
	
	Car_Frame(int mode, int car_index) throws FileNotFoundException  {
		this();
		this.mode=mode;
		this.car_index=car_index;
		car=Driving_System.car[car_index];
		if (mode==2) { //inquiry
			carIfEdit(false);
			submit_c.setVisible(false);
		}
		else if (mode==3) { //modify
			carIfEdit(true);
			submit_c.setVisible(true);			
		}
		this.carShow();
	}
	
	void carShow() throws FileNotFoundException {
		
		text_number_plate.setText(car.getNumber_plate());
		text_car_type.setText(car.getCar_type());
		text_person.setText(car.getPerson());
		text_car_address.setText(car.getAddress());
		text_engine_number.setText(car.getEngine_number());
		text_car_iden_id.setText(car.getCar_iden_id());
		text_PD.setText(car.getPD());
		text_oil_limite.setText(String.valueOf(car.getOil_limite()));
		text_weight.setText(String.valueOf(car.getWeight()));
		text_load_limite.setText(String.valueOf(car.getLoad_limite()));
		this.imageSet(car.getImage_path(),pro_car_photo,jf_c);

	}
	
	void carSave() throws FileNotFoundException {
		
		car.setNumber_plate(text_number_plate.getText());
		car.setCar_type(text_car_type.getText());
		car.setPerson(text_person.getText());
		car.setAddress(text_car_address.getText());
		car.setEngine_number(text_engine_number.getText());
		car.setCar_iden_id(text_car_iden_id.getText());
		car.setPD(text_PD.getText());
		car.setOil_limite(Double.parseDouble(text_oil_limite.getText()));
		car.setWeight(Double.parseDouble(text_weight.getText()));
		car.setLoad_limite(Double.parseDouble(text_load_limite.getText()));
		car.setImage_path(image_pathGet(chooser_car_photo));
	}
	
	void carIfEdit(boolean v) {
		
		text_number_plate.setEditable(v);
		text_car_type.setEditable(v);
		text_person.setEditable(v);
		text_car_address.setEditable(v);
		text_engine_number.setEditable(v);
		text_car_iden_id.setEditable(v);
		text_PD.setEditable(v);
		text_oil_limite.setVisible(v);
		text_weight.setEditable(v);
		text_load_limite.setEditable(v);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==submit_c) {
				
				if (car.ifcorrect(
						text_number_plate.getText(), text_car_type.getText(), text_person.getText(),
						text_car_address.getText(), text_engine_number.getText(), text_car_iden_id.getText(),
						text_PD.getText(), text_oil_limite.getText(), text_weight.getText(),
						text_load_limite.getText(),"")) {
					if (mode==1) { //create
						Driving_System.car_count++;
						Driving_System.car[Driving_System.car_count]=car;
					} else {//modify
						carSave();
						Driving_System.car[car_index]=car;
					}
					JOptionPane.showMessageDialog(null, "提交成功", "信息", JOptionPane.CLOSED_OPTION);
				}
			}
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
