package javaCode;

public class Child extends Parent{
//	super("dj");
	int c=10;
//	Child()
//	{
//		System.out.println("default child cons");
//	}

	
	public static void main(String arg[])
	{
		Parent p = new Child();
		p.p1();
	//	p.p2(); violation of method overriding
		 System.out.println(p.c);
		 
		 Child c = new Child();
		 c.p3();
	}
	
	public void p1()
	{
		System.out.println("p1 child is called");
	}
	
	public void p2()
	{
		System.out.println("p1 is called");
	}

}
