package javaCode;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUpdate {   
    @Test
    public void test() {
      	assertEquals(strUpdate("ZpglnRxqenU"),  "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");
      assertEquals(strUpdate("NyffsG"),  "N-Yy-Fff-Ffff-Sssss-Gggggg");
      
       }


    
    public static String strUpdate(String s) {
		char chars[]= s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<chars.length;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(j==0)
				{
					sb.append(Character.toUpperCase(chars[i]));
				}
				else
				{
					sb.append(Character.toLowerCase(chars[i]));
				}
			}
			sb.append("-");
		}
		String pattern =  sb.toString();
		pattern = pattern.substring(0, pattern.length()-1);
      		System.out.println("pattern is "+pattern );

		return pattern;
	
    }
    }
