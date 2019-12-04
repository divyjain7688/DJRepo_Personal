package JavaCode;
/*package javalearning;

public class methodoverloadingprogram {
	
	static int add(int a, int b)
	{ int c = a=b;
		return c;
	}

	static int add(int a, int b, int c)
	{
	int d = a+b+c;
	return d;
	}
	
	public static void main(String[] arg)
	{
		int add1 = methodoverloadingprogram.add(2, 3);
		System.out.println(add1);
		int add2 = methodoverloadingprogram.add(2, 5, 7);
		System.out.println(add2);
		
	}
	
	}

3
14
*/











/*package javalearning;

public class methodoverloadingprogram {
	
	static int add(int a, int b)
	{ int c = a=b;
		return c;
	}

	static double add(double a, double b)
	{
		double c= a+b;
	return c;
	}
	
	public static void main(String[] arg)
	{
		int add1 = methodoverloadingprogram.add(2, 3);
		System.out.println(add1);
		double add2 = methodoverloadingprogram.add(2.0, 4.3);
		System.out.println(add2);
		
	}
	
	}
3
6.3
*/










/*
package javalearning;

public class methodoverloadingprogram {
	
	static float add(int  a, long b)
	{ 
		return a+b;
	}

	static long add(long a, long b,long c)
	{
		long d= c+a+b;
	return d;
	}
	
	public static void main(String[] arg)
	{
		float add1 = methodoverloadingprogram.add(5,10);
		System.out.println("addition is " + add1);
	
		
	}
	
	}

addition is 15.0*/










/*package javalearning;

public class methodoverloadingprogram {
	
	static float add(int  a, long b)
	{ 
		return a+b;
	}

	static long add(long a, long b,long c)
	{
		long d= c+a+b;
	return d;
	}
	
	public static void main(String[] arg)
	{
		float add1 = methodoverloadingprogram.add(5,10);
		System.out.println("addition is " + add1);
	
		
	}
	
	}

addition is 15.0


*/














/*package javalearning;

public class methodoverloadingprogram {
	
	static long add(int  a, long b)
	{ 
		return a+b;
	}

	static long add(long a, long b,long c)
	{
		long d= c+a+b;
	return d;
	}
	
	public static void main(String[] arg)
	{
		long add1 = methodoverloadingprogram.add(5,10);
		System.out.println("addition is " + add1);
	
		
	}
	
	}
addition is 15
*/













/*

package javalearning;

public class methodoverloadingprogram {
	
	static void add(int  a, long b)
	{ 
		long c =  a+b;
	}

	static void add(long a, int b)
	{
		long  d= a+b;
	}
	
	public static void main(String[] arg)
	{
		long add1 = methodoverloadingprogram.add(3, 6);
		System.out.println("addition is " + add1);
	
		
	}
	
	}

Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The method add(int, long) is ambiguous for the type methodoverloadingprogram

	at javalearning.methodoverloadingprogram.main(methodoverloadingprogram.java:218)
Picked up _JAVA_OPTIONS: -Dsun.java2d.d3d=false


*/










/*
package javalearning;

public class methodoverloadingprogram {
	
	 void add(int  a, int b)
	{ 
		int c =  a+b;
		System.out.println("int   " + c);
	}

	 void add(long a, long b)
	{
		long  d= a+b;
		System.out.println("long    " + d);
	}
	
	public static void main(String[] arg)
	{
		
		methodoverloadingprogram M = new methodoverloadingprogram();
		M.add(1, 3);
		M.add(1234544,1234544);
		
	}
	
	}

int   4
int   2469088
*/