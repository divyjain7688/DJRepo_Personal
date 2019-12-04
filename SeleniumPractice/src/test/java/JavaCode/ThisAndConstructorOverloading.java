package JavaCode;
/*package javalearning;

public class ThisAndConstructorOverloading {
	int a;
	int b;
	public ThisAndConstructorOverloading(int a, int b)
	{
	this.a = a;
	this.b = b;
	
	}
	public ThisAndConstructorOverloading(int a)
	{
		this.a=a;
	}
   void showvalue()
   {
	   System.out.println(a+" "+b);	   
   }
   
   public static void main(String arg[])
   {
	   ThisAndConstructorOverloading cons1 = new ThisAndConstructorOverloading(4);
	   cons1.showvalue();
	   ThisAndConstructorOverloading cons2 = new ThisAndConstructorOverloading(4,5);
	   cons2.showvalue();

   }
}
4 0
4 5*/



















/*

package javalearning;

public class ThisAndConstructorOverloading {
	int a;
	int b;
	int c;
	public ThisAndConstructorOverloading(ThisAndConstructorOverloading cons3,int c)
	{
	this.a=cons3.a;
	this.b=cons3.b;
	this.c=c;
	
	}
	public ThisAndConstructorOverloading(int a,int b)
	{
		this.a=a;
		this.b=b;
	
	}
   void showvalue()
   {
	   System.out.println(a+" "+b+" " +c);	   
   }
   
   public static void main(String arg[])
   {
	   ThisAndConstructorOverloading cons1 = new ThisAndConstructorOverloading(4,6);
	   cons1.showvalue();
	   ThisAndConstructorOverloading cons2 = new ThisAndConstructorOverloading(cons1,5);
	   cons2.showvalue();

   }
}
4 6 0
4 6 5*/












/*

package javalearning;

public class ThisAndConstructorOverloading {
	int a;
	int b;
	int c;
	public ThisAndConstructorOverloading(ThisAndConstructorOverloading cons3,int c)
	{
	this.a=cons3.a;
	this.b=cons3.b;
	this.c=c;
	
	}
	public ThisAndConstructorOverloading(int a,int b)
	{
		this.a=a;
		this.b=b;
	
	}
   void showvalue()
   {
	   System.out.println(a+" "+b+" " +c);	   
   }
   
   public static void main(String arg[])
   {
	   ThisAndConstructorOverloading cons1 = new ThisAndConstructorOverloading(4,6);
	   cons1.showvalue();
	   ThisAndConstructorOverloading cons2 = new ThisAndConstructorOverloading(cons1,5);
	   cons2.showvalue();

   }
}
4 6 0
4 6 5
*/