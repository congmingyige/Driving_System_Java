
abstract class aA {
	int x;
	aA() {
		x=0;
	}
	void print_x() {
		System.out.println(x);
		//System.out.println(this.x);
	}
}

class aB extends aA {
	aB() {
		x=1;
	}
	aC cre_aC() {
		return new aC();
	}
}

class aC extends aA {
	aC() {
		x=2;
	}
	aB cre_aB() {
		return new aB();
	}
}

class aD extends aA {
	int x;
	aD() {
		x=1;
	}
	aE cre_aE() {
		return new aE();
	}
}

class aE extends aA {
	int x;
	aE() {
		x=2;
	}
	aD cre_aD() {
		return new aD();
	}
}


public class test_two_abstract {
	public static void main(String[] args) {
		aB ab=new aB();
		aC ac=new aC();
		ab.print_x();	//class b
		ac.print_x();	//class c
		System.out.println();
		
		ab.cre_aC().print_x();	//class c
		ac.cre_aB().print_x();	//class b
		
		System.out.println("------");
		
		aD ad=new aD();			//class d	//先父类的构造方法，其次是子类的构造方法
		aE ae=new aE();			//class e
		ad.print_x();						//获得是父类的x，即使是用System.out.println(this.x);也输出的是父类的x
		ae.print_x();
		System.out.println();
		
		ad.cre_aE().print_x();	//class e
		ae.cre_aD().print_x();	//class d
	}
}
