
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

class Driver_Frame extends Basic_Frame {
	int mode; //1:create 2:inquiry 3:modify
	int driver_index;
	Driver driver;
	String driver_image_path=new String("");
	
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
	JTextField text_driver_address=new JTextField(50);	
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
	
	JLabel pro_driver_image=new JLabel();
	JButton submit_driver_image=new JButton("选择照片");	
	JFileChooser chooser_driver_image=new JFileChooser();

	JButton submit_d=new JButton("提交");
	
	JButton submit_driver_print=new JButton("打印");
	
	Driver_Frame() {
		
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
		this.JButton_add(submit_driver_image,d,325,400,150,50);
		
		//seventh
		this.JButton_add(submit_d,d,350,650,100,50);
		
		this.JButton_add(submit_driver_print,d,650,650,100,50);
		
		this.create_jf_jp(jf_d,d,800,800,"驾驶员");
	}
	
	Driver_Frame(int mode) { //create
		this();
		this.mode=mode;
		driver=new Driver();
		driverIfEdit(true,true);
		driverIfPrint(false);
	}

	Driver_Frame(int mode ,int driver_index) throws FileNotFoundException  { //inquiry modify
		this();
		this.mode=mode;
		this.driver_index=driver_index;
		driver=Driving_System.driver[driver_index];
		driver_image_path=driver.getImage_path();
		if (mode==2) { //inquiry
			driverIfEdit(false,false);
			driverIfPrint(true);
		}
		else if (mode==3) { //modify
			driverIfEdit(true,false);
			driverIfPrint(false);
		}
		this.driverShow();
	}
	
	void driverShow() throws FileNotFoundException {
		
		text_name.setText(driver.getName());
		text_nationality.setText(driver.getNationality());
		text_birth.setText(driver.getBirth());
		text_driver_address.setText(driver.getAddr());
		text_driving_type.setText(driver.getDriving_type());
		text_first_rece.setText(driver.getFirst_rece());
		text_valid.setText(driver.getValid());
		text_valid_time.setText(String.valueOf(driver.getValid_time()));
		text_file_number.setText(String.valueOf(driver.getFile_number()));
		this.setImage(driver.getImage_path(),pro_driver_image,jf_d);
		
	}
	
	void driverSave() throws FileNotFoundException {
		
		driver.setName(text_name.getText());
		driver.setNationality(text_nationality.getText());
		driver.setBirth(text_birth.getText());
		driver.setAddr(text_driver_address.getText());
		driver.setDriving_type(text_driving_type.getText());
		driver.setFirst_rece(text_first_rece.getText());
		driver.setValid(text_valid.getText());
		driver.setValid_time(Integer.parseInt(text_valid_time.getText()));
		driver.setFile_number(text_file_number.getText());
		driver.setImage_path(driver_image_path);

	}
	
	void driverIfEdit(boolean v1, boolean v2) {
		
		text_name.setEditable(v2);
		text_nationality.setEditable(v1);
		text_birth.setEditable(v1);
		text_driver_address.setEditable(v1);
		text_driving_type.setEditable(v1);
		text_first_rece.setEditable(v1);
		text_valid.setEditable(v1);
		text_valid_time.setEditable(v1);
		text_file_number.setEditable(v2);
		
	}
	
	void driverIfPrint(boolean v) {
		submit_d.setVisible(!v);
		submit_driver_print.setVisible(!v);
		submit_driver_image.setVisible(!v);
		submit_driver_print.setVisible(v);
		if (v)
			pro_driver_image.setBounds(280,400,240,320);
		else
			pro_driver_image.setBounds(50,400,240,320);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==submit_d) {

				if (driver.ifcorrect(
						text_name.getText(), text_nationality.getText(), text_birth.getText(),
						text_driver_address.getText(), text_driving_type.getText(), text_first_rece.getText(),
						text_valid.getText(), text_valid_time.getText(), text_file_number.getText(), 
						driver_image_path)) {
					int choose;
					if (mode==1) { //create
						driverSave();
						Driving_System.driver_count++;
						Driving_System.driver[Driving_System.driver_count]=driver;
						choose=JOptionPane.showConfirmDialog(null,"创建成功，是否保存成图片？","信息",JOptionPane.YES_NO_OPTION);
					} else {//modify
						driverSave();
						Driving_System.driver[driver_index]=driver;
						choose=JOptionPane.showConfirmDialog(null,"修改成功，是否保存成图片？","信息",JOptionPane.YES_NO_OPTION);
					}
					driverIfEdit(false,false);
					if (choose==JOptionPane.YES_OPTION) {
						pro_driver_image.setBounds(280,400,240,320);
						JFrameToImage(jf_d);
						jf_d.dispose();
					}
					else {
						pro_driver_image.setBounds(280,400,240,320);
						jf_d.dispose();
					}
				}
			}
			else if (e.getSource()==submit_driver_image) {
				driver_image_path=getImage_path(chooser_driver_image);
				setImage(driver_image_path,pro_driver_image,jf_d);
			}
			else if (e.getSource()==submit_driver_print) {
				submit_driver_print.setVisible(false);
				JFrameToImage(jf_d);
				submit_driver_print.setVisible(true);
			}
		} catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage()+" : 不是数字", "信息", JOptionPane.CLOSED_OPTION);
		} catch(FileNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "图片不存在", "信息", JOptionPane.CLOSED_OPTION);
		} catch(IOException e3) {
			JOptionPane.showMessageDialog(null, "文件操作错误", "信息", JOptionPane.CLOSED_OPTION);
		} catch(Exception e4) {
			 //JOptionPane.showMessageDialog(null, "未知错误", "信息", JOptionPane.CLOSED_OPTION);
			//e4.printStackTrace();
		}
	}
}
