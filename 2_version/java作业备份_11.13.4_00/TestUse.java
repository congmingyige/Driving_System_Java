import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestUse extends JFrame{
	static void add(JLabel ln,JPanel pn)
	{
		ln.setBounds(50,50,50,50);
		ln.setFont(new Font("¿¬Ìå",Font.PLAIN,25));
		pn.add(ln);
	}
	
	public static void main(String[] args) {
		JFrame jf_d=new JFrame();
		JPanel d=new JPanel();
		
		d.setLayout(null);
///		d.setVisible(true);
		
		jf_d.setVisible(true);
		jf_d.setSize(800,800);
		jf_d.add(d);

		
		Dimension displaySize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=jf_d.getSize();
		jf_d.setLocation((displaySize.width-frameSize.width)/2,(displaySize.height-frameSize.height)/2);

		JLabel pro_name=new JLabel("ÐÕÃû");
		TestUse.add(pro_name,d);
	}
}
