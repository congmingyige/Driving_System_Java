import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Driver_Frame extends Basic_Frame {
	int mode; //1:create 2:inquiry 3:modify
	
	JFrame jf_d=new JFrame();
	JPanel d=new JPanel();
	//first
	JLabel pro_name=new JLabel("姓名");
	JTextField text_name=new JTextField(20);
	
	JLabel pro_nationality=new JLabel("国籍");
	JTextField text_nationality=new JTextField(20);
	
	JLabel pro_birth=new JLabel("出生日期");
	JTextField text_birth=new JTextField(20);
	//second
	JLabel pro_driver_address=new JLabel("居住地址");
	JTextField text_driver_address=new JTextField(20);	
	//third
	JLabel pro_driving_type=new JLabel("准驾车型");
	JTextField text_driving_type=new JTextField(20);
	
	JLabel pro_first_rece=new JLabel("初次领证日期");
	JTextField text_first_rece=new JTextField(20);
	
	JLabel pro_valid=new JLabel("有效日期");
	JTextField text_valid=new JTextField(20);
	
	JLabel pro_valid_time=new JLabel("有效期限");
	JTextField text_valid_time=new JTextField(20);
	
	JLabel pro_file_number=new JLabel("档案编号");
	JTextField text_file_number=new JTextField(20);
	
	JButton submit_driver_photo=new JButton("选择照片");	
	JFileChooser chooser_driver_photo=new JFileChooser();
	JLabel pro_driver_photo=new JLabel();
	
	JButton submit_d=new JButton("提交");
	
	Driver_Frame() {
		this.create_jf_jp(jf_d,d,800,800,"驾驶员");
		
		//first
		this.JLabel_add(pro_name,d,50,50,50,50);
		this.JTextField_add(text_name,d,110,50,200,50);
		this.JLabel_add(pro_nationality,d,320,50,50,50);
		this.JTextField_add(text_nationality,d,380,50,100,50);
		this.JLabel_add(pro_birth,d,490,50,100,50);
		this.JTextField_add(text_birth,d,600,50,150,50);
		
		//second
		this.JLabel_add(pro_driver_address,d,50,120,100,50);
		this.JTextField_add(text_driver_address,d,160,120,590,50);
		
		//third
		this.JLabel_add(pro_driving_type,d,50,190,100,50);
		this.JTextField_add(text_driving_type,d,160,190,200,50);
		this.JLabel_add(pro_first_rece,d,390,190,150,50);	
		this.JTextField_add(text_first_rece,d,550,190,200,50);
		
		//fourth
		this.JLabel_add(pro_valid,d,50,260,100,50);
		this.JTextField_add(text_valid,d,160,260,200,50);
		this.JLabel_add(pro_valid_time,d,440,260,100,50);
		this.JTextField_add(text_valid_time,d,550,260,200,50);
	
		//fifth
		this.JLabel_add(pro_file_number,d,50,330,100,50);
		this.JTextField_add(text_file_number,d,160,330,590,50);

		//sixth
		this.JButton_add(submit_driver_photo,d,325,400,150,50);
		
		//seventh
		this.JButton_add(submit_d,d,350,650,100,50);
	}
	
	Driver_Frame(int mode) { //create
		this();
		this.mode=mode;
		jf_d.setVisible(true);
		driverIfEdit(true);
		submit_d.setVisible(true);
	}

	Driver_Frame(CarDriver driver,int mode) throws FileNotFoundException  {
		this();
		this.mode=mode;
		if (mode==2) { //inquiry
			driverIfEdit(false);
			submit_d.setVisible(false);
		}
		else if (mode==3) { //modify
			driverIfEdit(true);
			submit_d.setVisible(true);			
		}
		this.driverShow(driver);
	}
	
	void driverShow(CarDriver driver) throws FileNotFoundException {
		
		text_name.setText(driver.getName());
		text_nationality.setText(driver.getNationality());
		text_birth.setText(driver.getBirth());
		text_driver_address.setText(driver.getAddr());
		text_driving_type.setText(driver.getDriving_type());
		text_first_rece.setText(driver.getFirst_rece());
		text_valid.setText(driver.getValid());
		text_valid_time.setText(String.valueOf(driver.getValid_time()));
		text_file_number.setText(String.valueOf(driver.getFile_number()));
		this.imageSet(driver.getImage_path(),pro_driver_photo,jf_d);
		
	}
	
	void driverSave(CarDriver driver) throws FileNotFoundException {
		
		driver.setName(text_name.getText());
		driver.setNationality(text_nationality.getText());
		driver.setBirth(text_birth.getText());
		driver.setAddr(text_driver_address.getText());
		driver.setDriving_type(text_driving_type.getText());
		driver.setFirst_rece(text_first_rece.getText());
		driver.setValid(text_valid.getText());
		driver.setValid_time(Integer.parseInt(text_valid_time.getText()));
		driver.setFile_number(text_file_number.getText());
		driver.setImage_path(image_pathGet(chooser_driver_photo));

	}
	
	void driverIfEdit(boolean v) {
		
		text_name.setEditable(v);
		text_nationality.setEditable(v);
		text_birth.setEditable(v);
		text_driver_address.setEditable(v);
		text_driving_type.setEditable(v);
		text_first_rece.setEditable(v);
		text_valid.setEditable(v);
		text_valid_time.setEditable(v);
		text_file_number.setEditable(v);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==submit_d) {
				if (true) {
					JOptionPane.showMessageDialog(null, "提交成功", "信息", JOptionPane.CLOSED_OPTION);
					//check if ok
					CarDriver
					if (mode==1) { //create
						//
					} else {//modify
						//
					}
				}
				//else
					//JOptionPane.showMessageDialog(null, "提交成功", "信息", JOptionPane.CLOSED_OPTION);
			}
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
