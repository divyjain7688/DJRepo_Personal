package tools;

import java.util.Random;

public class GenerateRandomStrings {

	public static String getString(int length) 
	{
		String Str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) 
		{ 
			int index = (int)(Str.length()*Math.random());
			sb.append(Str.charAt(index));

		}
		System.out.println("Str is " + sb);
		return sb.toString();

	}
	
	public static String getNumber(int length) 
	{
		String Int	=  "0123456789";
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) 
		{ 
			int index = (int)(Int.length()*Math.random());
			sb.append(Int.charAt(index));

		}
		System.out.println("Int is " + sb);
		return sb.toString();

	}

}


