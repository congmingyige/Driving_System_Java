
public class RPoint{
	private double x,y;
	RPoint(){x=0; y=0;}
	RPoint(double xx,double yy){x=xx; y=yy;}
	public double getX(){return x;}
	public double getY(){return y;}
	public void setX(double xx){x=xx;}
	public void setY(double yy){y=yy;}
	public void set(double xx,double yy){x=xx; y=yy;}
	boolean equals(RPoint point){
		if (x==point.x && y==point.y)
			return true;
		else
			return false;
	}
	//返回该对象的哈希码值。支持此方法是为了提高哈希表的性能。将该对象的内部地址转换成一个整数来实现的。
	public int hashCode(){
		return (&this);//
	}
	public String toString(){
		return "( "+Double.toString(x)+" , "+Double.toString(y)+" )\n";
	}
	public double distance(){
		return Math.sqrt(x*x+y*y);
	}
	double distance(RPoint point){
		return Math.sqrt((x-point.x)*(x-point.x)+(y-point.y)*(y-point.y));
	}
	PPoint ChangeIntoPPoint(){
		double r=Math.sqrt(x*x+y*y);
		if (r==0)
			return PPoint(0,0);
		double Angle=Math.acos(x/r);
		return PPoint(r,Angle);
	}
	public String getDesigner(){
		return "设计者：陈冠斌  学号：320150938841 班级：计算机二班\n";
	}
}

