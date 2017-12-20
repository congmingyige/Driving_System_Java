import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

abstract class Basic_Frame implements ActionListener {
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
		
		//居中显示
		Dimension displaySize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=jf.getSize();
		jf.setLocation((displaySize.width-frameSize.width)/2,(displaySize.height-frameSize.height)/2);
		
		jf.setVisible(true); //该语句放到最后，呈现最终界面(不让眼睛感受到界面的修改)
		
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

	abstract public void actionPerformed(ActionEvent arg0);
}
