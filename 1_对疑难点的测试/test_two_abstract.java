
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
		
		aD ad=new aD();			//class d	//�ȸ���Ĺ��췽�������������Ĺ��췽��
		aE ae=new aE();			//class e
		ad.print_x();						//����Ǹ����x����ʹ����System.out.println(this.x);Ҳ������Ǹ����x
		ae.print_x();
		System.out.println();
		
		ad.cre_aE().print_x();	//class e
		ae.cre_aD().print_x();	//class d
	}
}
