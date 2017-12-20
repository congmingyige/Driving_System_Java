
class RPoint extends Point{
	//x,y分别对应x轴的坐标，y轴的坐标
	
	RPoint(){x=0; y=0;}
	RPoint(double xx,double yy){x=xx; y=yy;}

	public boolean equals(RPoint point){
		if (Math.abs(x-point.x)<tolerance && Math.abs(y-point.y)<tolerance)
			return true;
		else
			return false;
	}
	public double distance(){
		return Math.sqrt(x*x+y*y);
	}
	public double distance(RPoint point){
		return Math.sqrt((x-point.x)*(x-point.x)+(y-point.y)*(y-point.y));
	}
	public PPoint ChangeIntoPPoint(){
		double r=Math.sqrt(x*x+y*y);
		if (r==0){
			return new PPoint(0,0);
		}
		double Angle=Math.acos(x/r)/Math.PI*180.0;
		return new PPoint(r,Angle);
	}
}
