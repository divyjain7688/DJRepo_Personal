package javaCode;
/*package Basics;

public class Overloading {
	
	 void sum(int a,long b){System.out.println(a+b);}  
	  void sum(int a,int b,int c){System.out.println(a+b+c);}  
	  
	  public static void main(String args[]){  
		  Overloading obj=new Overloading();  
	  obj.sum(20,20);//now second int literal will be promoted to long  
	  obj.sum(20,20,20); 
	  }
}
40
60
*/


/*package Basics;

public class Overloading {
	
	static int add(int a, int b){return a+b;}  
	static double add(double a, double b){return a+b;}  
	
	public static void main(String[] args){  
	System.out.println(add(11,11));  
	System.out.println(add(12.3,12.6));  
}
	}
22
24.9*/


/*

class OverloadingCalculation3{  
  void sum(int a,long b){System.out.println("a method invoked");}  
  void sum(long a,int b){System.out.println("b method invoked");}  
  
  public static void main(String args[]){  
  OverloadingCalculation3 obj=new OverloadingCalculation3();  
  obj.sum(20,20);//now ambiguity  
  }  
}  
Output:Compile Time Error*/
