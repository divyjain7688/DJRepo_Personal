package javaCode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class testApi {

	
	public static void main(String arg[]) throws IOException
	{
		
		URL u = new URL ( "http://www.livemint.com/");
		HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
		huc.setRequestMethod ("GET");
		huc.connect () ; 
		int code = huc.getResponseCode() ;
		System.out.println(code);   
	}
}
