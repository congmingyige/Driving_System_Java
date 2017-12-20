


public class PPoint extends RPoint {
	//x,y分别对应r,Angle
	private double x,y;
	PPoint(){x=0; y=0;}
	PPoint(double xx,double yy){x=xx; y=yy;}
	boolean equals(PPoint point){
		if (x==point.x && y==point.y)
			return true;
		else
			return false;
	}
	double distance(PPoint point){
		return Math.sqrt((x-point.x)*(x-point.x)+(y-point.y)*(y-point.y));
	}
	PPoint ChangeIntoRPoint(){
		return RPoint(x*Math.cos(y),x*Math.sin(y));
	}	
}
