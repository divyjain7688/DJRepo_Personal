package javaCode;

abstract class ParentClass {
	// can not create object of abstract class - ParentClass p new ParentClass();
	
	public void run() {
		System.out.println("ParentClass is running");
	}
	abstract void sleep();
	String color;
	ParentClass()
	{
		System.out.println("ParentClass constructer");
		color = "red";
	}
}
class AbstractClass extends ParentClass{
	String color="pink";
	void sleep()
	{
		System.out.println("AbstractClass is sleeping");	
	}
	public void run() {
		System.out.println("AbstractClass is running");
	}
	public static void main(String arg[])
	{
		ParentClass A = new AbstractClass();
		System.out.println(A.color);
		A.sleep();
		A.run();
	}


}
/*
ParentClass constructer
red
AbstractClass is sleeping
AbstractClass is running
 */