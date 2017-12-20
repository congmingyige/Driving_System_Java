
class tA {
	int x;
	tA() {
		x=0;
	}
	tB cre_tB() {
		return new tB();
	}
	tC cre_tC() {
		return new tC();
	}
	tD cre_tD() {
		return new tD();
	}
	
	int getx() {
		return x;
	}
}

class tB extends tA {
	int x;
	tB() {
		x=1;
	}
	tA cre_tA() {
		return new tA();
	}
	tC cre_tC() {
		return new tC();
	}
	int getx_this() {
		return this.x;
	}
}

class tC extends tA {
	int x;
	tC() {
		x=2;
	}
	tA cre_tA() {
		return new tA();
	}
	tB cre_tB() {
		return new tB();
	}
	int getx_this() {
		return this.x;
	}
}

class tD {
	int x;
	tD() {
		x=4;
	}
	tA cre_tA() {
		return new tA();
	}
	int getx() {
		return x;
	}
}

class tE {
	int x;
	tE() {
		x=5;
	}
	tF cre_tF() {
		return new tF();
	}
	tG cre_tG() {
		return new tG();
	}
	int getx() {
		return x;
	}
}

class tF extends tE {
	tF() {
		x=6;
	}
	tE cre_tE() {
		return new tE();
	}
	tG cre_tG() {
		return new tG();
	}
}

class tG extends tE {
	tG() {
		x=7;
	}
	tE cre_tE() {
		return new tE();
	}
	tF cre_tF() {
		return new tF();
	}
}


public class test_two_extends {
	public static void main(String[] args) {
		tA a = new tA();
		tB b = new tB();
		//tC c = new tC();
		tD d = new tD();
		
		//extends : all visit 父类的构造函数 ， 子类获得两个x数值，属于显性的是父类的值。如果要获得子类的值要用this.x。
		System.out.println("a - > b : " + a.cre_tB().getx());	//father - > son
		System.out.println("a - > b : (this) " + a.cre_tB().getx_this()); 		
		System.out.println("b - > a : " + b.cre_tA().getx());	//son -> father
		System.out.println("b - > c : " + b.cre_tC().getx());	//son1 -> sun2
		System.out.println("b - > c : (this) " + b.cre_tC().getx_this());
		
		System.out.println("a - > d : " + a.cre_tD().getx());
		System.out.println("d - > a : " + d.cre_tA().getx());	//no relation
		
		System.out.println("\n------\n");
		
		//子类没有父类的变量：正常输出
		tE e = new tE();
		tF f = new tF();
		tG g = new tG();
		System.out.println("e - > f : " + e.cre_tF().getx());	//father - > son		
		System.out.println("f - > e : " + f.cre_tE().getx());	//son -> father
		System.out.println("f - > g : " + f.cre_tG().getx());	//son1 -> sun2
	}
}
