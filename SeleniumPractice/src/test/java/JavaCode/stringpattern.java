package JavaCode;

public class stringpattern {
	public static void main(String arg[])

	{
		System.out.println( "final value is "+accum("abcd"));
	}
	public static String accum(String s) 
	{
		char chars[]= s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<chars.length;i++)
		{
			for(int j=0;j<=i;j++)
			{
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
			sb.append("-");
		}
		String pattern =  sb.toString();
		pattern = pattern.substring(0, pattern.length()-1);
		return pattern;
	}
}
