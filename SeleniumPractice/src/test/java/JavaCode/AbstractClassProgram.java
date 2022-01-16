package JavaCode;


/*abstract class parent{
parent()
{
	System.out.println("parent constructor");
	
}
void run()
{
System.out.println("parents are running");	
}

abstract void dance();

}



class child extends parent{
	child()
	{
		System.out.println("child constructor");
	}
	void dance()
	{
		System.out.println("child is dancing");
	}
	
}

public class AbstractClassProgram {
	public static void main(String[] arg)
	{
		parent p = new child();
		p.dance();
		p.run();
		
	}

}
parent constructor
child constructor
child is dancing
parents are running*/








/*abstract class parent{
parent()
{
	System.out.println("parent constructor");
	
}
void run()
{
System.out.println("parents are running");	
}

abstract void dance();

}



abstract class child extends parent{
	child()
	{
		System.out.println("child constructor");
	}
//	abstract void dance();
	
	
}



class baby extends child{
	baby()
	{
		System.out.println("baby constructor");
	}
	void dance()
	{
	System.out.println("baby is dancing");	
	}
}

public class AbstractClassProgram {
	public static void main(String[] arg)
	{
		parent p = new baby();
		p.dance();
		p.run();
		
	}

}
parent constructor
child constructor
baby constructor
baby is dancing
parents are running*/












/*package javalearning;


abstract class parent{
parent()
{
	System.out.println("parent constructor");
	
}
void run()
{
System.out.println("parents are running");	
}

abstract void dance();

}



class child extends parent{
	child()
	{
		System.out.println("child constructor");
	}

	
}

public class AbstractClassProgram {
	public static void main(String[] arg)
	{
		parent p = new child();
		p.dance();
		p.run();
		
	}

}

parent constructor
child constructor
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The type child must implement the inherited abstract method parent.dance()

	at javalearning.child.dance(AbstractClassProgram.java:92)
	at javalearning.AbstractClassProgram.main(AbstractClassProgram.java:105)
*/
























/*

package javalearning;


 abstract class dad{
	 dad()
{
	System.out.println("dad constructor");
	
}
abstract void run();

}



 abstract class mom{
	mom()
	{
		System.out.println("child constructor");
	}
	abstract void run();
	{
	System.out.println("parents are running");	
	}	
	
}



public class AbstractClassProgram extends mom{
	AbstractClassProgram()
	{
		System.out.println("baby constructor");
	}
	
	void run()
	{
		
		System.out.println();
	}

	public static void main(String arg[])
	{
		dad d = new AbstractClassProgram();
		d.run();
		
	}
}

*/

