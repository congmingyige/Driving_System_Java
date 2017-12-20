import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Car_Verify_Frame extends Basic_Frame {
	
	JFrame jf_vc=new JFrame();
	JPanel vc=new JPanel();
	JLabel pro_submit_number_plate=new JLabel("汽车号牌",JLabel.CENTER);
	JTextField text_submit_number_plate=new JTextField(20);
	
	JLabel pro_submit_car_iden_id=new JLabel("车辆识别号",JLabel.CENTER);
	JTextField text_submit_car_iden_id=new JTextField(20);

	JButton submit_car_verify=new JButton("提交");
	
	int mode;
	
	Car_Verify_Frame() {
		
		this.create_jf_jp(jf_vc,vc,400,400,"汽车登录");
		
		this.JLabel_add(pro_submit_number_plate,vc,0,50,125,50);
		this.JTextField_add(text_submit_number_plate,vc,125,50,225,50);
		
		this.JLabel_add(pro_submit_car_iden_id,vc,0,150,125,50);
		this.JTextField_add(text_submit_car_iden_id,vc,125,150,225,50);
		
		this.JButton_add(submit_car_verify,vc,150,250,100,50);
	}
	
	Car_Verify_Frame(int mode) {
		this();
		this.mode=mode;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==submit_car_verify) {
				String number_plate=text_submit_number_plate.getText();
				String car_iden_id=text_submit_car_iden_id.getText();
				ResultSet rs=Driving_System_MySQL.execQuery("select * from CAR where number_plate='"+number_plate+"' and car_iden_id='"+car_iden_id+"'");
				if (rs.next()) {
					if (mode==4) { //car_condition
						jf_vc.dispose();
						Car_Condition_Frame ccf=new Car_Condition_Frame(rs.getInt(21));
					}
					else {
						jf_vc.dispose();
						Car_Frame cf=new Car_Frame(mode, rs.getInt(21));
					}
				} else {
					JOptionPane.showMessageDialog(null, "提交失败", "信息", JOptionPane.CLOSED_OPTION);
				}
			}
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
}
