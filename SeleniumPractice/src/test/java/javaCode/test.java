package javaCode;

public class test {
	
	public static void main(String arg[])
	{
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
