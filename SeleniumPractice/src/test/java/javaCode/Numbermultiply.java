package javaCode;

public class Numbermultiply {
	public static void main(String arg[])
	{
		int[] value= {2,3,5,10};
		int[] result = new int[value.length];
		int numerator = 1;

		for(int i=0;i<value.length;i++)
		{
			numerator=numerator*value[i];
		}
		System.out.println("numerator value is "+ numerator);

		for(int j=0;j<value.length;j++)
		{
			result[j]= numerator/value[j];
			System.out.println(result[j]);
		}
	}

}
