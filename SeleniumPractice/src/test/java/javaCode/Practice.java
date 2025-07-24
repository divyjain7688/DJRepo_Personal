package javaCode;

public class Practice {

	static int s;
	static {
		s=s+1;
		System.out.println("value of s is "+ s);
	}
	static void change()
	{
		System.out.println("Change fn called");
		s=s+1;
		System.out.println("value of s is "+ s);

	}


	public static void main(String arg[])
	{
		System.out.println("automation testing ");
		byte a=10;  
		byte b=10;
		byte c=(byte) (a+b);
		System.out.println("value of c is "+c);
		int x= 10;
		System.out.println(x--); //10
		System.out.println(--x); //8
		System.out.println(x--); //8
		System.out.println(x);  //7

		System.out.println(x++ + x++);  //7+8

		System.out.println(x++ + ++x);  //9+11

		System.out.println(10<<2);//10*2^2=10*4=40  
		System.out.println(20>>3);//20/2^3=20/8=2  



		int a1=10;  
		int b2=5;  
		int min=(a1<b2)?a1:b2;  
		System.out.println(min);  


		change();


		aa:  
			for(int i=1;i<=3;i++)
			{  
				bb:  
					for(int j=1;j<=3;j++){  
						if(i==2&&j==2){  
							break bb;  
						}  
						System.out.println(i+" "+j);  
					}  
			}  





	}

}
