package javaCode;
/*package Basics;

public class ObjectAndClass {
	int i ;
	String a ;
	
	public static void main(String args[])
	{
		
		ObjectAndClass o1 = new ObjectAndClass();
		System.out.println("i is "+ o1.i + "and a is "+ o1.a);
	}
	

}
i is 0and a is null
*/




/*package Basics;

public class ObjectAndClass {
	int i ;
	String a ;
	
	public static void main(String args[])
	{
		
		ObjectAndClass o1 = new ObjectAndClass();
		o1.i=10;
		o1.a="aaru";
		System.out.println("i is "+ o1.i + "and a is "+ o1.a);
	}
	

}
i is 10and a is aaru*/







/*package Basics;

public class ObjectAndClass {
	int i ;
	String a ;
	
	public static void main(String args[])
	{
		
		ObjectAndClass o1 = new ObjectAndClass();
		ObjectAndClass o2 = new ObjectAndClass();

		o1.i=10;
		o1.a="aaru";
		o2.i=11;
		o2.a="DIVY";
		System.out.println("i is "+ o1.i + "and a is "+ o1.a);
		System.out.println("i is "+ o2.i + "and a is "+ o2.a);

	}
	

}
i is 10and a is aaru
i is 11and a is DIVY
*/











/*package Basics;

public class ObjectAndClass {
	int i ;
	String a ;
	
	void storevalue(int j , String b)
	{
		i=j;
		a=b;
	}
	
	void showvalue()
	{
		System.out.println("value of i and a are "+ i+" "+a);
	}
	
	public static void main(String args[])
	{
		
		ObjectAndClass o1 = new ObjectAndClass();
		ObjectAndClass o2 = new ObjectAndClass();
		o1.storevalue(12, "divyaarti");
		o1.showvalue();
	}
	

}
value of i and a are 12 divyaarti*/







/*package Basics;

public class ObjectAndClass {
	int i ;
	String a ;
	
	ObjectAndClass(int j , String b)
	{
		i=j;
		a=b;
	}
	
	void showvalue()
	{
		System.out.println("value of i and a are "+ i+" "+a);
	}
	
	public static void main(String args[])
	{
		
		ObjectAndClass o1 = new ObjectAndClass(111,"divy");
		ObjectAndClass o2 = new ObjectAndClass(112,"aaru");
		o1.showvalue();
		o2.showvalue();

	}
	

}
value of i and a are 111 divy
value of i and a are 112 aaru*/




public class ObjectAndClass {
	int i ;
	String a ;
	
	ObjectAndClass(int j , String b)
	{
		i=j;
		a=b;
	}
	
	void showvalue()
	{
		System.out.println("value of i and a are "+ i+" "+a);
	}
	
	public static void main(String args[])
	{
		
		ObjectAndClass o1 = new ObjectAndClass(111,"divy");
		ObjectAndClass o2 = new ObjectAndClass(112,"aaru");
		o1.showvalue();
		o2.showvalue();

	}
	

}