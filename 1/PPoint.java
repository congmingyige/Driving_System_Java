
class PPoint extends Point {
	//x,y分别对应r,Angle(单位是度，360为一周期)
	
	PPoint(){x=0; y=0;}
	PPoint(double xx,double yy){x=xx; y=yy;}
	
	public boolean equals(PPoint point){
		if (Math.abs(x-point.x)<tolerance && Math.abs(y-point.y)<tolerance)
			return true;
		else
			return false;
	}
	public double distance(){
		return x;
	}
	public double distance(PPoint point){
		return Math.sqrt(x*x+point.x*point.x-2*x*point.x*Math.cos((y-point.y)/180.0*Math.PI));
	}
	public RPoint ChangeIntoRPoint(){
		return new RPoint(x*Math.cos(y/180.0*Math.PI),x*Math.sin(y/180.0*Math.PI));
	}
}
