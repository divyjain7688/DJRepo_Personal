package javaCode;


class parent{
public void eat()
{
System.out.println("parent is eating");	
}
public void sleep()
{
System.out.println("parent is sleeping");	
}
}

class children extends parent{
	
	public void eat()
	{
	System.out.println("children is eating");	
	}
	public void dance()
	{
	System.out.println("children is dancing");	
	}
}


class grandchildren extends children{
	
	public void eat()
	{
	System.out.println("grandchildren is eating");	
	}
}

public class Overriding {
	
	public static void main(String args[])
	{
		parent p = new children();
		children c = new children();
		parent g = new grandchildren();
		children h = new grandchildren();
		
		p.eat();
		p.sleep();
	//	p.dance();
		c.eat();
		g.eat();
		h.dance();
		h.eat();
		
	}

}
/*
children is eating
parent is sleeping
children is eating
grandchildren is eating
children is dancing
grandchildren is eating

*/