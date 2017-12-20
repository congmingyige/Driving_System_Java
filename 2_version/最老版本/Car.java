
import java.awt.Image;

class Car {
	//number_plate:unique
	private String number_plate,car_type,person,address,engine_number,car_iden_id;
	private int PD_yy,PD_mm,PD_dd;
	private String image_path;
	
	private double speed_currency=0,speed_limite;//mainly depends on car
	private double weight,load_currency,load_limite;
	private double oil_currency,oil_total,oil_ave_use=0.07;//default
	private double vehicle_kilometer=0;
	private int car_condition=0; //0:stop 1:run

	public void speed_up(double speed_modify) throws Exception {
		if (speed_currency+speed_modify>speed_limite || speed_modify<=0)
			throw new Exception("错误的速度");
		speed_currency+=speed_modify;
		//modify oil_ave_use
	}
	public void speed_down(double speed_modify) throws Exception {
		if (speed_currency-speed_modify<0 || speed_modify<=0)
			throw new Exception("错误的速度");
		speed_currency-=speed_modify;
		//modify oil_ave_use
	}
	
	public void load_up(double load_modify) throws Exception {
		if (load_currency+load_modify>load_limite || load_modify<=0)
			throw new Exception("错误的负重");
		load_currency+=load_modify;
		//modify oil_ave_use
	}
	public void load_down(double load_modify) throws Exception {
		if (load_currency-load_modify<0 || load_modify<=0)
			throw new Exception("错误的负重");
		load_currency-=load_modify;
		//modify oil_ave_use
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
	
	Car() {
		number_plate="NULL";
	}
	Car(String number_plate) {
		this.number_plate=number_plate;
	}
	Car(String number_plate, String car_type, String person,
		String address, String engine_number, String car_iden_id,
		int PD_yy, int PD_mm, int PD_dd,
		double oil_currency, double oil_total, double weight, double load_limite,
		Image image, double vehicle_kilometer) {
		
		this.number_plate=number_plate; this.car_type=car_type; this.person=person;
		this.address=address; this.engine_number=engine_number; this.car_iden_id=car_iden_id;
		this.PD_yy=PD_yy; this.PD_mm=PD_mm; this.PD_dd=PD_dd;
		this.oil_currency=oil_currency; this.oil_total=oil_total;
		this.weight=weight; this.load_limite=load_limite;
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
	}
	
	public String toString() {
		String str="";
		str = str + "number_plate : " + this.get_number_plate() + "\n";
		str = str + "car_type : " + this.get_car_type() + "\n";
		str = str + "person : " + this.get_person() + "\n";
		str = str + "address : " + this.get_address() + "\n";
		str = str + "engine_number : " + this.get_engine_number() + "\n";
		str = str + "car_iden_id : " + this.get_car_iden_id() + "\n";
		str = str + "PD : " + this.get_PD() + "\n";
		str = str + "oil_currency : " + this.get_oil_currency() + "\n";
		str = str + "image : " + this.get_image_path() + "\n";
		str = str + "oil_total : " + this.get_oil_total() + "\n";
		str = str + "oil_total : " + this.get_oil_total() + "\n";
		str = str + "weight : " + this.get_weight() + "\n";
		str = str + "load_limite : " + this.get_load_limite() + "\n";
		str = str + "image : " + this.get_image_path() + "\n";
		str = str + "vehicle_kilometer : " + this.get_vehicle_kilometer() + "\n";
		return str;
	}
	
	public String get_number_plate(){return number_plate;}
	public String get_car_type(){return car_type;}
	public String get_person(){return person;}
	public String get_address(){return address;}
	public String get_engine_number(){return engine_number;}
	public String get_car_iden_id(){return car_iden_id;}
	
	public String get_PD(){return Integer.toString(PD_yy)+"-"+Integer.toString(PD_mm)+"-"+Integer.toString(PD_dd);}
	public int get_PD_yy(){return PD_yy;}
	public int get_PD_mm(){return PD_mm;}
	public int get_PD_dd(){return PD_dd;}
	
	public double get_speed_currency(){return speed_currency;}
	public double get_speed_limite(){return speed_limite;}
	
	public double get_weight(){return weight;}
	public double get_load_currency(){return load_currency;}
	public double get_load_limite(){return load_limite;}
	
	public double get_oil_currency(){return oil_currency;}
	public double get_oil_total(){return oil_total;}
	public double get_oil_ave_use(){return oil_ave_use;}
	
	public double get_vehicle_kilometer(){return vehicle_kilometer;}
	public int get_car_condition(){return car_condition;}

	public String get_image_path(){return image_path;}

	/////////////////////////////////////////////////////////////////////////////////////
	
	public void set_number_plate(String number_plate){this.number_plate=number_plate;}
	public void set_car_type(String car_type){this.car_type=car_type;}
	public void set_person(String person){this.person=person;}
	public void set_address(String address){this.address=address;}
	public void set_engine_number(String engine_number){this.engine_number=engine_number;}
	public void set_car_iden_id(String car_iden_id){this.car_iden_id=car_iden_id;}
	
	public void set_PD(String PD) {
		String[] re=PD.split("-");
		this.PD_yy=Integer.parseInt(re[0]);
		this.PD_mm=Integer.parseInt(re[1]);
		this.PD_dd=Integer.parseInt(re[2]);
	}
	//(int PD_yy, int PD_mm, int PD_dd){this.PD_yy=PD_yy; this.PD_mm=PD_mm; this.PD_dd=PD_dd;}
	public void set_PD_yy(int PD_yy){this.PD_yy=PD_yy;}
	public void set_PD_mm(int PD_mm){this.PD_mm=PD_mm;}
	public void set_PD_dd(int PD_dd){this.PD_dd=PD_dd;}
	

	public void set_speed_currency(double speed_currency){this.speed_currency=speed_currency;}
	public void set_speed_limite(double speed_limite){this.speed_limite=speed_limite;}
	
	public void set_weight(double weight){this.weight=weight;}
	public void set_load_currency(double load_currency){this.load_currency=load_currency;}
	public void set_load_limite(double load_limite){this.load_limite=load_limite;}
	
	public void set_oil_currency(double oil_currency){this.oil_currency=oil_currency;}
	public void set_oil_total(double oil_total){this.oil_total=oil_total;}
	public void set_oil_ave_use(double oil_ave_use){this.oil_ave_use=oil_ave_use;}
	
	public void set_vehicle_kilometer(double vehicle_kilometer){this.vehicle_kilometer=vehicle_kilometer;}
	public void set_car_condition(int car_condition){this.car_condition=car_condition;}
	
	public void set_image_path(String image_path){this.image_path=image_path;}
	
	public boolean ifCorrect() {
		return true;
	}
	
}
