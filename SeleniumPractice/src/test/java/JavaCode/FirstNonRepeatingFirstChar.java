package JavaCode;
import java.util.HashMap;

class FirstNonRepeatingFirstChar {
	public static String firstNonRepeatingLetter(String str) {

		if(str.equals(""))
			return "empty string";
		String text = null;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < str.length(); i++) 
		{
			char c = Character.toLowerCase(str.charAt(i));
			if (map.containsKey(c)) 
			{
				map.put(c, map.get(c) + 1); 
			} 
			else { map.put(c, 1); }

		}
		
		for (int i = 0; i < str.length(); i++) 
		{
			char c = Character.toLowerCase(str.charAt(i));
			if (map.get(c)==1) 
			{
				text=  String.valueOf(c);
				break;
			} 
			if (map.get(c)==str.length()) 
			{
				text= "all same";
				break;
			} 
			
		}
		
		return text;

	}
	
	public static void main(String arg[])
	{
		String npc = firstNonRepeatingLetter("");
		System.out.println(npc);
	}

}