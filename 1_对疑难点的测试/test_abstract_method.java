
abstract class aaaaa {
	int x=10;
	public void pr() {
		System.out.println(x);
	}
	abstract void work();
}

class bbbbb extends aaaaa {
	void work()
	{
		x=100;
	}
}

class ccccc {
	int x=10;
	public void pr() {
		System.out.println(x);
	}
	//void work() ;
}

class ddddd extends ccccc{
}

public class test_abstract_method {
	public static void main(String[] args) {
		//abstract : 子类可以使用父类除了abstract之外的方法
		bbbbb b=new bbbbb();		
		b.pr();

		ddddd d=new ddddd();
		d.pr();
	}	
}
