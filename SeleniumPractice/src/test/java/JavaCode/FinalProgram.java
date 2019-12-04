package JavaCode;
/*package javalearning;

public class FinalProgram {
	int a = 10;
 void finalvalue()
{
a=19;	
}
public static void main(String[] arg)
{
FinalProgram f = new FinalProgram();
System.out.println(f.a);
f.finalvalue();
System.out.println(f.a);

}

}
10
19
*/










/*

package javalearning;

public class FinalProgram {
	final int a = 10;
 void finalvalue()
{
a=19;	
}
public static void main(String[] arg)
{
FinalProgram f = new FinalProgram();
System.out.println(f.a);
f.finalvalue();
System.out.println(f.a);

}

}
10
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The final field FinalProgram.a cannot be assigned

	at javalearning.FinalProgram.finalvalue(FinalProgram.java:40)
	at javalearning.FinalProgram.main(FinalProgram.java:46)
*/















/*package javalearning;


class parent{
	 final void display()
	 {
	 System.out.println("parent");
	 }
	
}

class child extends parent{
	  void display()
	 {
	 System.out.println("child");
	 }
	
}
public class FinalProgram {
	
	

public static void main(String[] arg)
{
child c = new child();
c.display();


}
}
Exception in thread "main" java.lang.VerifyError: class javalearning.child overrides final method display.()V



*/












/*

package javalearning;
class parent{
	 final void display()
	 {
	 System.out.println("parent");
	 }	
}

class child extends parent{
	  void childdisplay()
	 {
	 System.out.println("child");
	 }
	
}
public class FinalProgram {
	
	

public static void main(String[] arg)
{
child c = new child();
c.display();
c.childdisplay();

}
}
parent
child
*/















/*package javalearning;
class parent{
	 final void display()
	 {
	 System.out.println("parent");
	 }	
}

class child extends parent{
	  void childdisplay()
	 {
	 System.out.println("child");
	 }
	
}
public class FinalProgram {
	
	

public static void main(String[] arg)
{
parent c = new child();
c.display();

}
}
parent*/














/*package javalearning;
 final class parent{
	 void display()
	 {
	 System.out.println("parent");
	 }	
}

class child extends parent{
	  void childdisplay()
	 {
	 System.out.println("child");
	 }
	
}
public class FinalProgram {
	
	

public static void main(String[] arg)
{
parent c = new child();
c.display();

}
}
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The method display() is undefined for the type child

	at javalearning.FinalProgram.main(FinalProgram.java:231)
	*/

















/*
package javalearning;
  class parent{
	 final int a;
	 static final int b;
	 parent()
	 {
		 a=10;
	 }
	 static{
		 b=12;
	 }
	 void display()
	 {
	 System.out.println("parent" + "  " + a + "  " + b);
	 }	
}

public class FinalProgram {
	
	

public static void main(String[] arg)
{
parent c = new child();
c.display();

}
}
parent  10  12


*/






