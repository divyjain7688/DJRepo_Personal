package javaCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArrayListInMap {
	
	public static void main(String arg[])

	{
		
		Integer key = 5;
		ArrayList<String> values = new ArrayList<String>();
		
		values.add("QA ");
		values.add("automation ");
		values.add("100 ");
		
		Map<Integer,ArrayList<String>> test = new HashMap<Integer,ArrayList<String>>();
		test.put(key,values);
		
		for(Map.Entry<Integer,ArrayList<String>> t : test.entrySet())
		{
			System.out.println(t.getKey());
			System.out.println(t.getValue());
		}
		
	}
}
