
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

class CarDriver {
	//file_number:unique
	private String name,nationality,addr;	//"Chinese" rather than "China"
	private int birth_yy,birth_mm,birth_dd;
	private String driving_type;
	private int first_rece_yy,first_rece_mm,first_rece_dd;
	private int valid_yy,valid_mm,valid_dd,valid_time;
	//图片放置在对应文件夹photo下，该文件夹设置为只能通过特定程序修改
	private String image_path;
	private String file_number;
	
	CarDriver() {
	}
	CarDriver(String file_number) {
		this.file_number=file_number;
	}
	CarDriver(String name,String nationality,String addr,
			int birth_yy, int birth_mm, int birth_dd, String driving_type,
			int first_rece_yy, int first_rece_mm, int first_rece_dd,
			int valid_yy, int valid_mm, int valid_dd,
			String image_path, String file_number) {
		this.name=name; this.nationality=nationality; this.addr=addr;
		this.birth_yy=birth_yy; this.birth_mm=birth_mm; this.birth_dd=birth_dd; this.driving_type=driving_type;
		this.first_rece_yy=first_rece_yy; this.first_rece_mm=first_rece_mm; this.first_rece_dd=first_rece_dd;
		this.valid_yy=valid_yy; this.valid_mm=valid_mm; this.valid_dd=valid_dd;
		this.image_path=image_path; this.file_number=file_number;
	}
	
	public int hashCode() {
		return file_number.hashCode();
	}
	
	public boolean equals(CarDriver d) {
		return name==d.name && nationality==d.nationality && addr==d.addr
			&& birth_yy==d.birth_yy && birth_mm==d.birth_mm && birth_dd==d.birth_dd && driving_type==d.driving_type
			&& first_rece_yy==d.first_rece_yy && first_rece_mm==d.first_rece_mm && first_rece_dd==d.first_rece_dd
			&& valid_yy==d.valid_yy && valid_mm==d.valid_mm && valid_dd==d.valid_dd
			&& image_path==d.image_path && file_number==d.file_number ;
	}
	
	public String toString() {
		String str="";
		str = str + "name : " + this.get_name() + "\n";
		str = str + "nationality : " + this.get_nationality() + "\n";
		str = str + "address : " + this.get_addr() + "\n";
		str = str + "driving_type : " + this.get_driving_type() + "\n";
		str = str + "birth : " + this.get_birth() + "\n";
		str = str + "license-first receive : " + this.get_first_rece() + "\n";
		str = str + "license-valid until : " + this.get_valid() + "\n";
		str = str + "license-valid time : " + this.get_valid_time() + "\n";
		str = str + "image : " + this.get_image_path() + "\n";
		str = str + "file number : " + this.get_file_number() + "\n";
		return str;
	}
	
	public String get_name(){return name;}
	public String get_nationality(){return nationality;}
	public String get_addr(){return addr;}
	public String get_driving_type(){return driving_type;}
	
	public String get_birth(){return Integer.toString(birth_yy)+"-"+Integer.toString(birth_mm)+"-"+Integer.toString(birth_dd);}
	public int get_birth_yy(){return birth_yy;}
	public int get_birth_mm(){return birth_mm;}
	public int get_birth_dd(){return birth_dd;}
	
	public String get_first_rece(){return Integer.toString(first_rece_yy)+"-"+Integer.toString(first_rece_mm)+"-"+Integer.toString(first_rece_dd);}
	public int get_first_rece_yy(){return first_rece_yy;}
	public int get_first_rece_mm(){return first_rece_mm;}
	public int get_first_rece_dd(){return first_rece_dd;}
	
	public String get_valid(){return Integer.toString(valid_yy)+"-"+Integer.toString(valid_mm)+"-"+Integer.toString(valid_dd);}
	public int get_valid_yy(){return valid_yy;}
	public int get_valid_mm(){return valid_mm;}
	public int get_valid_dd(){return valid_dd;}
	public int get_valid_time(){return valid_time;}
	
	public String get_image_path() {return image_path;}
	
	public String get_file_number(){return file_number;}
	
	//////
	
	public void set_name(String name){this.name=name;}
	public void set_nationality(String nationality){this.nationality=nationality;}
	public void set_addr(String addr){this.addr=addr;}
	public void set_driving_type(String driving_type){this.driving_type=driving_type;}
	
	public void set_birth(String birth) {
			String[] re=birth.split("-");
			this.birth_yy=Integer.parseInt(re[0]);
			this.birth_mm=Integer.parseInt(re[1]);
			this.birth_dd=Integer.parseInt(re[2]);
		}
	//(int birth_yy, int birth_mm, int birth_dd){this.birth_yy=birth_yy; this.birth_mm=birth_mm; this.birth_dd=birth_dd;}
	public void set_birth_yy(int birth_yy){this.birth_yy=birth_yy;}
	public void set_birth_mm(int birth_mm){this.birth_mm=birth_mm;}
	public void set_birth_dd(int birth_dd){this.birth_dd=birth_dd;}
	
	public void set_first_rece(String first_rece) {
		String[] re=first_rece.split("-");
		this.first_rece_yy=Integer.parseInt(re[0]);
		this.first_rece_mm=Integer.parseInt(re[1]);
		this.first_rece_dd=Integer.parseInt(re[2]);
	}
	//(int first_rece_yy, int first_rece_mm, int first_rece_dd){this.first_rece_yy=first_rece_yy; this.first_rece_mm=first_rece_mm; this.first_rece_dd=first_rece_dd;}
	public void set_first_rece_yy(int first_rece_yy){this.first_rece_yy=first_rece_yy;}
	public void set_first_rece_mm(int first_rece_mm){this.first_rece_mm=first_rece_mm;}
	public void set_first_rece_dd(int first_rece_dd){this.first_rece_dd=first_rece_dd;}
	
	public void set_valid(String valid) {
		String[] re=valid.split("-");
		this.valid_yy=Integer.parseInt(re[0]);
		this.valid_mm=Integer.parseInt(re[1]);
		this.valid_dd=Integer.parseInt(re[2]);
	}
	//(int valid_yy, int valid_mm, int valid_dd){this.valid_yy=valid_yy; this.valid_mm=valid_mm; this.valid_dd=valid_dd;}
	public void set_valid_yy(int valid_yy){this.valid_yy=valid_yy;}
	public void set_valid_mm(int valid_mm){this.valid_mm=valid_mm;}
	public void set_valid_dd(int valid_dd){this.valid_dd=valid_dd;}
	public void set_valid_time(int valid_time){this.valid_time=valid_time;}
	
	public void set_image_path(String image_path){this.image_path=image_path;}
	
	public void set_file_number(String file_number){this.file_number=file_number;}

	public boolean ifCorrect() {
		return true;
	}

}

class DisplayImage {
	public static void show(String addr) {
		Toolkit imgtool=Toolkit.getDefaultToolkit();
		Image myimg=imgtool.getImage(addr);
		showInFrame(myimg);
	}
	
	public static void showInFrame(Image img) {
		JFrame frame=new JFrame("photo");
		ImageIcon imgicon=new ImageIcon(img);
		frame.setSize(imgicon.getIconWidth(), imgicon.getIconHeight());
		
		JLabel label=new JLabel();
		label.setIcon(imgicon);
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
