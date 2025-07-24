package javaCode;

import org.testng.Assert;

public class StringProgram {

	private static final int String = 0;

	public static void main(String arg[])
	{
		String num1 = "2";
		String num2 = "2";
		
		Assert.assertEquals(num1, num2);
		String str = "This this is is done by Saket Saket";	
		String words[] = str.split("testing");
		System.out.println(words[0]);
		
		String s = "Divy";
		System.out.println("substring is " +s.substring(1,2));
		s.concat("jain");
		System.out.println(s);
		s=s.concat("jain2");
		System.out.println("string is " +s);
		System.out.println("start with "+ s.startsWith("s"));


		String s3 = new String("DJ");
		String s4 = new String("DJ");
		String s9 = "DJ";
		System.out.println(s3.equals(s4)); //equal compare just values
		System.out.println(s3==s4); //== compare references
		System.out.println(s3==s9);


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
		
		
		
		str = "  India   will      win  the wc 2019 ;";
		System.out.println("str is "+ str);
		
		str=str.replace("\\s+", " ");
		System.out.println("str is "+ str);
		System.out.println("float  "+ .1+.2+.3);
		System.out.println("float  "+ .1+.2+.3+3);
		System.out.println( .1+.2);
		System.out.println( .1+.2+4);


		String ss = "#t%6Y";
		ss = ss.replaceAll("[a-zA-Z0-9]", "");
		System.out.println("ss is "+ ss);
	}

}
