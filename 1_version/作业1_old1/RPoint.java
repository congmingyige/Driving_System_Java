
public class RPoint{
	final double tolerance=0.000000001;
	private double x,y;
	public RPoint(){x=0; y=0;}
	public RPoint(double xx,double yy){x=xx; y=yy;}
	public double getX(){return x;}
	public double getY(){return y;}
	public void setX(double xx){x=xx;}
	public void setY(double yy){y=yy;}
	public void set(double xx,double yy){x=xx; y=yy;}
	boolean equals(RPoint point){
		if (Math.abs(x-point.x)<tolerance && Math.abs(y-point.y)<tolerance)
			return true;
		else
			return false;
	}
	//���ظö���Ĺ�ϣ��ֵ��֧�ִ˷�����Ϊ����߹�ϣ������ܡ����ö�����ڲ���ַת����һ��������ʵ�ֵġ�
//		public int hashCode(){
//			return (&this);//
//		}
	public String toString(){
		return "( "+Double.toString(this.x)+" , "+Double.toString(this.y)+" )";
	}
	double distance(){
		return Math.sqrt(x*x+y*y);
	}
	double distance(RPoint point){
		return Math.sqrt((x-point.x)*(x-point.x)+(y-point.y)*(y-point.y));
	}
	PPoint ChangeIntoPPoint(){
		double r=Math.sqrt(x*x+y*y);
		if (r==0){
			PPoint point=new PPoint(0,0);
			return point;
		}
		double Angle=Math.acos(x/r)/Math.PI*180.0;
		PPoint point=new PPoint(r,Angle);
		return point;
	}
	public static String getDesigner(){
		return "����ߣ��¹ڱ�  ѧ�ţ�320150938841 �༶�����������";
	}
}
