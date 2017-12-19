
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class CarDriver {
	//file_number:unique
	private String name,nationality,addr;	//"Chinese" rather than "China"
	private int birth_yy,birth_mm,birth_dd;
	private String driving_type;
	private int first_rece_yy,first_rece_mm,first_rece_dd;
	private int valid_yy,valid_mm,valid_dd,valid_time;
	private String file_number;
	//图片放置在对应文件夹image下，该文件夹设置为只能通过特定程序修改
	private String image_path;

	CarDriver() {
	}

	CarDriver(String name, String file_number) {
		this.name=name;
		this.file_number=file_number;
	}

	CarDriver(String name, String nationality, String addr,
			int birth_yy, int birth_mm, int birth_dd, String driving_type,
			int first_rece_yy, int first_rece_mm, int first_rece_dd,
			int valid_yy, int valid_mm, int valid_dd, int valid_time,
			String file_number, String image_path) {
		this.name=name; this.nationality=nationality; this.addr=addr;
		this.birth_yy=birth_yy; this.birth_mm=birth_mm; this.birth_dd=birth_dd; this.driving_type=driving_type;
		this.first_rece_yy=first_rece_yy; this.first_rece_mm=first_rece_mm; this.first_rece_dd=first_rece_dd;
		this.valid_yy=valid_yy; this.valid_mm=valid_mm; this.valid_dd=valid_dd; this.valid_time=valid_time;
		this.file_number=file_number; this.image_path=image_path;
	}
	
	public int hashCode() {
		return file_number.hashCode();
	}
	
	public boolean equals(CarDriver d) {
		return name.equals(d.name) && nationality.equals(d.nationality) && addr.equals(d.addr)
			&& birth_yy==d.birth_yy && birth_mm==d.birth_mm && birth_dd==d.birth_dd && driving_type.equals(d.driving_type)
			&& first_rece_yy==d.first_rece_yy && first_rece_mm==d.first_rece_mm && first_rece_dd==d.first_rece_dd
			&& valid_yy==d.valid_yy && valid_mm==d.valid_mm && valid_dd==d.valid_dd && valid_time==d.valid_time
			&& file_number.equals(d.file_number) && image_path.equals(d.image_path) ;
	}
	
	public String toString() {
		String str="";
		str = str + "name : " + this.getName() + "\n";
		str = str + "nationality : " + this.getNationality() + "\n";
		str = str + "address : " + this.getAddr() + "\n";
		str = str + "birth : " + this.getBirth() + "\n";
		str = str + "driving_type : " + this.getDriving_type() + "\n";
		str = str + "license valid in : " + this.getFirst_rece() + "\n";
		str = str + "license valid end : " + this.getValid() + "\n";
		str = str + "license valid time : " + this.getValid_time() + "\n";
		str = str + "file_number : " + this.getFile_number() + "\n";
		str = str + "image_path : " + this.getImage_path() + "\n";		
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
		return String.format("%02d",birth_yy)+"-"+String.format("%02d",birth_mm)+"-"+String.format("%02d",birth_dd);
		//return Integer.toString(birth_yy)+"-"+Integer.toString(birth_mm)+"-"+Integer.toString(birth_dd);	
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
		//return Integer.toString(first_rece_yy)+"-"+Integer.toString(first_rece_mm)+"-"+Integer.toString(first_rece_dd);
		return String.format("%02d",first_rece_yy)+"-"+String.format("%02d",first_rece_mm)+"-"+String.format("%02d",first_rece_dd);
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
		return String.format("%02d",valid_yy)+"-"+String.format("%02d",valid_mm)+"-"+String.format("%02d",valid_dd);
		//return Integer.toString(valid_yy)+"-"+Integer.toString(valid_mm)+"-"+Integer.toString(valid_dd);
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
	
	public static boolean iflegalName(String str) {
		return Pattern.matches("^\\S{1,20}$", str);
		//武绍波
	}
	
	public static boolean iflegalNationality(String str) {
		return Pattern.matches("^中国|中国香港|中国澳门|中国台湾$", str);
		//中国
	}
	
	public static boolean iflegalBirth(String str) {
		return Pattern.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$", str);
		//1992-01-18
	}
	
	public static boolean iflegalAddr(String str) {
		return Pattern.matches("^\\S{1,50}$", str);
		//广东省阳西县上洋镇居民委员会建设中路65号
	}
	
	public static boolean iflegalDriving_type(String str) {
		return Pattern.matches("^[A-Z][0-9]$", str);
		//C1
	}
	
	public static boolean iflegalFirst_rece(String str) {
		return Pattern.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$", str);
		//2012-12-20
	}
	
	public static boolean iflegalValid(String str) {
		return Pattern.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$", str);
		//2012-12-20
	}
	
	public static boolean iflegalValid_time(String str) throws NumberFormatException {
		try {
			double value = Double.parseDouble(str);
			if (value>0 && value<=10)
				return true;
			else
				return false;			
		} catch(NumberFormatException e1) {
			throw new NumberFormatException("有效期限");
		}
		//3
	}
	
	public static boolean iflegalFile_number(String str) {
		return Pattern.matches("^[0-9]{12}$", str);
		//440710418572
	}
	
	public static boolean iflegalImage_path(String str) {
		File f=new File(str);
		if (f.exists() && Pattern.matches("^\\S{1,50}$", str))
			return true;
		else
			return false;
	}
	
	public void getTable(ResultSet rs) throws SQLException {
		name=rs.getString(1);
		nationality=rs.getString(2);
		addr=rs.getString(3);
		birth_yy=rs.getInt(4);
		birth_mm=rs.getInt(5);
		birth_dd=rs.getInt(6);
		driving_type=rs.getString(7);
		first_rece_yy=rs.getInt(8);
		first_rece_mm=rs.getInt(9);
		first_rece_dd=rs.getInt(10);
		valid_yy=rs.getInt(11);
		valid_mm=rs.getInt(12);
		valid_dd=rs.getInt(13);
		valid_time=rs.getInt(14);
		file_number=rs.getString(15);
		image_path=rs.getString(16);
	}
	
	public String insertTable() {
		//用trim:String类型进行了初始化(etc. str=new String() str=str1)
		String str="insert into DRIVER values('"+
			name.trim()+"','"+nationality.trim()+"','"+addr.trim()+"',"+
			Integer.toString(birth_yy).trim()+","+Integer.toString(birth_mm).trim()+","+Integer.toString(birth_dd).trim()+",'"+
			driving_type.trim()+"',"+
			Integer.toString(first_rece_yy).trim()+","+Integer.toString(first_rece_mm).trim()+","+Integer.toString(first_rece_dd).trim()+","+
			Integer.toString(valid_yy).trim()+","+Integer.toString(valid_mm).trim()+","+Integer.toString(valid_dd).trim()+","+
			Integer.toString(valid_time).trim()+",'"+file_number+"','"+image_path.replace("\\","\\\\").trim()+"',null)";
//		System.out.println(str);
		return str;
	}
	
	public String updateTable() {
		String str="update DRIVER set "+
			"nationality='"+nationality.trim()+"',"+
			"addr='"+addr.trim()+"',"+
			"birth_yy="+Integer.toString(birth_yy).trim()+","+
			"birth_mm="+Integer.toString(birth_mm).trim()+","+
			"birth_dd="+Integer.toString(birth_dd).trim()+","+
			"driving_type='"+driving_type.trim()+"',"+
			"first_rece_yy="+Integer.toString(first_rece_yy).trim()+","+
			"first_rece_mm="+Integer.toString(first_rece_mm).trim()+","+
			"first_rece_dd="+Integer.toString(first_rece_dd).trim()+","+
			"valid_yy="+Integer.toString(valid_yy).trim()+","+
			"valid_mm="+Integer.toString(valid_mm).trim()+","+
			"valid_dd="+Integer.toString(valid_dd).trim()+","+
			"valid_time="+Integer.toString(valid_time).trim()+","+
			"image_path='"+image_path.replace("\\","\\\\").trim()+"'"+
			" where "+
			"name='"+name.trim()+"' and "+
			"file_number="+file_number;
//		System.out.println(str);
		return str;
	}
	
	public boolean ifcorrect(String name, String nationality, String birth, String addr, String driving_type,
			String first_rece, String valid, String valid_time, String file_number, String image_path) {
		try {
			if (!iflegalName(name))
				throw new Exception("姓名");
			if (!iflegalNationality(nationality))
				throw new Exception("国籍");
			if (!iflegalBirth(birth))
				throw new Exception("出生日期");
			if (!iflegalAddr(addr))
				throw new Exception("居住地址");
			if (!iflegalDriving_type(driving_type))
				throw new Exception("驾驶车型");
			if (!iflegalFirst_rece(first_rece))
				throw new Exception("初次领证日期");
			if (!iflegalValid(valid))
				throw new Exception("有效日期");
			if (!iflegalValid_time(valid_time))
				throw new Exception("有效期限");
			if (!iflegalFile_number(file_number))
				throw new Exception("档案编号");
			if (!iflegalImage_path(image_path))
				throw new FileNotFoundException();
			return true;
		} catch(NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage()+" : 不是数字", "信息", JOptionPane.CLOSED_OPTION);
		} catch(FileNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "图片不存在", "信息", JOptionPane.CLOSED_OPTION);
		} catch(IOException e3) {
			JOptionPane.showMessageDialog(null, "文件操作错误", "信息", JOptionPane.CLOSED_OPTION);
		} catch(Exception e4) {
			 JOptionPane.showMessageDialog(null, e4.getMessage()+"格式错误", "信息", JOptionPane.CLOSED_OPTION);
		}
		return false;
	}
}

class DisplayImage {
	public static void show(String addr) {
		Toolkit imgtool=Toolkit.getDefaultToolkit();
		Image myimg=imgtool.getImage(addr);
		showInFrame(myimg);
	}
	
	public static void showInFrame(Image img) {
		JFrame frame=new JFrame("image");
		ImageIcon imgicon=new ImageIcon(img);
		frame.setSize(imgicon.getIconWidth(), imgicon.getIconHeight());
		
		JLabel label=new JLabel();
		label.setIcon(imgicon);
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
