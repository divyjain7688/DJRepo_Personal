package javaCode;

public class Child extends Parent{
	//super("dj");
	int c=10;
//	Child(String c)
//	{
//		System.out.println("child param cons");
//	}
	Child()
	{
		System.out.println("default child cons");
	}
	
	public static void main(String arg[])
	{
		Parent p = new Child();
		p.p1();
		p.p3();
	//	p.p2(); violation of method overriding
		 System.out.println(p.c);
		 
		 Child c = new Child();
		 c.p2();//only present in child hence called from c
		 c.p3();
		 c.p1();
	}
	
	public void p1()
	{
		System.out.println("p1 child is called");
	}
	
	public void p2()
	{
		System.out.println("p2 child is called");
	}

}
