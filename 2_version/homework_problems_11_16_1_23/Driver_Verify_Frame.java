import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


class Driver_Verify_Frame extends Basic_Frame {
	
	JFrame jf_vd=new JFrame();
	JPanel vd=new JPanel();
	JLabel pro_submit_name=new JLabel("姓名",JLabel.CENTER);
	JTextField text_submit_name=new JTextField(20);
	
	JLabel pro_submit_file_number=new JLabel("档案编号",JLabel.CENTER);
	JTextField text_submit_file_number=new JTextField(20);
	
	JButton submit_driver_verify=new JButton("提交");
	
	int mode;
	
	Driver_Verify_Frame() {
		this.create_jf_jp(jf_vd,vd,400,400,"驾驶员登录");
		
		this.JLabel_add(pro_submit_name,vd,0,50,125,50);
		this.JTextField_add(text_submit_name,vd,125,50,225,50);
		
		this.JLabel_add(pro_submit_file_number,vd,0,150,125,50);
		this.JTextField_add(text_submit_file_number,vd,125,150,225,50);
		
		this.JButton_add(submit_driver_verify,vd,150,250,100,50);
	}
	
	Driver_Verify_Frame(int mode) {
		this();
		this.mode=mode;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource()==submit_driver_verify) {
				String name=text_submit_name.getText();
				String file_number=text_submit_file_number.getText();
				int driver_index;
				for (driver_index=1;driver_index<=Driving_System.driver_count;driver_index++)
					if (Driving_System.driver[driver_index].getName().equals(name)
						&& Driving_System.driver[driver_index].getFile_number().equals(file_number))
						break;
				if (driver_index!=Driving_System.driver_count+1) {
					jf_vd.dispose();
					Driver driver=new Driver();
					Driver_Frame df=new Driver_Frame(mode, driver_index);
				} else {
					JOptionPane.showMessageDialog(null, "提交失败", "信息", JOptionPane.CLOSED_OPTION);
				}
			}
		} catch(Exception e1) {
			System.out.println(e1.getMessage());
		}
	}
	
}
