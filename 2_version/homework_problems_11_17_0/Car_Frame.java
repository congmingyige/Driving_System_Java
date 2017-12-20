
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	String car_image_path=new String("");
	
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
	JLabel pro_car_address=new JLabel("住址");
	JTextField text_car_address=new JTextField(50);	
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
	
	JLabel pro_car_image=new JLabel();	
	JButton submit_car_image=new JButton("选择照片");	
	JFileChooser chooser_car_image=new JFileChooser();
	
	JButton submit_c=new JButton("提交");

	JButton submit_car_print=new JButton("打印");
	
	Car_Frame() {
		
		//first
		this.JLabel_add(pro_number_plate,c,50,50,100,50);
		this.JTextField_add(text_number_plate,c,160,50,125,50);
		this.JLabel_add(pro_car_type,c,295,50,100,50);
		this.JTextField_add(text_car_type,c,405,50,125,50);
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
		this.JButton_add(submit_car_image,c,325,440,150,50);
		
		//seventh
		this.JButton_add(submit_c,c,350,650,100,50);
		
		this.JButton_add(submit_car_print,c,650,650,100,50);
		
		this.create_jf_jp(jf_c,c,800,800,"汽车");
	}
	
	Car_Frame(int mode) { //create
		this();
		this.mode=mode;
		car=new Car();
		jf_c.setVisible(true);
		carIfEdit(true,true);
		carIfPrint(false);
	}
	
	Car_Frame(int mode, int car_index) throws FileNotFoundException  { //inquiry modify
		this();
		this.mode=mode;
		this.car_index=car_index;
		car=Driving_System.car[car_index];
		car_image_path=car.getImage_path();
		if (mode==2) { //inquiry
			carIfEdit(false,false);
			carIfPrint(true);
		}
		else if (mode==3) { //modify
			carIfEdit(true,false);
			carIfPrint(false);
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
		text_oil_limite.setText(String.format("%.2f",car.getOil_limite()));
		text_weight.setText(String.format("%.2f",car.getWeight()));
		text_load_limite.setText(String.format("%.2f",car.getLoad_limite()));
		this.setImage(car.getImage_path(),pro_car_image,jf_c);

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
		car.setImage_path(car_image_path);
	}
	
	void carIfEdit(boolean v1, boolean v2) {
		
		text_number_plate.setEditable(v2);
		text_car_type.setEditable(v1);
		text_person.setEditable(v1);
		text_car_address.setEditable(v1);
		text_engine_number.setEditable(v1);
		text_car_iden_id.setEditable(v2);
		text_PD.setEditable(v1);
		text_oil_limite.setEditable(v1);
		text_weight.setEditable(v1);
		text_load_limite.setEditable(v1);
		
	}
	
	void carIfPrint(boolean v) {
		submit_c.setVisible(!v);
		submit_car_image.setVisible(!v);
		submit_car_print.setVisible(v);
		if (v)
			pro_car_image.setBounds(280,400,240,320);
		else
			pro_car_image.setBounds(50,400,240,320);		
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==submit_c) {
				
				if (car.ifcorrect(
						text_number_plate.getText(), text_car_type.getText(), text_person.getText(),
						text_car_address.getText(), text_engine_number.getText(), text_car_iden_id.getText(),
						text_PD.getText(), text_oil_limite.getText(), text_weight.getText(),
						text_load_limite.getText(),car_image_path)) {
					int choose;
					if (mode==1) { //create
						carSave();
						Driving_System.car_count++;
						Driving_System.car[Driving_System.car_count]=car;
						choose=JOptionPane.showConfirmDialog(null,"创建成功，是否保存成图片？","信息",JOptionPane.YES_NO_OPTION);
					} else {//modify
						carSave();
						Driving_System.car[car_index]=car;
						choose=JOptionPane.showConfirmDialog(null,"修改成功，是否保存成图片？","信息",JOptionPane.YES_NO_OPTION);
					}
					carIfEdit(false,false);
					if (choose==JOptionPane.YES_OPTION) {
						pro_car_image.setBounds(280,400,240,320);
						JFrameToImage(jf_c);
						jf_c.dispose();
					}
					else {
						pro_car_image.setBounds(280,400,240,320);
						jf_c.dispose();
					}
				}
			}
			else if (e.getSource()==submit_car_image) {
				car_image_path=getImage_path(chooser_car_image);
				setImage(car_image_path,pro_car_image,jf_c);
			}
			else if (e.getSource()==submit_car_print) {
				submit_car_print.setVisible(false);
				JFrameToImage(jf_c);
				submit_car_print.setVisible(true);	
			}
		} catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "不是数字", "信息", JOptionPane.CLOSED_OPTION);
		} catch(FileNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "图片不存在", "信息", JOptionPane.CLOSED_OPTION);
		} catch(IOException e3) {
			JOptionPane.showMessageDialog(null, "文件操作错误", "信息", JOptionPane.CLOSED_OPTION);
		} catch(Exception e4) {
			 JOptionPane.showMessageDialog(null, "未知错误", "信息", JOptionPane.CLOSED_OPTION);
		}
	}
}
