package JavaCode;
import java.util.ArrayList;

public class uniqueInArray {
	public static void main(String arg[])
	{
		int a[] = {1,2,3,2,4,3,5,4,6,5};
		ArrayList<Integer> l= new ArrayList<Integer>();
		for(int i=0;i<a.length-1;i++)
		{
			int c=0;
			if(!l.contains(a[i]))
			{	
				l.add(a[i]);
				c++;
				for(int j=i+1;j<a.length;j++)
				{
					if(a[i]==a[j])
					{
						c++;
					}
				}
				if(c==1)
				{
					System.out.println("unique element is "+ a[i]);
				}
				else
				{
					System.out.println("number  " +a[i] + " occured " + c+" times");
				}
			}
		}
	}
}
