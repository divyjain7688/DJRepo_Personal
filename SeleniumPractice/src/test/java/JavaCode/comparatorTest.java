/*package JavaCode;
import java.util.*;  
public class comparatorTest{
	int age;
	int rollno;
	String name;
	
	public comparatorTest(int age,int rollno,String name)
	{
		this.age=age;
		this.rollno=rollno;
		this.name=name;
	}
	
	
class sortbyname implements   Comparator<comparatorTest>{
public int compare(comparatorTest c1, comparatorTest c2)
{
	return c1.name.compareTo(c2.name);  
}
}

class sortbyrollno implements Comparator<comparatorTest> {
	
	public int compare(comparatorTest c1, comparatorTest c2)
	{
		
		if(c1.rollno==c2.rollno)
			return 0;
		else if(c1.rollno>c2.rollno)
			return 1;
		else 
			return -1;
	}	
}

public static void main(String arg[])
{
	comparatorTest co1 = new comparatorTest(40,444,"Divy");
	comparatorTest co2 = new comparatorTest(10,111,"Ram");
	comparatorTest co3 = new comparatorTest(30,333,"Shyam");
	comparatorTest co4 = new comparatorTest(70,777,"Vijay");
	ArrayList<comparatorTest> al = new ArrayList<comparatorTest>();
	al.add(co1);
	al.add(co2);
	al.add(co3);
	al.add(co4);
	System.out.println("before sorting");
	for(comparatorTest a:al)
	   {
		System.out.println(a.age+ " "+ a.rollno+" "+ a.name);
		}
	
	
	Collections.sort(al,new sortbyname());
			
			System.out.println("after sorting by name ");
	for(comparatorTest a:al)
	  {
		System.out.println(a.age+ " "+ a.rollno+" "+ a.name);
		}		


	
	Collections.sort(al,new sortbyrollno());
	
	System.out.println("after sorting by rollno ");
for(comparatorTest a:al)
{
System.out.println(a.age+ " "+ a.rollno+" "+ a.name);
}		





}

}
*/