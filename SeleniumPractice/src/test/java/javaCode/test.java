package javaCode;

import java.util.Random;

public class test {
	
	public static void main(String arg[])
	{
		
		Random r = new Random();
		int low = 80;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		System.out.println("result is "+ result);
		
		String s ="aUtomation";
		String l ="teStinG";
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toUpperCase(s.charAt(0))).append(s.charAt(1)).append(Character.toUpperCase(l.charAt(0))).append(l.charAt(1));
		System.out.println("final result is "+ sb.toString());
		String vowel = "aeiou";
		String str = "divyjain";
		char alphabets[]=str.toCharArray();
		
		for(int i=0;i<alphabets.length;i++)
		{
			if(vowel.contains(Character.toString(alphabets[i])))
			{
				System.out.println(alphabets[i]+ " is vowel");
			}
			else
			{
				System.out.println(alphabets[i]+ " is not vowel");

			}
		}
		
	}
}
