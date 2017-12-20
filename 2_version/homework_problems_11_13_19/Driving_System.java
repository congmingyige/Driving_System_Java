
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

//write as much function as possible for the use of class

//异常处理：作类型转换的时候,如果不是对应类型则进行相应处理

//car 和 driver 类的联系:指针？

//一些TextField可修改/不可修改

public class Driving_System extends JFrame implements ActionListener {
	
	//Ctrl+F : Driver_build ...
	
	//Driver_build
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
	
	//////////////////////////////////////////////////
	
	//Car_build
	JFrame jf_c=new JFrame();
	JPanel c=new JPanel();
	//first
	JLabel pro_number_plate=new JLabel("汽车号牌");
	JTextField text_number_plate=new JTextField(20);
	
	JLabel pro_car_type=new JLabel("车辆类型");
	JTextField text_car_type=new JTextField(20);
	
	JLabel pro_person=new JLabel("所有人");
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
	
	JLabel pro_oil_total=new JLabel("油箱容量");
	JTextField text_oil_total=new JTextField(20);
	
	//fifth
	JLabel pro_weight=new JLabel("重量");
	JTextField text_weight=new JTextField(20);
	
	JLabel pro_load_limite=new JLabel("载重量");
	JTextField text_load_limite=new JTextField(20);	
	
	JLabel pro_vehicle_kilometer=new JLabel("总行程公里数");
	JTextField text_vehicle_kilometer=new JTextField(20);	
	
	JButton submit_car_photo=new JButton("选择照片");	
	JFileChooser chooser_car_photo=new JFileChooser();
	JLabel pro_car_photo=new JLabel();
	
	JButton submit_c=new JButton("提交");
	
	//////////////////////////////////////////////////
	
	//car_condition_build
	JFrame jf_cc=new JFrame();
	JPanel cc=new JPanel();
	//top_left
	JButton submit_speed_up=new JButton("加速");
	JTextField text_speed_modify =new JTextField(20);
	JButton submit_speed_down=new JButton("减速");

	JLabel pro_car_speed_currency=new JLabel("当前速度");
	JTextField text_car_speed_currency=new JTextField(20);
	JLabel pro_speed_limite=new JLabel("速度上限");
	JTextField text_speed_limite=new JTextField(20);

	//top_right
	JButton submit_load_up=new JButton("加重");
	JTextField text_load_modify =new JTextField(20);
	JButton submit_load_down=new JButton("减重");
	
	JLabel pro_car_load_currency=new JLabel("当前负量");
	JTextField text_car_load_currency=new JTextField(20);
	JLabel pro_car_load_limite=new JLabel("负量上限");
	JTextField text_car_load_limite=new JTextField(20);	
	
	//bottom_left
	JLabel pro_oid_add=new JLabel("加油");
	JTextField text_oil_add=new JTextField(20);
	JButton submit_oil_add=new JButton("确定");
	
	JLabel pro_runmile=new JLabel("运行里数");
	JTextField text_runmile=new JTextField(20);
	JButton submit_runmile=new JButton("确定");
	
	JLabel pro_car_oil_currency=new JLabel("当前油量");
	JTextField text_car_oil_currency=new JTextField(20);
	JLabel pro_car_oil_limite=new JLabel("油箱总量");
	JTextField text_car_oil_limite=new JTextField(20);
	
	//bottom_right

	JLabel pro_car_vehicle_kilometer=new JLabel("总行程公里数");
	JTextField text_car_vehicle_kilometer=new JTextField(20);
	
	JLabel pro_runmile_guess=new JLabel("预测运行里数");
	JTextField text_runmile_guess=new JTextField(20);

	//////////////////////////////////////////////////
	
	//main_build
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
	
	//////////////////////////////////////////////////
	
	//driver_verify_build
	JFrame jf_vd=new JFrame();
	JPanel vd=new JPanel();
	JLabel pro_submit_name=new JLabel("姓名",JLabel.CENTER);
	JTextField text_submit_name=new JTextField(20);
	
	JLabel pro_submit_file_number=new JLabel("档案编号",JLabel.CENTER);
	JTextField text_submit_file_number=new JTextField(20);
	
	JButton submit_driver_verify=new JButton("提交");
	
	//car_verify_build
	JFrame jf_vc=new JFrame();
	JPanel vc=new JPanel();
	JLabel pro_submit_number_plate=new JLabel("汽车号牌",JLabel.CENTER);
	JTextField text_submit_number_plate=new JTextField(20);
	
	JLabel pro_submit_car_iden_id=new JLabel("车辆识别号",JLabel.CENTER);
	JTextField text_submit_car_iden_id=new JTextField(20);

	JButton submit_car_verify=new JButton("提交");
	
	byte mode;

	public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h) {
		ln.setBounds(x,y,w,h);
		ln.setFont(new Font("楷体",Font.PLAIN,25));
		pn.add(ln);
	}	
	
	public void JTextField_add(JTextField tn,JPanel pn,int x,int y,int w,int h) {
		tn.setBounds(x,y,w,h);
		tn.setFont(new Font("楷体",Font.PLAIN,25));
		pn.add(tn);	
	}
	
	public void JButton_add(JButton bn,JPanel pn,int x,int y,int w,int h) {
		bn.setBounds(x,y,w,h);
		bn.setFont(new Font("楷体",Font.PLAIN,25));
		bn.addActionListener(this);
		pn.add(bn);
	}
	
	public void create_jf_jp(JFrame jf,JPanel jp,int w,int h,String title) {
	
		jp.setLayout(null);
		jp.setVisible(true);
		
		jf.setTitle(title);
		jf.setSize(w,h);
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置一个窗口的关闭不会导致其他窗口的关闭
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.add(jp);
		jf.setVisible(false);
		
		//居中显示
		Dimension displaySize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=jf.getSize();
		jf.setLocation((displaySize.width-frameSize.width)/2,(displaySize.height-frameSize.height)/2);
		
	}
	
	//driver
	void create_d() {
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
	
	//car
	void create_c() { 
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
		this.JTextField_add(text_engine_number,c,185,190,200,50);
		this.JLabel_add(pro_car_iden_id,c,395,190,125,50);
		this.JTextField_add(text_car_iden_id,c,530,190,200,50);
		
		//fourth
		this.JLabel_add(pro_PD,c,50,260,125,50);
		this.JTextField_add(text_PD,c,185,260,200,50);
		this.JLabel_add(pro_oil_total,c,395,260,125,50);
		this.JTextField_add(text_oil_total,c,530,260,200,50);
		
		//fifth
		this.JLabel_add(pro_weight,c,50,330,50,50);
		this.JTextField_add(text_weight,c,110,330,100,50);
		this.JLabel_add(pro_load_limite,c,220,330,75,50);
		this.JTextField_add(text_load_limite,c,305,330,100,50);
		this.JLabel_add(pro_vehicle_kilometer,c,415,330,150,50);
		this.JTextField_add(text_vehicle_kilometer,c,575,330,155,50);
		
		//sixth
		this.JButton_add(submit_car_photo,c,325,440,150,50);
		
		//seventh
		this.JButton_add(submit_c,c,350,650,100,50);
	}
	
	//car_condition
	void create_cc() {
		//car:
		this.create_jf_jp(jf_cc,cc,800,800,"汽车状态");

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
		
		//可以在中间设置一个动画
		//点到哪一块，哪一块会略微发亮
		
		// polynomial(3x*4+e^2+c): to calculate (mile,oil,current_oil,car_type)

	}
	
	//driver_verify
	void create_vd() {
		
		this.create_jf_jp(jf_vd,vd,400,400,"驾驶员登录");
		
		this.JLabel_add(pro_submit_name,vd,0,50,125,50);
		this.JTextField_add(text_submit_name,vd,125,50,225,50);
		
		this.JLabel_add(pro_submit_file_number,vd,0,150,125,50);
		this.JTextField_add(text_submit_file_number,vd,125,150,225,50);
		
		this.JButton_add(submit_driver_verify,vd,150,250,100,50);
	}
	
	//car_verify
	void create_vc() {
		
		this.create_jf_jp(jf_vc,vc,400,400,"汽车登录");
		
		this.JLabel_add(pro_submit_number_plate,vc,0,50,125,50);
		this.JTextField_add(text_submit_number_plate,vc,125,50,225,50);
		
		this.JLabel_add(pro_submit_car_iden_id,vc,0,150,125,50);
		this.JTextField_add(text_submit_car_iden_id,vc,125,150,225,50);
		
		this.JButton_add(submit_car_verify,vc,150,250,100,50);
	}
	
	//main
	void create_m() {
		
		this.create_jf_jp(jf_m,m,800,800,"主界面");
		
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
	
	Driving_System() {
	
		//测试：一个(多个)界面注释，其它注释
		
		create_d();
		create_c();
		create_cc();
		create_vd();
		create_vc();
		create_m();
		jf_m.setVisible(true);
		jf_m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//主窗口关闭，就会结束运行
		this.car_conditionIfEdit();	//只用设置一次
		
	}

	public void actionPerformed(ActionEvent e) {
		
		try {
			//main_driver
			if (e.getSource()==submit_driver_create) {
				jf_d.setVisible(true);
				driverIfEdit(true);
			}
			else if (e.getSource()==submit_driver_inquiry) {
				jf_vd.setVisible(true);
				mode=1;
			}
			else if (e.getSource()==submit_driver_modify) {
				jf_vd.setVisible(true);
				mode=2;
			}
			//main_car
			else if (e.getSource()==submit_car_create) {
				jf_c.setVisible(true);
				carIfEdit(true);
			}
			else if (e.getSource()==submit_car_inquiry) {
				jf_vc.setVisible(true);
				mode=3;
			}
			else if (e.getSource()==submit_car_modify) {
				jf_vc.setVisible(true);
				mode=4;
			}
			else if (e.getSource()==submit_car_condition) {
				jf_vc.setVisible(true);
				mode=5;
			}
			//verify_driver
			else if (e.getSource()==submit_driver_verify) {
				
				String submit_name=text_submit_name.getText();
				String submit_file_number=text_submit_file_number.getText();
				if (true) { //match submit_name & submit_file_number in database
					jf_d.setVisible(true);
					if (mode==1) { //inquiry
						driverIfEdit(false);
						submit_d.setVisible(false);
					}
					else { //modify
						driverIfEdit(true);
						submit_d.setVisible(true);
					}
					driverShow(new CarDriver());//change
				}
				
			}
			//verify_car
			else if (e.getSource()==submit_car_verify) {
				jf_vc.setVisible(false);
				String submit_number_plate=text_submit_number_plate.getText();
				String submit_car_iden_id=text_submit_car_iden_id.getText();
				if (true) { //match submit_number_plate & submit_car_iden_id in database
					if (mode==3) { //inquiry
						jf_c.setVisible(true);
						carIfEdit(false);
						carShow(new Car());
					}
					else if (mode==4) { //modify
						jf_c.setVisible(true);
						carIfEdit(true);
					}
					else //car_condition
					{
						jf_cc.setVisible(true);
						car_conditionShow(new Car());
					}
				}
			}
			//(Create+)Save
			else if (e.getSource()==submit_d) {
				if (true)
				{
					JOptionPane.showMessageDialog(null, "提交成功", "信息", JOptionPane.CLOSED_OPTION);
				}
				else
					JOptionPane.showMessageDialog(null, "提交成功", "信息", JOptionPane.CLOSED_OPTION);
				//add to Object driver
				
			}
			//(Create+)Save
			else if (e.getSource()==submit_c) {
				JOptionPane.showMessageDialog(null, "提交成功", "信息", JOptionPane.CLOSED_OPTION);
				//add to Object car
				
			}
			else if (e.getSource()==submit_driver_photo) {
				this.imageShow(chooser_driver_photo,pro_driver_photo,jf_d);
			}
			else if (e.getSource()==submit_car_photo) {
				this.imageShow(chooser_driver_photo,pro_car_photo,jf_c);
			}
		} catch(FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	public String image_pathGet(JFileChooser chooser_photo) throws FileNotFoundException {
		chooser_photo.setCurrentDirectory(new File("."));
		int result=chooser_photo.showOpenDialog(null);
		if (result==JFileChooser.APPROVE_OPTION) {
			String photo_path=chooser_photo.getSelectedFile().getPath();
			return photo_path;
		}
		throw new FileNotFoundException("图片路径不存在");
	}
	
	public void imageSet(String photo_path, JLabel pro_photo, JFrame jf) throws FileNotFoundException {
		Toolkit imgtool=Toolkit.getDefaultToolkit();
		Image img=imgtool.getImage(photo_path);
		img=img.getScaledInstance(240,320,Image.SCALE_DEFAULT);
		ImageIcon imgicon=new ImageIcon(img);
		pro_photo.setIcon(imgicon);
		pro_photo.setBounds(50,400,imgicon.getIconWidth(),imgicon.getIconHeight());
		jf.getLayeredPane().add(pro_photo);
		//判断图片是否存在
		//throw new FileNotFoundException("图片不存在");
	}
	
	public void imageShow(JFileChooser chooser_photo, JLabel pro_photo, JFrame jf) throws FileNotFoundException  {
		String image_path=this.image_pathGet(chooser_photo);
		this.imageSet(image_path,pro_photo,jf);
	}

	void driverInit() throws FileNotFoundException {
		text_name.setText("");
		text_nationality.setText("");
		text_birth.setText("");
		text_driver_address.setText("");
		text_driving_type.setText("");
		text_first_rece.setText("");
		text_valid.setText("");
		text_valid_time.setText("");
		text_file_number.setText("");
		this.imageSet("",pro_driver_photo,jf_d);

	}
	
	void driverShow(CarDriver driver) throws FileNotFoundException {
		
		text_name.setText(driver.get_name());
		text_nationality.setText(driver.get_nationality());
		text_birth.setText(driver.get_birth());
		text_driver_address.setText(driver.get_addr());
		text_driving_type.setText(driver.get_driving_type());
		text_first_rece.setText(driver.get_first_rece());
		text_valid.setText(driver.get_valid());
		text_valid_time.setText(String.valueOf(driver.get_valid_time()));
		text_file_number.setText(String.valueOf(driver.get_file_number()));
		this.imageSet(driver.get_image_path(),pro_driver_photo,jf_d);
		
	}
	
	void driverSave(CarDriver driver) throws FileNotFoundException {
		
		driver.set_name(text_name.getText());
		driver.set_nationality(text_nationality.getText());
		driver.set_birth(text_birth.getText());
		driver.set_addr(text_driver_address.getText());
		driver.set_driving_type(text_driving_type.getText());
		driver.set_first_rece(text_first_rece.getText());
		driver.set_valid(text_valid.getText());
		driver.set_valid_time(Integer.parseInt(text_valid_time.getText()));
		driver.set_file_number(text_file_number.getText());
		driver.set_image_path(image_pathGet(chooser_driver_photo));

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
	
	void carInit() throws FileNotFoundException {
		text_number_plate.setText("");
		text_car_type.setText("");
		text_person.setText("");
		text_car_address.setText("");
		text_engine_number.setText("");
		text_car_iden_id.setText("");
		text_PD.setText("");
		text_oil_total.setText("");
		text_weight.setText("");
		text_load_limite.setText("");
		text_vehicle_kilometer.setText("");
		this.imageSet("",pro_car_photo,jf_c);
		
	}
	
	void carShow(Car car) throws FileNotFoundException {
		
		text_number_plate.setText(car.get_number_plate());
		text_car_type.setText(car.get_car_type());
		text_person.setText(car.get_person());
		text_car_address.setText(car.get_address());
		text_engine_number.setText(car.get_engine_number());
		text_car_iden_id.setText(car.get_car_iden_id());
		text_PD.setText(car.get_PD());
		text_oil_total.setText(String.valueOf(car.get_oil_total()));
		text_weight.setText(String.valueOf(car.get_weight()));
		text_load_limite.setText(String.valueOf(car.get_load_limite()));
		text_vehicle_kilometer.setText(String.valueOf(car.get_vehicle_kilometer()));
		this.imageSet(car.get_image_path(),pro_car_photo,jf_c);

	}
	
	void carSave(Car car) throws FileNotFoundException {
		
		car.set_number_plate(text_number_plate.getText());
		car.set_car_type(text_car_type.getText());
		car.set_person(text_person.getText());
		car.set_address(text_car_address.getText());
		car.set_engine_number(text_engine_number.getText());
		car.set_car_iden_id(text_car_iden_id.getText());
		car.set_PD(text_PD.getText());
		car.set_oil_total(Double.parseDouble(text_oil_total.getText()));
		car.set_weight(Double.parseDouble(text_weight.getText()));
		car.set_load_limite(Double.parseDouble(text_load_limite.getText()));
		car.set_vehicle_kilometer(Double.parseDouble(text_vehicle_kilometer.getText()));
		car.set_image_path(image_pathGet(chooser_car_photo));
	}
	
	void carIfEdit(boolean v) {
		
		text_number_plate.setEditable(v);
		text_car_type.setEditable(v);
		text_person.setEditable(v);
		text_car_address.setEditable(v);
		text_engine_number.setEditable(v);
		text_car_iden_id.setEditable(v);
		text_PD.setEditable(v);
		text_oil_total.setVisible(v);
		text_weight.setEditable(v);
		text_load_limite.setEditable(v);
		text_vehicle_kilometer.setEditable(v);
		
	}
	
	void car_conditionShow(Car car) {
		
		text_car_speed_currency.setText(String.valueOf(car.get_speed_currency()));
		text_car_load_currency.setText(String.valueOf(car.get_load_currency()));
		text_car_oil_currency.setText(String.valueOf(car.get_oil_currency()));
		text_car_vehicle_kilometer.setText(String.valueOf(car.get_vehicle_kilometer()));
		
		//自动修改数值，没有提交按钮保存数值之说
		
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

	void driverIfSave(CarDriver driver) {
		try {
			if (driver.ifCorrect()) {
				driverSave(driver);
			}			
		} catch(Exception e) {
			
		}

	}
	
	void carIfSave(Car car) {
		
		try {
			if (car.ifCorrect()) {
				carSave(car);
			}
		} catch(Exception e) {
			
		}

	}
	
	void database() {
		//database -> Object(class) -> show
		//		   -<				-<
		
	}    
	
	public static String getDesigner(){
		return "设计者：陈冠斌  学号：320150938841 班级：计算机二班";
	}
	
	public static void main(String[] args) {
		CarDriver cardriver = new CarDriver();
		Car car = new Car();
		Driving_System DS=new Driving_System();
		
		DisplayImage.show("D:\\Java\\Code\\homework_problems\\头像照片2.jpg");
	}
}

//Bounds:x(from left to right),y(from top to bottom),width,height

/*
设置初始值：
public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h,Font font) {}
public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h) {
	this.JLabel_add(ln,pn,x,y,w,h,new Font("楷体",Font.PLAIN,25));
}
*/
