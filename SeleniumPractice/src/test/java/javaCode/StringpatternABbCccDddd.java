package javaCode;

public class StringpatternABbCccDddd {
	public static void main(String arg[])

	{
		System.out.println( "final value is "+accum("ZpglnRxqenU"));
	}
	public static String accum(String s) 
	{
		char chars[]= s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<chars.length;i++)
		{
			for(int j=0;j<=i;j++)
			{
			//	sb.append(chars[i]);

				if(j==0)
				{
					chars[i]=Character.toUpperCase(chars[i]);
					sb.append(chars[i]);
				}
				else
				{
					chars[i]=Character.toLowerCase(chars[i]);
					sb.append(chars[i]);
				}
			}
			if(i<chars.length-1)
			sb.append("-");
		}
		String pattern =  sb.toString();
	//	pattern = pattern.substring(0, pattern.length()-1);
		return pattern;
	}
}
