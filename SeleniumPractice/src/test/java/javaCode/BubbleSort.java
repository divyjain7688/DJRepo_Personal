package javaCode;

public class BubbleSort {
	public static void main(String arg[])
	{
		int arr[]= {200,10,40,20,15,60,50,5};
		bubbleSort(arr);
	}

	public static void bubbleSort(int arr[])
	{
		for (int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for (int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}

