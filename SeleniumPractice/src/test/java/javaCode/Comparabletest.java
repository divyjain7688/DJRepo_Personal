
package javaCode;
import java.util.*;  
import java.io.*;  


public class Comparabletest implements Comparable<Comparabletest>{
	int age ;
	int rollno;
	String name;

	public Comparabletest(int age, int rollno,String name)
	{
		this.age=age;
		this.rollno=rollno;
		this.name=name;
	}
                                                                                                                                                                                                                                                                                                                                                                                  
	public int compareTo(Comparabletest c)
	{
		if(age==c.age)
			return 0;
		else if(age>c.age)  
			return 1;  
		else  
			return -1;  
	}

	public static void main(String arg[])
	{
		Comparabletest c3= new Comparabletest(20,345,"Amit");
		Comparabletest c1= new Comparabletest(40,123,"Ajay");
		Comparabletest c2= new Comparabletest(30,234,"Raman");

		ArrayList<Comparabletest> al = new 	ArrayList<Comparabletest>();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		System.out.println("before sorting");
		for(Comparabletest a:al)
		{
			System.out.println(a.age+ " "+ a.rollno+" "+ a.name);
		}
		Collections.sort(al);

		System.out.println("after sorting");
		for(Comparabletest a:al)
		{
			System.out.println(a.age+ " "+ a.rollno+" "+ a.name);
		}	
		
		System.out.println("c2 isss" + c2);

	}

	public String toString(){//overriding the toString() method  
		return rollno+" "+name+" "+age;  
	}  
}

/*

before sorting
40 123 Ajay
30 234 Raman
20 345 Amit

after sorting
20 345 Amit
30 234 Raman
40 123 Ajay
 */