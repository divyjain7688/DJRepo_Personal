package javaCode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

	public static void main(String arg[]) {
		
		try {
			//Current date to dd-mm-yyyy

			DateFormat fromFormate = new SimpleDateFormat("ddmmyy");

			String dateToFormate = "20161205"; //or 
			Date d=fromFormate.parse(dateToFormate);

			System.out.println("Date is " + d);
			} catch (Exception e) {
			System.out.println("Exception :" + e);
			}
		

}
}