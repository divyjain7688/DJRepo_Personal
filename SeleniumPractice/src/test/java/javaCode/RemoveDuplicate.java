package javaCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String arg[])
	{
		int i[]= new int[] {4,3,5,6,7,5,2,7,3,5};
		
		RemoveDuplicate r = new RemoveDuplicate();
		System.out.println(r.removeDup("abcfc"));
		
		r.removeDupInt(i);
		
		r.FilterDuplicate();
	}

	//remove dup from string
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
	
	//remove dup int from int array
	public void removeDupInt(int[] a) {
	    Set<Integer> noDup = new LinkedHashSet<Integer>();
	    for (int num : a) {
	        noDup.add(num); // Set automatically handles duplicates
	    }
	    System.out.println("noDup are " + noDup);
	}
	

	
	//filter duplicate value and print 
	public void FilterDuplicate()
	{
	List<String> full = new ArrayList<String>();
	full.add("test");
	full.add("testing");
	full.add("test");
	full.add("testLnt");
	full.add("test");

//	Set<String> duplicates = new HashSet<String>(full);
//System.out.println("duplicates=== " + duplicates);
	Set<String> duplicates = new HashSet<String>();
	Set<String> temp = new HashSet<String>();
	for(String f : full)
	{
		if(temp.add(f)==false)
		{
			duplicates.add(f);
		}
	}
	System.out.println("dup are" + duplicates);	
	
	Set<String> uniques = new HashSet<String>(full);
	System.out.println("uniques are" + uniques);	

	}
	


}