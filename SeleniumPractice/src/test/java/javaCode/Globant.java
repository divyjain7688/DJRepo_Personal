package javaCode;

import java.util.ArrayList;

public class Globant {
	public static void main(String arg[])
	{
	int num1[] = {1,2,3};
	int num2[] = {1,2,3,4,5};
	num1=num2;
	for(int num:num1)
	{
	System.out.println(num1);
	}
	ArrayList<Integer> a = new ArrayList<Integer>();
	a.add(1);
	a.add(null);
	a.remove(null);
	System.out.println(a);
	StringBuilder sb = new StringBuilder(5);
	String s = "";
	if(sb.equals(s))
	{
		System.out.println("aa");
	}
	if(sb.toString().equals(s.toString()))
		System.out.println("bbb");
	String s1 = "d\"f";
	System.out.println(s1);
	}
	
	
	

}
