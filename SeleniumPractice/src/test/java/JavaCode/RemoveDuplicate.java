package JavaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate {

	public static void main(String arg[])
	{
		int i[]= new int[] {4,3,5,6,7,5,2,7,3,5};
		
		RemoveDuplicate r = new RemoveDuplicate();
		System.out.println(r.removeDup("abcfc"));
		
		r.removeDupInt(i);
	}

	public String removeDup(String str) {
		String strNoDup = "";

		// loop over string and get each char
		for(char ch : str.toCharArray()) {
			// if strNoDup does not contain char then add to it
			if(!strNoDup.contains(String.valueOf(ch))) {
				strNoDup += ch;
			}
		}
		return strNoDup;
	} 
	
	public void removeDupInt(int[]  a)
	{
		Arrays.sort(a);
		List<Integer> noDup = new ArrayList<Integer>();
		System.out.println(a);
		for(int j=0;j<a.length-1;j++)
		{
			if(a[j]!=a[j+1])
			{
				noDup.add(a[j]);
			}
		}
		System.out.println("noDup are "+ noDup.toString() );
		

		
	} 
}