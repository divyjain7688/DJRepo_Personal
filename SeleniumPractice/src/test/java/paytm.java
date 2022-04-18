import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class paytm {
	public static void main(String arg[])
	{
		int[] values = {7,9,0,3,2,66,99,120,121};
		List<Integer> oddValues = new ArrayList<Integer>();
		List<Integer> evenValues = new ArrayList<Integer>();

		for(int value : values)
		{
			if(value==0)
			{
				oddValues.add(value);
			}
			else if(value%2==0)
			{
				evenValues.add(value);
			}
			else if(value%2!=0)
			{
				oddValues.add(value);
			}

		}
		System.out.println(oddValues);
		System.out.println(evenValues);

		Integer[] arrOddValues = oddValues.toArray(new Integer[oddValues.size()]);
		Integer[] arrEvenValues = evenValues.toArray(new Integer[evenValues.size()]);
		System.out.println("arrEvenValues-- "+ arrEvenValues);
							
		for(int i=0;i<oddValues.size();i++)
		{
			for(int j=0;j<oddValues.size()-i;j++)
			{
			//	if(oddValues[i]>oddValues[j])
				{
					
				}
			}
		}

	}
}
