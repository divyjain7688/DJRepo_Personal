package javaCode;

public class RemoveMultipleSpaces {

	public static void main(String arg[])
	{
		String s = "   india    has good chance      fo    winning wc";
		System.out.println("s before updates is  -->" + s);
		s=s.replaceAll("() +", " ");
		System.out.println("s after updates is  -->" + s);


		String s1 = "   india    has good chance      fo    winning wc";
		System.out.println("s1 before updates is  -->" + s1);
		s1=s1.replaceAll("\\s+", " ");
		System.out.println("s1 after updates is  -->" + s1);

		


		//remove spaces without replace using SB
		String str1 = "Saket Saurav        is an Autom ation Engi ne      er";
		char[] chars = str1.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++)
		{

			if( (chars[i] != ' ') && (chars[i] != '\t') )

			{

				sb.append(chars[i]);

			}

		}

		System.out.println(sb);
		System.out.println(sb.toString());
	}
}


