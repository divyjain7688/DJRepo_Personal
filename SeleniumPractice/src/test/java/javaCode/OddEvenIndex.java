package javaCode;

public class OddEvenIndex {

	public static void main(String arg[])
	{
		int j=0;
		int k=1;
		int[] values = {7,9,0,11,2,66,99,120,100};	//1357 0246

		int[] orderedValue = new int[values.length];

		for(int i=0;i<values.length;i++)
		{
			if(values[i]%2==0)
			{
				orderedValue[j]=values[i];
				j=j+2;
			}
			else
			{
				orderedValue[k]=values[i];
				k=k+2;
			}
		}
		
		
		for(int i=0;i<=orderedValue.length-1;i++)
		{
//			for(int a=0;a<orderedValue.length-1-i;a++)
//			{
//				if(orderedValue[a]>orderedValue[a+1])
//				{
//					int temp=orderedValue[a];
//					orderedValue[a]=orderedValue[a+1];
//					orderedValue[a+1]=temp;
//				}
//			}
			System.out.println(orderedValue[i]);

		}
		
		
		System.out.println("---------");

		for(int i=0;i<=orderedValue.length-2;i++)
		{
			for(int a=0;a<orderedValue.length-2-i;a++)
			{
				if(orderedValue[a]>orderedValue[a+2])
				{
					int temp=orderedValue[a];
					orderedValue[a]=orderedValue[a+2];
					orderedValue[a+2]=temp;
				}
			}
			for(int a=1;a<orderedValue.length-2-i;a++)
			{
				if(orderedValue[a]>orderedValue[a+2])
				{
					int temp=orderedValue[a];
					orderedValue[a]=orderedValue[a+2];
					orderedValue[a+2]=temp;
				}
			}
			System.out.println(orderedValue[i]);
		}
	}

}
