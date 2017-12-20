
public abstract class Point {
	double tolerance=0.000000001;
	double x,y;
	public double getX(){return x;}
	public double getY(){return y;}
	public void setX(double xx){x=xx;}
	public void setY(double yy){y=yy;}
	public void set(double xx,double yy){x=xx; y=yy;}
	public abstract double distance() ;
	public String toString(){
		return "( "+Double.toString(x)+" , "+Double.toString(y)+" )";
	}
	//返回该对象的哈希码值。支持此方法是为了提高哈希表的性能。将该对象的内部地址转换成一个整数来实现的。
	public int hashCode() {
		return (int) (Double.doubleToLongBits(x) % 10007 + Double.doubleToLongBits(y) % 10007 * 10007);
	}
	public static String getDesigner(){
		return "设计者：陈冠斌  学号：320150938841 班级：计算机二班";
	}

	public static void main(String[] args){
		
			System.out.println("Test1:");
		RPoint RP1=new RPoint(1.0,1.0);
		System.out.println("RP1.x = "+RP1.getX());
		System.out.println("RP1.y = "+RP1.getY());
		System.out.println("RP1 = "+RP1.toString());
			System.out.println("");
		
			System.out.println("Test2:");
		RPoint RP2=new RPoint();
		System.out.println("RP2 = "+RP2.toString());
		RP2.set(2,3);
		System.out.println("RP2.x = "+RP2.getX());
		System.out.println("RP2.y = "+RP2.getY());
		RP2.setX(1);
		RP2.setY(2);
		System.out.println("RP2 = "+RP2.toString());
			System.out.println("");
		
			System.out.println("Test3:");
		System.out.println("RP1==RP2? : "+RP1.equals(RP2));
		System.out.println("RP1==RP1? : "+RP1.equals(RP1));
		
		System.out.println("The hashCode of RP1 is "+RP1.hashCode());
		System.out.println("The hashCode of RP2 is "+RP2.hashCode());
		
		System.out.printf("The distance of (%f,%f) to (0,0) is %f\n",RP1.getX(),RP1.getY(),RP1.distance());
		System.out.printf("The distance of (%f,%f) to (%f,%f) is %f\n",RP1.getX(),RP1.getY(),RP2.getX(),RP2.getY(),RP1.distance(RP2));
			System.out.println("");
		
		System.out.println("\n------\n");
		
			System.out.println("Test4:");
		PPoint P1=RP1.ChangeIntoPPoint();
		PPoint P2=RP2.ChangeIntoPPoint();
		System.out.println("P1 = "+P1.toString());
		System.out.println("P2 = "+P2.toString());
		
		System.out.println("RP1==RP1_change_change? : "+RP1.equals(P1.ChangeIntoRPoint()));
		System.out.println("RP2==RP2_change_change? : "+RP2.equals(P2.ChangeIntoRPoint()));
		
		System.out.println("P1==P2? :"+P1.equals(P2));
		System.out.println("P1==P1? :"+P1.equals(P1));
		
		System.out.println("The hashcode of P1 is "+P1.hashCode());
		System.out.println("The hashcode of P2 is "+P2.hashCode());
			System.out.println("");
		
			System.out.println("Test5:");
		System.out.printf("The distance of (%f,%f) to (0,0) is %f\n",P1.getX(),P1.getY(),P1.distance());
		System.out.printf("The distance of (%f,%f) to (%f,%f) is %f\n",P1.getX(),P1.getY(),P2.getX(),P2.getY(),P1.distance(P2));
			System.out.println("");
		
		System.out.println(Point.getDesigner());
	}
}