import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

class Car {
	//number_plate:unique
	private String number_plate,car_type,person,address,engine_number,car_iden_id;
	private int PD_yy,PD_mm,PD_dd;
	private String image_path;
	
	private double speed_currency=0,speed_limite=100;//mainly depends on car
	private double weight=1,load_currency=0,load_limite=5;
	private double oil_currency=0,oil_limite=10,oil_ave_use=0.06;//default
	private double vehicle_kilometer=0,car_coefficient=0.07;  //car_coefficient : 车辆本身的属性，影响平均用油量
	//oil_ave_use = car_coefficient+0.005*load_currency+(speed_currency-60)*0.0001;
	Car() {
	}
	
	Car(String number_plate, String car_iden_id) {
		this.number_plate=number_plate;
		this.car_iden_id=car_iden_id;
	}
	
	Car(String number_plate, String car_type, String person,
		String address, String engine_number, String car_iden_id,
		int PD_yy, int PD_mm, int PD_dd, String image_path,
		double speed_currency, double speed_limite,
		double weight, double load_currency, double load_limite,
		double oil_currency,double oil_limite,double oil_ave_use, 
		double vehicle_kilometer, double car_coefficient		
		) {
		
		this.number_plate=number_plate; this.car_type=car_type; this.person=person;
		this.address=address; this.engine_number=engine_number; this.car_iden_id=car_iden_id;
		this.PD_yy=PD_yy; this.PD_mm=PD_mm; this.PD_dd=PD_dd; this.image_path=image_path;
		this.speed_currency=speed_currency; this.speed_limite=speed_limite;
		this.weight=weight; this.load_currency=load_currency; this.load_limite=load_limite;
		this.oil_currency=oil_currency; this.oil_limite=oil_limite; this.oil_ave_use=oil_ave_use;
		this.vehicle_kilometer=vehicle_kilometer; this.car_coefficient=car_coefficient;
	}

	public int hashCode() {
		return number_plate.hashCode();
	}
	
	public boolean equals(Car c) {
		return number_plate.equals(c.number_plate) && car_type.equals(c.car_type) && person.equals(c.person)
			&& address.equals(c.address) && engine_number.equals(c.engine_number) && car_iden_id.equals(c.car_iden_id)
			&& PD_yy==c.PD_yy && PD_mm==c.PD_mm && PD_dd==c.PD_dd && image_path.equals(c.image_path)
			&& speed_currency==c.speed_currency && speed_limite==c.speed_currency
			&& weight==c.weight && load_currency==c.load_currency && load_limite==c.load_limite
			&& oil_currency==c.oil_currency && oil_limite==c.oil_limite && oil_ave_use==c.oil_ave_use
			&& vehicle_kilometer==c.vehicle_kilometer && car_coefficient==car_coefficient;
	}
	
	public String toString() {
		String str="";
		str = str + "number_plate : " + this.getNumber_plate() + "\n";
		str = str + "car_type : " + this.getCar_type() + "\n";
		str = str + "person : " + this.getPerson() + "\n";
		str = str + "address : " + this.getAddress() + "\n";
		str = str + "engine_number : " + this.getEngine_number() + "\n";
		str = str + "car_iden_id : " + this.getCar_iden_id() + "\n";
		str = str + "PD : " + this.getPD() + "\n";
		str = str + "image_path : " + this.getImage_path() + "\n";
		str = str + "speed_currency : " + this.getSpeed_currency() + "\n";
		str = str + "speed_limite : " + this.getSpeed_limite() + "\n";
		str = str + "weight : " + this.getWeight() + "\n";
		str = str + "load_currency : " + this.getLoad_currency() + "\n";
		str = str + "load_limite : " + this.getLoad_limite() + "\n";
		str = str + "oil_currency : " + this.getOil_currency() + "\n";
		str = str + "oil_limite : " + this.getOil_limite() + "\n";
		str = str + "oil_ave_use : " + this.getOil_ave_use() + "\n";
		str = str + "vehicle_kilometer : " + this.getVehicle_kilometer() + "\n";
		str = str + "car_coefficient : " + this.getCar_coefficient() + "\n";
		return str;
	}
	
	public String getNumber_plate() {
		return number_plate;
	}

	public void setNumber_plate(String number_plate) {
		this.number_plate = number_plate;
	}

	public String getCar_type() {
		return car_type;
	}

	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEngine_number() {
		return engine_number;
	}

	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}

	public String getCar_iden_id() {
		return car_iden_id;
	}

	public void setCar_iden_id(String car_iden_id) {
		this.car_iden_id = car_iden_id;
	}

	public String getPD() {
		return String.format("%02d",PD_yy)+"-"+String.format("%02d",PD_mm)+"-"+String.format("%02d",PD_dd);
		//return Integer.toString(PD_yy)+"-"+Integer.toString(PD_mm)+"-"+Integer.toString(PD_dd);
	}
	
	public void setPD(String PD) {
		String[] re=PD.split("-");
		this.PD_yy=Integer.parseInt(re[0]);
		this.PD_mm=Integer.parseInt(re[1]);
		this.PD_dd=Integer.parseInt(re[2]);
	}
	//(int PD_yy, int PD_mm, int PD_dd){this.PD_yy=PD_yy; this.PD_mm=PD_mm; this.PD_dd=PD_dd;}
	
	public int getPD_yy() {
		return PD_yy;
	}

	public void setPD_yy(int pD_yy) {
		PD_yy = pD_yy;
	}

	public int getPD_mm() {
		return PD_mm;
	}

	public void setPD_mm(int pD_mm) {
		PD_mm = pD_mm;
	}

	public int getPD_dd() {
		return PD_dd;
	}

	public void setPD_dd(int pD_dd) {
		PD_dd = pD_dd;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public double getSpeed_currency() {
		return speed_currency;
	}

	public void setSpeed_currency(double speed_currency) {
		this.speed_currency = speed_currency;
	}

	public double getSpeed_limite() {
		return speed_limite;
	}

	public void setSpeed_limite(double speed_limite) {
		this.speed_limite = speed_limite;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLoad_currency() {
		return load_currency;
	}

	public void setLoad_currency(double load_currency) {
		this.load_currency = load_currency;
	}

	public double getLoad_limite() {
		return load_limite;
	}

	public void setLoad_limite(double load_limite) {
		this.load_limite = load_limite;
	}

	public double getOil_currency() {
		return oil_currency;
	}

	public void setOil_currency(double oil_currency) {
		this.oil_currency = oil_currency;
	}

	public double getOil_limite() {
		return oil_limite;
	}

	public void setOil_limite(double oil_limite) {
		this.oil_limite = oil_limite;
	}

	public double getOil_ave_use() {
		return oil_ave_use;
	}

	public void setOil_ave_use(double oil_ave_use) {
		this.oil_ave_use = oil_ave_use;
	}

	public double getVehicle_kilometer() {
		return vehicle_kilometer;
	}

	public void setVehicle_kilometer(double vehicle_kilometer) {
		this.vehicle_kilometer = vehicle_kilometer;
	}

	public double getCar_coefficient() {
		return car_coefficient;
	}

	public void setCar_coefficient(double car_coefficient) {
		this.car_coefficient = car_coefficient;
	}
	
	public static boolean iflegalNumber_plate(String str) {
		return Pattern.matches("^[\u4e00-\u9fa5][A-Z][0-9]{5}$", str);
		//翼E48920
	}
	
	public static boolean iflegalCar_type(String str) {
		return Pattern.matches("^(小型|中型|大型)(汽车|轿车|货车)$", str);
		//小型轿车
	}
	
	public static boolean iflegalPerson(String str) {
		return Pattern.matches("^\\S+$", str);
		//武绍波
	}
	
	public static boolean iflegalAddress(String str) {
		return Pattern.matches("^\\S+$", str);
		//河北省邢台市平乡县平乡镇东同庄村113号
	}
	
	public static boolean iflegalEngine_number(String str) {
		return Pattern.matches("^[A-Z][0-9]{6,}$", str);
		//C375857
	}
	
	public static boolean iflegalCar_iden_id(String str) {
		return Pattern.matches("^[A-Z|0-9]{17}$", str);
		//LNGFE1351F1866000
	}
	
	public static boolean iflegalPD(String str) {
		return Pattern.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$", str);
		//2015-09-29
	}
	
	public static boolean iflegalOil_limite(String str) throws NumberFormatException {
		try {
			double value = Double.parseDouble(str);
			if (value>0 && value<=100)
				return true;
			else
				return false;			
		} catch(NumberFormatException e1) {
			throw new NumberFormatException("油箱总量");
		}
		//10
	}
	
	public static boolean iflegalWeight(String str) throws NumberFormatException {
		try {
			double value = Double.parseDouble(str);
			if (value>0 && value<=50)
				return true;
			else
				return false;			
		} catch(NumberFormatException e1) {
			throw new NumberFormatException("重量");
		}
		//1
	}
	
	public static boolean iflegalLoad_limite(String str) throws NumberFormatException {
		try {
			double value = Double.parseDouble(str);
			if (value>0 && value<=500)
				return true;
			else
				return false;		
		} catch(NumberFormatException e1) {
			throw new NumberFormatException("载重量");
		}
		//5
	}
	
	public static boolean iflegalImage_path(String str) {
		File f=new File(str);
		if (f.exists())
			return true;
		else
			return false;
	}
	
	public void getTable(ResultSet rs) throws SQLException {
		number_plate=rs.getString(1);
		car_type=rs.getString(2);
		person=rs.getString(3);
		address=rs.getString(4);
		engine_number=rs.getString(5);
		car_iden_id=rs.getString(6);
		PD_yy=rs.getInt(7);
		PD_mm=rs.getInt(8);
		PD_dd=rs.getInt(9);		
		image_path=rs.getString(10);
		speed_currency=rs.getDouble(11);
		speed_limite=rs.getDouble(12);
		weight=rs.getDouble(13);
		load_currency=rs.getDouble(14);
		load_limite=rs.getDouble(15);
		oil_currency=rs.getDouble(16);
		oil_limite=rs.getDouble(17);
		oil_ave_use=rs.getDouble(18);
		vehicle_kilometer=rs.getDouble(19);
		car_coefficient=rs.getDouble(20);
	}
	
	public String setTable() {
		String str="insert into CAR values('"+
			number_plate.trim()+"','"+car_type.trim()+"','"+person.trim()+"','"+
			address.trim()+"','"+engine_number.trim()+"','"+car_iden_id.trim()+"',"+
			Integer.toString(PD_yy).trim()+","+Integer.toString(PD_mm).trim()+","+Integer.toString(PD_dd).trim()+",'"+
			image_path.replace("\\","\\\\").trim()+"',"+Double.toString(speed_currency).trim()+","+Double.toString(speed_limite).trim()+","+
			Double.toString(weight).trim()+","+Double.toString(load_currency).trim()+","+Double.toString(load_limite).trim()+","+
			Double.toString(oil_currency).trim()+","+Double.toString(oil_limite).trim()+","+Double.toString(oil_ave_use).trim()+","+
			Double.toString(vehicle_kilometer).trim()+","+Double.toString(car_coefficient).trim()+",null)";
//		System.out.println(str);
		return str;
	}
	
	public boolean ifcorrect(String number_plate, String car_type, String person, String address,
		String engine_number, String car_iden_id, String PD, String oil_limite, 
		String weight, String load_limite, String image_path) {
		try {
			if (!iflegalNumber_plate(number_plate))
				throw new Exception("汽车号牌");
			if (!iflegalCar_type(car_type))
				throw new Exception("车辆类型");
			if (!iflegalPerson(person))
				throw new Exception("拥有者");
			if (!iflegalAddress(address))
				throw new Exception("住址");
			if (!iflegalEngine_number(engine_number))
				throw new Exception("发动机号码");
			if (!iflegalCar_iden_id(car_iden_id))
				throw new Exception("车辆识别号");
			if (!iflegalPD(PD))
				throw new Exception("生产日期");
			if (!iflegalOil_limite(oil_limite))
				throw new Exception("油箱容量");
			if (!iflegalWeight(weight))
				throw new Exception("重量");
			if (!iflegalLoad_limite(load_limite))
				throw new Exception("载重量");
			if (!iflegalImage_path(image_path))
				throw new FileNotFoundException();
			return true;
		}  catch(NumberFormatException e1) {
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
