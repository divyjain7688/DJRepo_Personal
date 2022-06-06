package javaCode;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class BackbaseString {

	@Test
	public void shouldInvert() {
		 String inverted = BackbaseString.invert("");
	        Assert.assertEquals(inverted,"");
	        inverted = BackbaseString.invert(null);
	        Assert.assertEquals(inverted,"");
	        inverted = BackbaseString.invert("a");
	        Assert.assertEquals(inverted,"a");
	        inverted = BackbaseString.invert("abc");
	        Assert.assertEquals(inverted,"cba");
	        StringBuilder invert = new StringBuilder();
System.out.println("invert--   "+ invert);
String st = "p";
st="e";
System.out.println(st);
	}

	public static String invert(String str) {
		StringBuilder invert = new StringBuilder();
        if( str=="")
            invert.append("");
        else if(str==null)
            invert.append("");
        else  if(str.length()==1)
            invert.append(str);
        else  if(str.length()>1)
        {
            char s[]=str.toCharArray();
            for(int i=s.length-1;i>=0;i--)
		    {
			invert.append(s[i]);
		    }
        }
		return invert.toString();
    }

}
