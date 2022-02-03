package javaCode;
/*package javalearning;


class parent{
	
	public void display()
	{
		System.out.println("parent");
		
	}
}

class child extends parent {
	public void display()
	{
		System.out.println("child");
	}
	
}
public class methodoverridingprogram {
	public static void main(String[] arg)
	{
		child c = new child();
		c.display();
	}
}
child*/







/*package javalearning;


class parent{
	
	public void display()
	{
		System.out.println("parent");
		
	}
}

class child1 extends parent {
	public void display()
	{
		System.out.println("child1");
	}
	
}

class child2 extends parent {
	public void display()
	{
		System.out.println("child2");
	}
	
}


public class methodoverridingprogram {
	public static void main(String[] arg)
	{
		child1 c1 = new child1();
		c1.display();
		child2 c2 = new child2();
		c2.display();
	}
}

child1
child2*/









/*package javalearning;


class parent{
	
	public void display()
	{
		System.out.println("parent");
		
	}
}

class child1 extends parent {
	public void display()
	{
		System.out.println("child1");
	}
	
}

class child2 extends parent {
	public void display()
	{
		System.out.println("child2");
	}
	
}


public class methodoverridingprogram {
	public static void main(String[] arg)
	{
		parent c1 = new child1();
		c1.display();
		parent c2 = new child2();
		c2.display();
	}
}
child1
child2*/















/*package javalearning;


class parent{
	
	public void display()
	{
		System.out.println("parent");
		
	}
}

class child1 extends parent {
	public void display()
	{
		System.out.println("child1");
	}
	
}

class child2 extends child1 {
	public void display()
	{
		System.out.println("child2");
	}
	
}


public class methodoverridingprogram {
	public static void main(String[] arg)
	{
		parent c1 = new child1();
		c1.display();
		child1 c2 = new child2();
		c2.display();
		parent c3 = new child2();
		c3.display();
	}
}*/













/*class parent{
	public void display()
	{
		System.out.println("parent");		
	}
}

class child1 extends parent {
	public void display()
	{
		System.out.println("child1");
	}	
}

class methodoverridingprogram extends child1 {
	
	public static void main(String[] arg)
	{
		parent c1 = new child1();
		c1.display();
		child1 c2 = new methodoverridingprogram();
		c2.display();
		parent c3 = new methodoverridingprogram();
		c3.display();
	
}
}

child1
child1
child1*/















/*package javalearning;
class parent{	
int a=10;
}
class child1 extends parent {
int a=11;
}
class child2 extends child1 {
	int a =12;
}
public class methodoverridingprogram {
	public static void main(String[] arg)
	{
		parent p = new child1();
	System.out.println(p.a);
		parent p1 = new child2();
		System.out.println(p1.a);
	
	}
}

10
10
*/



/*
package javalearning;
class parent{	
	void run()
	{
		System.out.println("parent running");
	}
	void earn()
	{
	System.out.println("parent is earning");
		
	}
}
class child extends parent {
	void earn()
	{
	System.out.println("child is earning");
		
	}
	void run()
	{
		System.out.println("child running");
	}
}

public class methodoverridingprogram {
	public static void main(String[] arg)
	{
		parent p = new child();
	p.earn();

	
	}
}
child is earning

*/



