package javaCode;

public class Javaarrayprogram {
	

	
	public static void main(String arg[])
	{
		int a[][] = {{1,2,3},{5,6,7}};
		int b[][] = {{5,6,7},{1,2,3}};
		int c[][] = new int[2][3];
		
		for (int i=0; i<a.length; i++)
		{
			for (int j=0; i<b.length; i++)
			{
				c[i][j]=a[i][j]+b[i][j];  
				System.out.print(c[i][j]+" "); 
			}

			System.out.println();
			
		}
		
	}

}
