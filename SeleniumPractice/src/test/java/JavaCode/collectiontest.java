package JavaCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class collectiontest {
	public static void main(String arg[])
	{
			
	/*	//filter duplicate value and print 
		List<String> full = new ArrayList<String>();
		full.add("test");
		full.add("testing");
		full.add("test");
		full.add("testLnt");
		full.add("test");

		Set<String> duplicates = new HashSet<String>();

		Set<String> temp = new HashSet<String>();
		for(String f : full)
		{
			if(temp.add(f)==false)
			{
				duplicates.add(f);
			}
		}
		System.out.println("dup are" + duplicates);*/

		 

		
		
		
		/*//	sort strings in array
		String[] inputList = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"aug", "Sep", "Oct", "nov", "Dec" };
		TreeSet<String> sortSet = new TreeSet<String>();
		for(String s : inputList)
		{
			sortSet.add(s);
		}
		System.out.println("sorted is "+ sortSet);
		}*/


		 



/*		//	sort int
		int data[] = {10,5,7,2,90,43,76};
		System.out.println("data.length"+ data.length);
		for(int i=0;i<data.length;i++)
		{
			for(int j=i+1;j<data.length;j++)
			{
				if(data[i]>data[j])
				{
					int temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}

		}
		System.out.println("sorted values are" );
		for(int d : data)
		{
			System.out.println(d);
		}
		}
		 */


		
		
		
		
		
		
	/*	//revrse number
		
		int number = 5463;
		System.out.println(number);
		int invert=0;
		while(number!=0)
		{
		invert=(invert*10)+(number%10);	
		number=number/10;
		}
		System.out.println("invert "+ invert);
		}
*/





	/*	//program to write first 2 max int value from array
		int listData[] = { 15, 24, 48, 30, 43, 11, 79, 93 };
		int maxOne=0;
		int maxTwo=0;
		for(int l : listData)
		{
			if(maxOne<l)
			{
				maxTwo=maxOne;
				maxOne=l;
			}
			else if(maxTwo<l)
			{
				maxTwo=l;
			}
		}
		System.out.println("max 2 is "+ maxTwo);
		System.out.println("max 1 is "+ maxOne);*/
		
		
		
		
		
		
		
		/*// uneven spaces between words
		String blogName = "how to   do    in  java   .         com";
		String nameWithProperSpacing = blogName.replaceAll("\\s+", " ");
		System.out.println( nameWithProperSpacing );
		
		String name = "how to   do    in  java   .         com";
		String nameWitouthProperSpacing = blogName.replaceAll("( )+", " ");
		System.out.println( nameWitouthProperSpacing );*/
		
		
		
		
		
		//remove spaces without replace
		String str1 = "Saket Saurav        is an Autom ation Engi ne      er";
		char[] chars = str1.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++)
		{

			if( (chars[i] != ' ') && (chars[i] != '\t') )

			{

				sb.append(chars[i]);

			}

		}

		System.out.println(sb);
		System.out.println(sb.toString());
	}
}
