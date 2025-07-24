package javaCode;

public class RemoveMultipleSpaces {

	public static void main(String arg[])
	{
		String s = "   india    has good chance      fo    winning wc";
		System.out.println("s before updates is  -->" + s);
		s=s.replaceAll("() +", " ");
		System.out.println("s after updates is  -->" + s);
		s=s.replaceAll("()+", " ");
		System.out.println("s after second updates is  -->" + s);


		String s1 = "   india    has good chance      fo    winning wc";
		System.out.println("s1 before updates is  -->" + s1);
		s1=s1.replaceAll("\\s+", " ");
		System.out.println("s1 after updates is  -->" + s1);

		


		//remove spaces without replace using SB
		 String str1 = "Saket Saurav        is an Autom ation Engi ne      er";
	        String[] words = str1.split(" "); // splits on space (can be multiple spaces)
	        StringBuilder sb = new StringBuilder();
	        for (String word : words) {
		        System.out.println("word is "+ word);
	            if (!word.isEmpty()) { // skip extra spaces
	                sb.append(word).append(" ");
	            }
	        }

	        System.out.println("Normalized: " + sb.toString().trim());
	}
}


