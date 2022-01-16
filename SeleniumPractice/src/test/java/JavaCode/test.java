package JavaCode;
import java.util.ArrayList;
import java.util.HashMap;

public class test {
public static void main(String arg[])
{
	HashMap<String,Integer> map = new HashMap<String,Integer>();
	map.put("test", 1);
	map.put("test", 5);
	map.put("testing", null);
	map.put("testing dj", null);
	map.put("test dj", 5);

	System.out.println(map);
	String str = "  India   will      win  the wc 2019 ;";
	System.out.println("str is "+ str);

	str=str.replace(" +", " ");
	System.out.println("str is "+ str);
	}

}

	       /* int i = 20;
	        List<> iList = new ArrayList<>();
	        iList.add(1);
	        iList.add(2);
	        iList.add(3);
	        iList.add(4);

	        iList.forEach(ivar -> {
	            i = ivar;
	        });
	        System.out.println(i);
	    }
	}*/
	

