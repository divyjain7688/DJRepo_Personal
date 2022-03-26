package javaCode;

public class StringPatterna4bc2zy {
	/*
	 * Input: a4bc2zy 
	 * Ouput: aaaabcbczy
	 */

	public static void main(String arg[])
	{
		String str = "a4bc2zy";
		StringPatterna4bc2zy sm = new StringPatterna4bc2zy();
		sm.stringUpdate(str);
	}

	public void stringUpdate(String str)
	{
		String s= "";
		char ch[] = str.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			if(Character.isDigit(ch[i]))
			{
				int number = Character.getNumericValue(ch[i]);
				while(number >0)
				{
					System.out.print(s);

					number--;
				}
				s="";
			}
			else
			{
				s=s+ch[i];
			}

		}
		System.out.print(s);


	}
}
