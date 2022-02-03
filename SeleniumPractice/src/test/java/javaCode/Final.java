package javaCode;
/*package Basics;

public class Final {
	final int a=10;
	public void add()
	{
		a=a+1;
	}
	public static void main(String arg[])
	{
		Final f = new Final();
		f.add();
	}

}
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The final field Final.a cannot be assigned

	at Basics.Final.add(Final.java:7)
	at Basics.Final.main(Final.java:12)*/









//class parent{
//	void run()
//	{
//		System.out.println("parent running");
//	};
//}
//
//class child extends parent{
//	void run()
//	{
//		System.out.println("child running");
//	};
//}
//
//public class Final {
//	public static void main(String arg[])
//	{
//	parent p = new child();
//p.run();
//	}
//}
/*child running*/




/*

package Basics;
class parent{
	final void run()
	{
		System.out.println("parent running");
	};
}

class child extends parent{
	void run()
	{
		System.out.println("child running");
	};
}

public class Final {
	public static void main(String arg[])
	{
	parent p = new child();
p.run();
	}
}
Exception in thread "main" java.lang.VerifyError: class Basics.child overrides final method run.()V*/













/*package Basics;
class parent{
	final void run()
	{
		System.out.println("parent running");
	};
}

class child extends parent{
	void run()
	{
		System.out.println("child running");
	};
}

public class Final {
	public static void main(String arg[])
	{
	parent p = new child();
p.run();
	}
}
Error: Unable to initialize main class Basics.Final
Caused by: java.lang.VerifyError: class Basics.child overrides final method Basics.parent.run()V

*/





//class parent{
//	final void run()
//	{
//		System.out.println("parent running");
//	};
//	void jog()
//	{
//		System.out.println("parent running");
//	};
//}
//
//class child extends parent{
//	void jog()
//	{
//		System.out.println("child running");
//	};
//}
//
//public class Final {
//	public static void main(String arg[])
//	{
//		parent p= new child();
//		p.run();
//		p.jog();
//		}
//}









/*
package Basics;
public class Final {
	final int a;
	static final int b;
	static {b=20;}
	Final()
	{
		a=10;
	}

	public void showvalue()
	{
		System.out.println("a is "+a+"b is "+b);
	}
	public static void main(String arg[])
	{
		Final f = new Final();
f.showvalue();
	}
}
a is 10b is 20*/

