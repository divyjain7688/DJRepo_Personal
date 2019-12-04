package JavaCode;
import java.util.HashMap;

/*public class CountOfEachWordUsingMap {
	public static void main(String arg[])
	{
		String str = "This this is is done by Saket Saket";
		String words[] = str.split(" ");
		System.out.println("words.length is "+ words.length);
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (int i=0; i<words.length; i++) {
			{
				if(map.containsKey(words[i]))
				{
					int count = map.get(words[i]);
					map.put(words[i], count+1);
				}
				else 
				{
					map.put(words[i], 1);

				}
			}
		}
		System.out.println("map is"+ map);


	}
}
words.length is 8
map is{Saket=2, by=1, this=1, This=1, is=2, done=1}
*/




/*

public class CountOfEachWordUsingMap {
	public static void main(String arg[])
	{
		String str = "GeekForGeeksSenorita";
		char ch[] = str.toCharArray();
		System.out.println("char array length is "+ ch.length);
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i=0; i<ch.length; i++) {
			{
				if(map.containsKey(ch[i]))
				{
					int count = map.get(ch[i]);
					map.put(ch[i], count+1);
				}
				else 
				{
					map.put(ch[i], 1);

				}
			}
		}
		System.out.println("map is"+ map);


	}
}
char array length is 20
map is{a=1, r=2, s=1, S=1, t=1, e=5, F=1, G=2, i=1, k=2, n=1, o=2}

*/