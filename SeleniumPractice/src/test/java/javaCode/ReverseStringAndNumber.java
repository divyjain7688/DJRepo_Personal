package javaCode;

public class ReverseStringAndNumber {
	public static void main(String arg[])
	{
		String s = "automation testing";
		String rev="";
		for(int i=s.length()-1;i>=0;i--)
		{
			rev=rev+s.charAt(i);
		}
		System.out.println("reverse string is    "+ rev);
		
		
		
		int number = 5463;
		System.out.println(number);
		int invert=0;
		while(number!=0)
		{
		invert=(invert*10)+(number%10);	
		number=number/10;
		}
		System.out.println("invert "+ invert);
		}
	
	
	
	}

