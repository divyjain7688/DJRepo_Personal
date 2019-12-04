
package JavaCode;
import java.util.*;  
import java.io.*;  


public class comparabletest implements Comparable<comparabletest>{
	int age ;
	int rollno;
	String name;

	public comparabletest(int age, int rollno,String name)
	{
		this.age=age;
		this.rollno=rollno;
		this.name=name;
	}
                                                                                                                                                                                                                                                                                                                                                                                  
	public int compareTo(comparabletest c)
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
		comparabletest c3= new comparabletest(20,345,"Amit");
		comparabletest c1= new comparabletest(40,123,"Ajay");
		comparabletest c2= new comparabletest(30,234,"Raman");

		ArrayList<comparabletest> al = new 	ArrayList<comparabletest>();
		al.add(c1);
		al.add(c2);
		al.add(c3);
		System.out.println("before sorting");
		for(comparabletest a:al)
		{
			System.out.println("a is"+ a);
			System.out.println(a.age+ " "+ a.rollno+" "+ a.name);
		}
		Collections.sort(al);

		System.out.println("after sorting");
		for(comparabletest a:al)
		{
			System.out.println("a is"+ a);
			System.out.println(a.age+ " "+ a.rollno+" "+ a.name);
		}		
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