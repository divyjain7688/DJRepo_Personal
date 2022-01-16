package JavaCode;

public class NumberOfWordsInString {

	public static void main(String arg[])
	{
		
		String str = "Automation testing is having good scope in market";
		String words[] = str.split(" ");
		System.out.println("siez is "+ words.length);
		int i=0;
		for (String word:words)
		{
			i++;
		}
		System.out.println("total number of words is "+ i);
	}
}
