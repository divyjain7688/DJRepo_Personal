package javaCode;

public class Parent {
	int c=12;
	Parent()
	{
		System.out.println("Default parent cons");
	}
	Parent(String s)
	{
		System.out.println("param parent cons " + s);
	}

	public void p1()
	{
		System.out.println("p1 parent is called");
	}

	public void p3()
	{
		System.out.println("p3 parent is called");
	}
}
