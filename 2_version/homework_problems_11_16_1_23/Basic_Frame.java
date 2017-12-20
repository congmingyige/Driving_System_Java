import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

abstract class Basic_Frame implements ActionListener {
	public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h) {

		ln.setHorizontalAlignment(JLabel.CENTER);
		ln.setBounds(x,y,w,h);
		ln.setFont(new Font("����",Font.PLAIN,25));
		pn.add(ln);
	}	
	
	public void JTextField_add(JTextField tn,JPanel pn,int x,int y,int w,int h) {
		tn.setBounds(x,y,w,h);
		tn.setFont(new Font("����",Font.PLAIN,25));
		pn.add(tn);	
	}
	
	public void JButton_add(JButton bn,JPanel pn,int x,int y,int w,int h) {
		bn.setBounds(x,y,w,h);
		bn.setFont(new Font("����",Font.PLAIN,25));
		bn.addActionListener(this);
		pn.add(bn);
	}
	
	public void create_jf_jp(JFrame jf,JPanel jp,int w,int h,String title) {
	
		jp.setLayout(null);
		jp.setVisible(true);
		
		jf.setTitle(title);
		jf.setSize(w,h);
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����һ�����ڵĹرղ��ᵼ���������ڵĹر�
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.add(jp);
		
		//������ʾ
		Dimension displaySize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=jf.getSize();
		jf.setLocation((displaySize.width-frameSize.width)/2,(displaySize.height-frameSize.height)/2);
		
		jf.setResizable(false); //���ɸı䴰�ڴ�С
		jf.setVisible(true); //�����ŵ���󣬳������ս���(�����۾����ܵ�������޸�)
		
	}
	
	public String getImage_path(JFileChooser chooser_image) throws IOException,FileNotFoundException {
		chooser_image.setDialogTitle("��");
		chooser_image.setCurrentDirectory(new File("."));
		int result=chooser_image.showOpenDialog(null);
		if (result==1) //result=1:���˹رհ�ť����һ��ִ�л����
			return "";
		String str=chooser_image.getSelectedFile().getPath();
		File f=new File(str);
		if (f.exists())
			return str;
		throw new FileNotFoundException("ͼƬ������");
	}
	
	public void setImage(String image_path, JLabel pro_image, JFrame jf){
		Toolkit imgtool=Toolkit.getDefaultToolkit();
		Image img=imgtool.getImage(image_path);
		img=img.getScaledInstance(240,320,Image.SCALE_DEFAULT); //ͼƬ��Сת��Ϊ240*320
		ImageIcon imgicon=new ImageIcon(img);
		pro_image.setIcon(imgicon);
		pro_image.setBounds(50,400,imgicon.getIconWidth(),imgicon.getIconHeight());
		jf.getLayeredPane().add(pro_image);
	}
	
//	public void showImage(JFileChooser chooser_image, JLabel pro_image, JFrame jf) throws FileNotFoundException {
//		String image_path=getImage_path(chooser_image);
//		setImage(image_path,pro_image,jf);
//	}
	
	public void JFrameToImage(JFrame jf) throws IOException,FileNotFoundException {
		BufferedImage bi=new BufferedImage(jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d=bi.createGraphics();
		jf.paint(g2d);
		
		JFileChooser chooser=new JFileChooser();
		chooser.setDialogTitle("���Ϊ");
		chooser.setApproveButtonText("����");
		chooser.setCurrentDirectory(new File("."));
		int result=chooser.showOpenDialog(null);
		if (result==1) //result=1:���˹رհ�ť����һ��ִ�л����
			return ;
		String path=chooser.getSelectedFile().getPath();
		path=path+(".png");
		File f=new File(path);
		if (f.exists()) {
			JOptionPane.showMessageDialog(null, "��ǰĿ¼������ͬͼƬ������ʧ��", "��Ϣ", JOptionPane.CLOSED_OPTION);
		}
		else {
			ImageIO.write(bi,"PNG",new File(path));
		}
}

	abstract public void actionPerformed(ActionEvent arg0);
}
