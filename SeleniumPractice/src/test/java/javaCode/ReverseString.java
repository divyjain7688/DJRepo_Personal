package javaCode;

public class ReverseString {
	public static void main(String arg[])
	{
		String s = "automation testing";
		String rev="";
		for(int i=s.length()-1;i>=0;i--)
		{
			rev=rev+s.charAt(i);
		}
		System.out.println("reverse string is    "+ rev);
	}

}
