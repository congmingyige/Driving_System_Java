
import java.awt.Image;

class Car {
	//number_plate:unique
	private String number_plate,car_type,person,address,engine_number,car_iden_id;
	private int PD_yy,PD_mm,PD_dd;
	private String image_path;
	
	private double speed_currency,speed_limite;//mainly depends on car
	private double weight,load_currency,load_limite;
	private double oil_currency,oil_total,oil_ave_use=0.07;//default
	private double vehicle_kilometer,car_coefficient;
	//oil_ave_use = car_coefficient+0.005*load_currency+(speed_currency-60)*0.0001;
	Car() {
	}
	
	Car(String number_plate) {
		this.number_plate=number_plate;
	}
	Car(String number_plate, String car_type, String person,
		String address, String engine_number, String car_iden_id,
		int PD_yy, int PD_mm, int PD_dd,
		double speed_currency, double speed_limite,
		double weight, double load_currency, double load_limite,
		double oil_currency,double oil_total,double oil_ave_use, 
		double vehicle_kilometer, double car_coefficient, //车辆本身的属性，影响平均用油量
		String image_path
		) {
		
		this.number_plate=number_plate; this.car_type=car_type; this.person=person;
		this.address=address; this.engine_number=engine_number; this.car_iden_id=car_iden_id;
		this.PD_yy=PD_yy; this.PD_mm=PD_mm; this.PD_dd=PD_dd;
		this.speed_currency=speed_currency; this.speed_limite=speed_limite;
		this.weight=weight; this.load_currency=load_currency; this.load_limite=load_limite;
		this.oil_currency=oil_currency; this.oil_total=oil_total; this.oil_ave_use=oil_ave_use;
		this.vehicle_kilometer=vehicle_kilometer; this.car_coefficient=car_coefficient;
		this.image_path=image_path;
	}

	public int hashCode() {
		return number_plate.hashCode();
	}
	
	public boolean equals(Car c) {
		return number_plate==c.number_plate && car_type==c.car_type && person==c.person
			&& address==c.address && engine_number==c.engine_number && car_iden_id==c.car_iden_id
			&& PD_yy==c.PD_yy && PD_mm==c.PD_mm && PD_dd==c.PD_dd
			&& oil_currency==c.oil_currency && oil_total==c.oil_total
			&& weight==c.weight && load_limite==c.load_limite
			&& image_path==c.image_path && vehicle_kilometer==c.vehicle_kilometer ;
		//如何判断图片相同
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
		str = str + "speed_currency : " + this.getSpeed_currency() + "\n";
		str = str + "speed_limite : " + this.getSpeed_limite() + "\n";
		str = str + "weight : " + this.getWeight() + "\n";
		str = str + "load_currency : " + this.getLoad_currency() + "\n";
		str = str + "load_limite : " + this.getLoad_limite() + "\n";
		str = str + "oil_currency : " + this.getOil_currency() + "\n";
		str = str + "oil_total : " + this.getOil_total() + "\n";
		str = str + "oil_ave_use : " + this.getOil_ave_use() + "\n";
		str = str + "vehicle_kilometer : " + this.getVehicle_kilometer() + "\n";
		str = str + "car_coefficient : " + this.getCar_coefficient() + "\n";
		str = str + "image_path : " + this.getImage_path() + "\n";
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
		return Integer.toString(PD_yy)+"-"+Integer.toString(PD_mm)+"-"+Integer.toString(PD_dd);
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

	public double getOil_total() {
		return oil_total;
	}

	public void setOil_total(double oil_total) {
		this.oil_total = oil_total;
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

	public void speed_up(double speed_modify) throws Exception {
		if (speed_currency+speed_modify>speed_limite || speed_modify<=0)
			throw new Exception("错误的速度");
		speed_currency+=speed_modify;
		//oil_ave_use=car_coefficient+0.005*load_currency+(speed_currency-60)*0.0001;
		oil_ave_use=oil_ave_use+0.0001*speed_modify;
	}
	public void speed_down(double speed_modify) throws Exception {
		if (speed_currency-speed_modify<0 || speed_modify<=0)
			throw new Exception("错误的速度");
		speed_currency-=speed_modify;
		//oil_ave_use=car_coefficient+0.005*load_currency+(speed_currency-60)*0.0001;
		oil_ave_use=oil_ave_use-0.0001*speed_modify;
	}
	
	public void load_up(double load_modify) throws Exception {
		//System.out.println();
		if (load_currency+load_modify>load_limite || load_modify<=0)
			throw new Exception("错误的负重");
		load_currency+=load_modify;
		//oil_ave_use=car_coefficient+0.005*load_currency+(speed_currency-60)*0.0001;
		oil_ave_use=oil_ave_use+0.005*load_modify;
	}
	public void load_down(double load_modify) throws Exception {
		if (load_currency-load_modify<0 || load_modify<=0)
			throw new Exception("错误的负重");
		load_currency-=load_modify;
		//oil_ave_use=car_coefficient+0.005*load_currency+(speed_currency-60)*0.0001;
		oil_ave_use=oil_ave_use-0.005*load_modify;
	}

	public void oil_up(double oil_modify) throws Exception {
		if (oil_total+oil_modify>oil_currency || oil_modify<=0)
			throw new Exception("错误的油量");
		oil_total+=oil_modify;
	}
	public void oil_down(double mile_add) throws Exception {
		double oil_modify=mile_add*oil_ave_use;
		if (oil_total+oil_modify>oil_currency || oil_modify<=0)
			throw new Exception("错误的油量");
		oil_total-=oil_modify;
		vehicle_kilometer+=mile_add;
	}
	public double runmile_guess() {
		return oil_currency*oil_ave_use;
	}
	
	public boolean ifCorrect() {
		return true;
	}
	
	//public boolean judge_xxx
	
	public void DataFromDatabse() {
		
	}
	
	public void DataToDatabase() {
		
	}
}
