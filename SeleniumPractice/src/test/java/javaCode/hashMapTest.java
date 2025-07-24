package javaCode;

import java.util.HashMap;
import java.util.Map;

public class hashMapTest {
	public static void main(String arg[])
	{
		Map<String,String> m1 = new HashMap<String, String>();
		m1.put("a","test1");
		m1.put("b","test2");
		System.err.println(m1);

		for(String key : m1.keySet())
		{
			System.out.println(key);
			System.out.println(m1.get(key));

		}
		
		for(Map.Entry<String, String> kv : m1.entrySet())
		{
			System.out.println(kv.getKey());
			System.out.println(kv.getValue());
			
		}
		
		
	}


}
