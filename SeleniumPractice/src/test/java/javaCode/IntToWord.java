package javaCode;

import java.util.HashMap;
import java.util.Map;

public class IntToWord {

	public static  void main(String arg[])
	{

		int i = 43267;
		char[] digits = Integer.toString(i).toCharArray();
		IntToWord iw = new IntToWord();
		for(int j=0;j<digits.length;j++)
		{
			iw.displayeWordValue(digits[j]);
		}
		
	}

	
	public void displayeWordValue(char d)
	{
		Map<Character,String> intWord = new HashMap();
		intWord.put('0', "zero");
		intWord.put('1', "one");
		intWord.put('2', "two");
		intWord.put('3', "three");
		intWord.put('4', "four");
		intWord.put('5', "five");
		intWord.put('6', "six");
		intWord.put('7', "seven");
		intWord.put('8', "eight");
		intWord.put('9', "nine");
		
		System.out.println(intWord.get(d));
		
		
	}
}
