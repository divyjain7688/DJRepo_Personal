package javaCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberOfDaysBetweenDates {

	public static void main(String arg[]) throws ParseException
	{


		String dateStart = "21/01/2015 08:29:58";
		String dateStop = "28/01/2015 11:31:48";

		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		d1 = format.parse(dateStart);
		d2 = format.parse(dateStop);

		System.out.println("d1 is "+ d1);
		System.out.println("d2 is "+ d2);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");

	}

}