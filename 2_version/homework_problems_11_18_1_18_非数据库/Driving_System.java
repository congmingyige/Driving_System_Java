
//�����ܷ񴴽��ɹ��󣬲�ѯ���Կ���֮ǰ����������

//car �� driver �����ϵ:ָ�룿 ���ݿ� һ�Զ�

//ͼƬ��ѡ���ַ����   ͼƬ�Ķ���޸�(��Ҫһֱ�����¶���)    ��ͼƬ����·��
//Driver Car �Ƿ���֮ǰ��ͬ(����������)

public class Driving_System {

	public static Car[] car=new Car[100];
	public static CarDriver[] driver=new CarDriver[100];
	public static int car_count=0;
	public static int driver_count=0;
	
	Driving_System() {
		
//		driver_count=1;
//		car_count=1;
//		driver[1]=new CarDriver("","","",0,0,0,"",0,0,0,0,0,0,0,"","");
//		car[1]=new Car("","","","","","",0,0,0,"",0,0,0,0,0,0,0,0,0,0);
		
		//���ԣ�ע�Ͳ���ҳ��
		Main_Frame mf=new Main_Frame();
		//Driver_Verify_Frame dvf=new Driver_Verify_Frame();
		//Car_Verify_Frame cvf=new Car_Verify_Frame();
		//Driver_Frame df=new Driver_Frame();
		//Car_Frame cf=new Car_Frame();
		//Car_Condition_Frame ccf=new Car_Condition_Frame();
		System.out.println(Driving_System.getDesigner());
				
		//DisplayImage.show("D:\\Java\\Code\\homework_problems\\ͷ����Ƭ2.jpg");
	}
	
	public static String getDesigner(){
		return "����ߣ��¹ڱ�  ѧ�ţ�320150938841 �༶�����������";
	}
	
	public static void main(String[] args) {
		
		Driving_System ds=new Driving_System();
		
	}
	
}

/*
 * 	�����ݿⱣ�����ݣ��״�źͻ�ȡ
 *  ��ʻϵͳ����ʱ�����пɻ�ȡ���ݷ���Driving_System������
 *  ��ҳ�棬�����Ķ���(Driver Car)���ݷ���Frame������ : ����ʱ�̵�һ�޸ģ��ź������ƽ��(semaphore)
 * 			Driving_System_Begin:database->Driving_System
 * 			Driving_System_End:Driving_System->database
 * 
 * 			Frame_Begin:Driving_System->Frame
 * 			Frame_End:Frame->Driving_System
 * 	database -> object(Driving_System) -> object(Driver_Frame Car_Frame Car_Condition_Frame)	
 *  		   -<				-<
 *  
 */

/*
 * setBounds : x(from left to right),y(from top to bottom),width,height 
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
 *  
 */
