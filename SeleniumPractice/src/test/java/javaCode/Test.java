package javaCode;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String arg[])
	{
		String str = "Prashant";
		
		countChar(str);
	}
	
	public static void countChar(String str)
	{
		
		char[] letters = str.toCharArray();
		Map<Character,Integer> values = new HashMap<Character,Integer>();
		for(int i=0;i<letters.length;i++)
		{
			if(values.containsKey(letters[i]))
			{
				values.put(letters[i], values.get(letters[i])+1);
			}
			else
			{
				values.put(letters[i], 1);
			}
		}
		
		for(Map.Entry<Character, Integer> value : values.entrySet())
		{
			//System.out.println(String.valueOf(value.getKey()) +" is occuring " + value.getValue());
			System.out.println((value.getKey()) +" is occuring " + value.getValue());

		}
		
	}

}
