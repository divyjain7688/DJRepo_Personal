package udemyApiTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class testUrl {
	
	public static void main(String arg[]) throws IOException
	{
		
		URL u = new URL ( "http://www.google.com/");
		HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
		huc.setRequestMethod ("GET");
		huc.connect () ; 
		int code = huc.getResponseCode() ;
		System.out.println(code);   
	}


}
