
//write as much function as possible for the use of class

//�쳣����������ת����ʱ��,������Ƕ�Ӧ�����������Ӧ����

//car �� driver �����ϵ:ָ�룿 ���ݿ� һ�Զ�

//һЩTextField���޸�/�����޸�

//Driving_System ���ҳ�棬���������������޸�ҳ��ͨ���ź�����������Ϊ�����޸�

public class Driving_System {

	public static Car[] car=new Car[100];
	public static CarDriver[] driver=new CarDriver[100];
	public static int car_count=0;
	public static int driver_count=0;
	
	Driving_System() {
		//���ԣ�ע�Ͳ���ҳ��
		Main_Frame mf=new Main_Frame();
		//Driver_Verify_Frame dvf=new Driver_Verify_Frame();
		//Car_Verify_Frame cvf=new Car_Verify_Frame();
		//Driver_Frame df=new Driver_Frame();
		//Car_Frame cf=new Car_Frame();
		//Car_Condition_Frame ccf=new Car_Condition_Frame();
		getDesigner();
		
		//DisplayImage.show("D:\\Java\\Code\\homework_problems\\ͷ����Ƭ2.jpg");
	}
	
	public static String getDesigner(){
		return "����ߣ��¹ڱ�  ѧ�ţ�320150938841 �༶�����������";
	}
	
	void database() {
		//���泤��ʹ�ã���ʼ����ʱ�������ݴ����ݿ�ŵ���������׻�ȡ���ݣ��رճ���ʱ�������ݷŻص����ݿ⣬���ڱ���
		
		//database -> object -> show
		//		   -<				-<
	
	}
	
	public static void main(String[] args) {
		
		Driving_System ds=new Driving_System();
		
		
	}
}

//Bounds:x(from left to right),y(from top to bottom),width,height

/*
���ó�ʼֵ��
public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h,Font font) {}
public void JLabel_add(JLabel ln,JPanel pn,int x,int y,int w,int h) {
	this.JLabel_add(ln,pn,x,y,w,h,new Font("����",Font.PLAIN,25));
}
*/
