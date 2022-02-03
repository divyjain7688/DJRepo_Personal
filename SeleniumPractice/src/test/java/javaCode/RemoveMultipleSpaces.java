package javaCode;

public class RemoveMultipleSpaces {
	
	public static void main(String arg[])
	{
		String s = "   india    has good chance      fo    winning wc";
		System.out.println("s before updates is  -->" + s);
		s=s.replaceAll("() +", " ");
		System.out.println("s after updates is  -->" + s);
	}
	

}
