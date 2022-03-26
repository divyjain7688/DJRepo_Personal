package javaCode;

public class Stringbuffer {
	 public static String concatwithString()
	 {
		 
		 String t = "java";
	     for (int i=0; i<10000; i++) 
		 {
			 t = t + "learning";
		 }
		 return t;
	 }
	 
	 
	 public static String concatwithStringBuffer()
	 {
		 
		 StringBuffer t = new StringBuffer("java");
	     for (int i=0; i<10000; i++) 
		 {
			t.append("learning");
		 }
		 return t.toString();
	 }
	 
	 public static String concatwithStringBuilder()
	 {
		 
		 StringBuilder t = new StringBuilder("java");
	     for (int i=0; i<10000; i++) 
		 {
			t.append("learning");
		 }
		 return t.toString();
	 }
	 public static void main(String arg[])
	 {
		 long starttime1 = System.currentTimeMillis();
		 String concatwithString = concatwithString();
		 long timetaken = System.currentTimeMillis() - starttime1;
		 System.out.println(timetaken);
		 
		 long starttime2 = System.currentTimeMillis();
		 String concatwithStringBuffer = concatwithStringBuffer();
		 long timetaken2 = System.currentTimeMillis() - starttime2;
		 System.out.println(timetaken2);
		 
		 long starttime3 = System.currentTimeMillis();
		 String concatwithStringBuilder = concatwithStringBuilder();
		 long timetaken3 = System.currentTimeMillis() - starttime3;
		 System.out.println(timetaken3);
	 }

	 }

	 

/*
436
1
0
*/