
public class PPoint{
	final double tolerance=0.000000001;
	//x,y分别对应radius，angle(0~2*pi)
	private double x,y;
	PPoint(){x=0; y=0;}
	PPoint(double xx,double yy){x=xx; y=yy;}
	double getX(){return x;}
	double getY(){return y;}
	void setX(double xx){x=xx;}
	void setY(double yy){x=yy;}
	void set(double xx,double yy){x=xx; y=yy;}	
	boolean equals(PPoint point){
		if (x==point.x && y==point.y)
			return true;
		else
			return false;
	}
	//返回该对象的哈希码值。支持此方法是为了提高哈希表的性能。将该对象的内部地址转换成一个整数来实现的。
//	public int hashCode(){
//		return (&this);//
//	}
	public String toString(){
		return "( "+Double.toString(this.x)+" , "+Double.toString(this.y)+" )";
	}
	double distance(){
		return x;
	}
	double distance(PPoint point){
		return Math.sqrt(x*x+point.x*point.x-2*x*point.x*Math.cos(y-point.y));
	}
	RPoint ChangeIntoRPoint(){
		RPoint point=new RPoint(x*Math.cos(y/180.0*Math.PI),x*Math.sin(y/180.0*Math.PI));
		return point;
	}
	static String getDesigner(){
		return "设计者：陈冠斌  学号：320150938841 班级：计算机二班";
	}
}
