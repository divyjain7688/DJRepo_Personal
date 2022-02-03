package javaCode;

public class Static {

	int rollno;  
	   String name;  
	   static String college="";  
	   static void change()
	   {
		   college =  "LNCT";
	   }
	   static {  college =  "DAVV";};
	   Static(int r, String n)
	   {
		   rollno = r;
		   name = n;
	   }
	   void display (){System.out.println(rollno+" "+name+" "+college);}  

	   public static void main(String arg[])
	   {
		   Static s1= new Static(123,"divy");
		   Static s2= new Static(234,"aaru");
		  change();
		   s1.display();
		   s2.display();
	   }
}




/*public class Static
{
static int a =10;
public static void main(String arg[])
{
	System.out.println("a is "+ a);
	System.out.println("a is "+ Static.a);

}
}
a is 10
a is 10
*/