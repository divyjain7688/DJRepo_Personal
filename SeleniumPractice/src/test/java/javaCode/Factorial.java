package javaCode;

public class Factorial {
	
	int i=10,fact=1;
	public static void main(String arg[])
	{
		Factorial f = new Factorial();
		int value = f.factValueRec(10);
		System.out.println("value is "+ value);
		f.factValue(10);
	}
	
	public int factValueRec(int i)
	{
		if(i==0)
		{
			return 1;
		}
		return i*factValueRec(i-1);
		
	}
	
	public void factValue(int i)
	{
		while(i!=0)
		{
			fact=fact*i;
			i--;
		}
		System.out.println("fact value is "+ fact);
	}
}
