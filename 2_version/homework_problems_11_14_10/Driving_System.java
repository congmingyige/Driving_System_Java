
//write as much function as possible for the use of class

//异常处理：作类型转换的时候,如果不是对应类型则进行相应处理

//car 和 driver 类的联系:指针？ 数据库 一对多

//一些TextField可修改/不可修改

//Driving_System 多个页面，并发处理，创建和修改页面通过信号量机制设置为不可修改

public class Driving_System {

	public static Car[] car=new Car[100];
	public static CarDriver[] driver=new CarDriver[100];
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
		
		//DisplayImage.show("D:\\Java\\Code\\homework_problems\\头像照片2.jpg");
	}
	
	public static String getDesigner(){
		return "设计者：陈冠斌  学号：320150938841 班级：计算机二班";
	}
	
	void database() {
		//界面长期使用，开始程序时，把数据从数据库放到对象里，容易获取数据；关闭程序时，把数据放回到数据库，用于保存
		
		//database -> object -> show
		//		   -<				-<
	
	}
	
	public static void main(String[] args) {
		
		Driving_System ds=new Driving_System();
		
		
	}
}

//Bounds:x(from left to right),y(from top to bottom),width,height

/*
设置初始值：
public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h,Font font) {}
public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h) {
	this.JLabel_add(ln,pn,x,y,w,h,new Font("楷体",Font.PLAIN,25));
}
*/
