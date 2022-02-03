package javaCode;

public class LargestAndSmallestWordInString{

	String largestWord,smallestWord ="";
	int largestWorgLength=0;
	int smallestWordLength=Integer.MAX_VALUE;

	public  void  findWords(String str) {
		String word[] = str.split(" ");
		for(int i=0;i<word.length-1;i++)
		{
			if(largestWorgLength<word[i].length())
			{
				largestWord =word[i];
				largestWorgLength=word[i].length();
			}
			if(smallestWordLength>word[i].length())
			{
				smallestWord =word[i];
				smallestWordLength=word[i].length();
			}
		}
		System.out.println("largestWord is "+ largestWord+ " and its length is "+ largestWorgLength);
		System.out.println("smallestWord is "+ smallestWord+ " and its length is "+ smallestWordLength);

	}

	public static void main(String arg[])
	{
		String input = "This problem is solved at Algorithms tutorial horizon";
		LargestAndSmallestWordInString t = new LargestAndSmallestWordInString();
		t.findWords(input);
	}
}
