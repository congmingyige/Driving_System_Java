
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
	private String file_number;
	//图片放置在对应文件夹photo下，该文件夹设置为只能通过特定程序修改
	private String image_path;

	
	CarDriver() {
	}
	CarDriver(String file_number) {
		this.file_number=file_number;
	}
	CarDriver(String name,String nationality,String addr,
			int birth_yy, int birth_mm, int birth_dd, String driving_type,
			int first_rece_yy, int first_rece_mm, int first_rece_dd,
			int valid_yy, int valid_mm, int valid_dd,
			String file_number, String image_path) {
		this.name=name; this.nationality=nationality; this.addr=addr;
		this.birth_yy=birth_yy; this.birth_mm=birth_mm; this.birth_dd=birth_dd; this.driving_type=driving_type;
		this.first_rece_yy=first_rece_yy; this.first_rece_mm=first_rece_mm; this.first_rece_dd=first_rece_dd;
		this.valid_yy=valid_yy; this.valid_mm=valid_mm; this.valid_dd=valid_dd;
		this.file_number=file_number; this.image_path=image_path;
		//如何判断图片相同
	}
	
	public int hashCode() {
		return file_number.hashCode();
	}
	
	public boolean equals(CarDriver d) {
		return name==d.name && nationality==d.nationality && addr==d.addr
			&& birth_yy==d.birth_yy && birth_mm==d.birth_mm && birth_dd==d.birth_dd && driving_type==d.driving_type
			&& first_rece_yy==d.first_rece_yy && first_rece_mm==d.first_rece_mm && first_rece_dd==d.first_rece_dd
			&& valid_yy==d.valid_yy && valid_mm==d.valid_mm && valid_dd==d.valid_dd
			&& file_number==d.file_number && image_path==d.image_path ;
	}
	
	public String toString() {
		String str="";
		str = str + "name : " + this.getName() + "\n";
		str = str + "nationality : " + this.getNationality() + "\n";
		str = str + "address : " + this.getAddr() + "\n";
		str = str + "driving_type : " + this.getDriving_type() + "\n";
		str = str + "birth : " + this.getBirth() + "\n";
		str = str + "license-first receive : " + this.getFirst_rece() + "\n";
		str = str + "license-valid until : " + this.getValid() + "\n";
		str = str + "license-valid time : " + this.getValid_time() + "\n";
		str = str + "file number : " + this.getFile_number() + "\n";
		str = str + "image : " + this.getImage_path() + "\n";		
		return str;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getBirth() {
		return Integer.toString(birth_yy)+"-"+Integer.toString(birth_mm)+"-"+Integer.toString(birth_dd);
	}
	
	public void setBirth(String birth) {
		String[] re=birth.split("-");
		this.birth_yy=Integer.parseInt(re[0]);
		this.birth_mm=Integer.parseInt(re[1]);
		this.birth_dd=Integer.parseInt(re[2]);
	}
//(int birth_yy, int birth_mm, int birth_dd){this.birth_yy=birth_yy; this.birth_mm=birth_mm; this.birth_dd=birth_dd;}
	
	public int getBirth_yy() {
		return birth_yy;
	}
	
	public void setBirth_yy(int birth_yy) {
		this.birth_yy = birth_yy;
	}
	
	public int getBirth_mm() {
		return birth_mm;
	}
	
	public void setBirth_mm(int birth_mm) {
		this.birth_mm = birth_mm;
	}
	
	public int getBirth_dd() {
		return birth_dd;
	}
	
	public void setBirth_dd(int birth_dd) {
		this.birth_dd = birth_dd;
	}
	
	public String getDriving_type() {
		return driving_type;
	}
	
	public void setDriving_type(String driving_type) {
		this.driving_type = driving_type;
	}
	
	public String getFirst_rece() {
		return Integer.toString(first_rece_yy)+"-"+Integer.toString(first_rece_mm)+"-"+Integer.toString(first_rece_dd);
	}	
	
	public void setFirst_rece(String first_rece) {
		String[] re=first_rece.split("-");
		this.first_rece_yy=Integer.parseInt(re[0]);
		this.first_rece_mm=Integer.parseInt(re[1]);
		this.first_rece_dd=Integer.parseInt(re[2]);
	}
	//(int first_rece_yy, int first_rece_mm, int first_rece_dd){this.first_rece_yy=first_rece_yy; this.first_rece_mm=first_rece_mm; this.first_rece_dd=first_rece_dd;}
	
	public int getFirst_rece_yy() {
		return first_rece_yy;
	}
	
	public void setFirst_rece_yy(int first_rece_yy) {
		this.first_rece_yy = first_rece_yy;
	}
	
	public int getFirst_rece_mm() {
		return first_rece_mm;
	}
	
	public void setFirst_rece_mm(int first_rece_mm) {
		this.first_rece_mm = first_rece_mm;
	}
	
	public int getFirst_rece_dd() {
		return first_rece_dd;
	}
	
	public void setFirst_rece_dd(int first_rece_dd) {
		this.first_rece_dd = first_rece_dd;
	}
	
	public String getValid(){
		return Integer.toString(valid_yy)+"-"+Integer.toString(valid_mm)+"-"+Integer.toString(valid_dd);
	}
	
	public void setValid(String valid) {
		String[] re=valid.split("-");
		this.valid_yy=Integer.parseInt(re[0]);
		this.valid_mm=Integer.parseInt(re[1]);
		this.valid_dd=Integer.parseInt(re[2]);
	}
	//(int valid_yy, int valid_mm, int valid_dd){this.valid_yy=valid_yy; this.valid_mm=valid_mm; this.valid_dd=valid_dd;}
	
	public int getValid_yy() {
		return valid_yy;
	}
	
	public void setValid_yy(int valid_yy) {
		this.valid_yy = valid_yy;
	}
	
	public int getValid_mm() {
		return valid_mm;
	}
	
	public void setValid_mm(int valid_mm) {
		this.valid_mm = valid_mm;
	}
	
	public int getValid_dd() {
		return valid_dd;
	}
	
	public void setValid_dd(int valid_dd) {
		this.valid_dd = valid_dd;
	}
	
	public int getValid_time() {
		return valid_time;
	}
	
	public void setValid_time(int valid_time) {
		this.valid_time = valid_time;
	}
	
	public String getFile_number() {
		return file_number;
	}
	
	public void setFile_number(String file_number) {
		this.file_number = file_number;
	}
	
	public String getImage_path() {
		return image_path;
	}
	
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
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
