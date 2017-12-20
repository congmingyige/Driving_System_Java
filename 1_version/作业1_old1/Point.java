
public class Point{
	public static void main(String[] args){
		
		RPoint RP1=new RPoint(1.0,1.0);
		System.out.println("RP1.x = "+RP1.getX());
		System.out.println("RP1.y = "+RP1.getY());
		System.out.println("RP1 = "+RP1.toString());
		
		RPoint RP2=new RPoint();
		System.out.println("RP2 = "+RP2.toString());
		RP2.set(2,3);
		System.out.println("RP2 = "+RP2.toString());
		RP2.setX(1);
		RP2.setY(2);
		System.out.println("RP2 = "+RP2.toString());
		
		System.out.println("RP1==RP2? :"+RP1.equals(RP2));
		System.out.println("RP1==RP1? :"+RP1.equals(RP1));
		
		System.out.println("The hashcode of RP1 is "+RP1.hashCode());
		System.out.println("The hashcode of RP2 is "+RP2.hashCode());
		
		System.out.printf("The distance of (%f,%f) to (0,0) is %f\n",RP1.getX(),RP1.getY(),RP1.distance());
		System.out.printf("The distance of (%f,%f) to (%f,%f) is %f\n",RP1.getX(),RP1.getY(),RP2.getX(),RP2.getY(),RP1.distance(RP2));
		
		
		System.out.println();
		
		
		PPoint P1=new PPoint(2.0,Math.PI/3);
		System.out.println("P1.x = "+P1.getX());
		System.out.println("P1.y = "+P1.getY());
		System.out.println("P1 = "+P1.toString());
		
		PPoint P2=new PPoint();
		System.out.println("P2 = "+P2.toString());
		P2.set(3.0,Math.PI/4);
		System.out.println("P2 = "+P2.toString());
		P2.setX(2.0);
		P2.setY(0);
		System.out.println("P2 = "+P2.toString());
		
		System.out.println("P1==P2? :"+P1.equals(P2));
		System.out.println("P1==P1? :"+P1.equals(P1));
		
		System.out.println("The hashcode of RP1 is "+P1.hashCode());
		System.out.println("The hashcode of RP2 is "+P2.hashCode());
		
		System.out.printf("The distance of (%f,%f) to (0,0) is %f\n",P1.getX(),P1.getY(),P1.distance());
		System.out.printf("The distance of (%f,%f) to (%f,%f) is %f\n",P1.getX(),P1.getY(),P2.getX(),P2.getY(),P1.distance(P2));
		
		
		System.out.println();
		
		
		PPoint P1_transform=RP1.ChangeIntoPPoint();
		PPoint P2_transform=RP2.ChangeIntoPPoint();
		System.out.println("P1 = "+P1.toString());
		System.out.println("P2 = "+P2.toString());
		
		System.out.println("RP1==RP1_transform? :"+RP1.equals(P1_transform.ChangeIntoRPoint()));
		System.out.println("RP2==RP2_transform? :"+RP2.equals(P2_transform.ChangeIntoRPoint()));
		System.out.println("RP1==RP2_transform? :"+RP1.equals(P2_transform.ChangeIntoRPoint()));
				
		System.out.println(RPoint.getDesigner());
//		System.out.println(PPoint.getDesigner());
	}
}
