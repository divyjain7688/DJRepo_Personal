package javaCode;


public class StringProgram {
	
	private static final int String = 0;

	public static void main(String arg[])
	{
		String s = "Divy";
		System.out.println("substring is " +s.substring(1,2));
		s.concat("jain");
		System.out.println(s);
		s=s.concat("jain2");
		System.out.println(s);
		
		
		String s3 = new String("DJ");
		String s4 = new String("DJ");
		System.out.println(s3.equals(s4));
		System.out.println(s3==s4);
		
		
		String s5="India";
		String s6="India";
		
		System.out.println(s5.equals(s6));
		System.out.println(s5==s6);
		
		
		
		
		String a = "India";
		String b = "is";
		String c = "independant";
		String d = a+b+c;
		String e = "ms" +"dhoni"; 
		System.out.println(d);		
		System.out.println(e);
		String e1 = (a.concat(b)).concat(c);
		System.out.println(e1);
		
		 String Test1 = "ABC";
String Test2= "ABC";
Test1.contains(Test2);
		
	}

}
