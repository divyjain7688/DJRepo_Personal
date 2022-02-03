package javaCode;

public class Callbyvalueandreference {

	int data=50;  
	  
	 void change(int data){  
//	data=data+100;//changes will be in the local variable only  
	 this.data=data;

	 System.out.println("data value inside function " + data);
	 }  
	     
	 public static void main(String args[]){  
		 Callbyvalueandreference c=new Callbyvalueandreference();  
	  
	   System.out.println("before change "+c.data);  
	   c.change(500);  
	   System.out.println("after change "+c.data);  
	  
	 }  
	/* before change 50
	 data value inside function600
	 after change 50*/
}  















/*package javalearning;

public class Callbyvalueandreference {

	int data=50;  
	  
	 void change(int data){  
	//data=data+100;//changes will be in the local variable only  
	 this.data=data;

	 System.out.println("data value inside function" + data);
	 }  
	     
	 public static void main(String args[]){  
		 Callbyvalueandreference c=new Callbyvalueandreference();  
	  
	   System.out.println("before change "+c.data);  
	   c.change(500);  
	   System.out.println("after change "+c.data);  
	  
	 }  
	 
}  
before change 50
data value inside function500
after change 500
*/














/*

package javalearning;

public class Callbyvalueandreference {

	int data=50;  
	  
	 void change(Callbyvalueandreference c1){  
	//data=data+100;//changes will be in the local variable only  
c1.data=c1.data+100;
	 System.out.println("data value inside function" + data);
	 }  
	     
	 public static void main(String args[]){  
		 Callbyvalueandreference c=new Callbyvalueandreference();  
	  
	   System.out.println("before change "+c.data);  
	   c.change(c);  
	   System.out.println("after change "+c.data);  
	  
	 }  
	 
}
before change 50
data value inside function150
after change 150
*/