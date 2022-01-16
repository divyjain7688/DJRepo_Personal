package JavaCode;
/*
class parent{
	int a = 10;
parent()
{
System.out.println("parent constructer called");
}
public void display()
{
System.out.println("parent display method");
}
public void methodinvoked()
{
System.out.println("parent method");	
}
}

class child extends parent {
	child()
	{  
		System.out.println("child constructor called");
	}
	int a=12;
	
	public void methodinvoked()
	{
	System.out.println("child method");	
	}
	public void display()
	{	System.out.println("child  " + a);
		System.out.println("parent   " + super.a);
		super.methodinvoked();
		methodinvoked();
	}
	
}
public class superprogram extends child {
	public static void main(String[] arg)
	{
		parent s = new superprogram();
	 
     	s.display();
		
	}
}
parent constructer called
child constructor called
child  12
parent   10
parent method
child method

*/




/*


package javalearning;
class parent{
	int rn;
	parent()
	{
		
	}
	parent(int rn)
	{
		this.rn=rn;
		
	}
	
}

class child extends parent{
	String name;
	child(int rn, String name)
	{
		super(rn);
		this.name=name;
	}
	
	
public void display()
	{
		System.out.println("name and rollnumber are" +  "  "  + name + "  "+ rn);
		
	}
	
}

public class superprogram{
	public static void main(String[] arg)
	{
		child c = new child(111, " Divy");
		c.display();
		
	}
}
name and rollnumber are   Divy  111

*/















/*

package javalearning;
class parent{
	public int rn;
	parent()
	{}
	parent(int rn)
	{
		this.rn=rn;
		
	}
	
}

class child extends parent{
	int age;
	child(int age)
	{
	//super(age);
	this.age=age;

	}
public void display()
	{
		System.out.println(" age and rollnumber are" +  "  "   +age+ "  "+ rn);
		
	}
	
}

public class superprogram{
	public static void main(String[] arg)
	{
		child c = new child(6);
		c.display();
		
	}
}
age and rollnumber are  6  0

 
*/










/*

package javalearning;
class parent{
	public int rn;

	parent(int rn)
	{
		//this.rn=rn;
		System.out.println("Parent: " + rn);
		
	}
	
}

class child extends parent{
	int age;
	child(int age)
	{
		super(age);
	this.age=age;
		System.out.println("Child: " + age);
	}

}

public class superprogram{
	public static void main(String[] arg)
	{
		child c = new child(6);
		
	}
}

Parent: 6
Child: 6

*/