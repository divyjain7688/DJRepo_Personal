package JavaCode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class collectioncode {

	public static void main(String arg[])
	{

		HashMap<Integer,String> hashmap = new HashMap<Integer,String>();
		hashmap.put(22,"A");
		hashmap.put(44,"P");
		hashmap.put(11,"S");
		hashmap.put(55,"null");
		System.out.println("keyset");
		for(int i : hashmap.keySet())
		{
			System.out.println(i+" "+ hashmap.get(i));
		}
		System.out.println("entryset");
		Iterator itr = hashmap.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry obj=(Entry) itr.next();
			System.out.println(obj.getKey());
			System.out.println(obj.getValue());
		}
	}

}
