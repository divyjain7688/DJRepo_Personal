package javaCode;

public class NLargestNumber{

	public static int getThirdLargest(int[] a){  
		int temp;  
		for (int i = 0; i < a.length; i++)   
		{  
			for (int j = i + 1; j < a.length; j++)   
			{  
				if (a[i] > a[j])   
				{  
					temp = a[i];  
					a[i] = a[j];  
					a[j] = temp;  
				}  
			}  
		}  
		return a[a.length-3];  
	}  
	public static void main(String args[]){  
		int a[]={1,2,5,6,3,2};  
		int b[]={44,66,99,77,33,22,55};  
		System.out.println("Third Largest: "+getThirdLargest(a));  
		System.out.println("Third Largest: "+getThirdLargest(b));  
	}  
}


/*public class test {
	public static void main(String[] args)
	{
		int arr[] = { 14, 46, 99, 94, 94, 52, 86, 36, 94, 89 };
		int largest = arr[0];
		int secondLargest = arr[0];
		System.out.println("The given array is:");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "\t");
		}
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > largest)
			{
				secondLargest = largest;
				largest = arr[i];
			}
			else if (arr[i] > secondLargest && arr[i] < largest)
			{
				secondLargest = arr[i];
			}
		}
	}
}
*/