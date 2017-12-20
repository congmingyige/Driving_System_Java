
//car 和 driver 类的联系:指针？ 数据库 一对多

public class Driving_System {

	public static Car[] car=new Car[100];
	public static Driver[] driver=new Driver[100];
	public static int car_count=0;
	public static int driver_count=0;
	
	Driving_System() {
		//测试：注释部分页面
		Main_Frame mf=new Main_Frame();
		//Driver_Verify_Frame dvf=new Driver_Verify_Frame();
		//Car_Verify_Frame cvf=new Car_Verify_Frame();
		//Driver_Frame df=new Driver_Frame();
		//Car_Frame cf=new Car_Frame();
		//Car_Condition_Frame ccf=new Car_Condition_Frame();
		getDesigner();
		
		driver_count=1;
		car_count=1;
		Driver driver1=new Driver("","");
		Car car1=new Car("","");
		driver[1]=driver1;
		car[1]=car1;
		
		//DisplayImage.show("D:\\Java\\Code\\homework_problems\\头像照片2.jpg");
	}
	
	public static String getDesigner(){
		return "设计者：陈冠斌  学号：320150938841 班级：计算机二班";
	}
	
	/*
	 * 	用数据库保存数据：易存放和获取
	 *  驾驶系统运行时，所有可获取数据放在Driving_System对象中
	 *  打开页面，创建的对象(Driver Car)数据放在Frame对象中 : 任意时刻单一修改，信号量机制解决(semaphore)
	 * 			Driving_System_Begin:database->Driving_System
	 * 			Driving_System_End:Driving_System->database
	 * 
	 * 			Frame_Begin:Driving_System->Frame
	 * 			Frame_End:Frame->Driving_System
	 * 	database -> object(Driving_System) -> object(Driver_Frame Car_Frame Car_Condition_Frame)	
	 *  		   -<				-<
	 *  
	 */
	
	public void getDatabaseData() {
		
	}
	
	public void setDatabaseData() {
		
	}
	
	public static void main(String[] args) {
		
		Driving_System ds=new Driving_System();
		
		
	}
}

/*
 * Bounds:x(from left to right),y(from top to bottom),width,height 
 */

/*
 *  attention:
 *  1.write as much function as possible for further using
 *  2.naming should be standardized
 *  3.Ctrl+F Ctrl+Enter : find and modify
 *  
 */

/*
 *  test:
 *  1.test one frame : note("//") other frame code
 *  2.in car_condition frame, see if each double variable could use properly
 *  3.
 */
