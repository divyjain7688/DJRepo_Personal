package javaCode;


public class ATest{  
	int q=10;
	static void validate(int age){  
		//	     if(age<18)  
		//	      throw new NullPointerException("not valid");  
		//	
		//	     else  
		//	      System.out.println("welcome to vote");  
		//	   }  
		//	   public static void main(String args[]){  
		//	      validate(13);  
		//	      System.out.println("rest of the code...");  
		//	  }  

	} 
	public static void main(String arg[])
	{
		int m =90;
	
		System.out.println("String value is - "+ Integer.toString(m));
		String s =Integer.toString(m);
		int[] arr = new int[s.length()]; 

		for(int i=0; i<s.length(); i++){
			arr[i] = s.charAt(i);//Character.getNumericValue(s.charAt(i));
			System.out.println(arr[i]);
		}
		 s = "testing";
		s = "Divyjain";
		System.out.println(s.concat("test"));
		System.out.println(s.split("/")[0]);

		

		char ch = 'a';
		String.valueOf(ch);
		System.out.println(ch+" "+ String.valueOf(ch));

		int num = 1234; 

		s = Integer.toString(num); 

		int[] intArray = new int[s.length()]; 


		for(int i=0; i<s.length(); i++){
			intArray[i] = Character.getNumericValue(s.charAt(i));
			System.out.println(intArray[i]);
		}
		System.out.println(intArray);

		//  System.out.println(q);

		String dj = "test";
		String dj1 = "test";
		System.out.println("dj "+ dj +" and dj1 "+ dj1);
		dj.concat("qa");
		System.out.println("dj "+ dj +" and dj1 "+ dj1);
	}
}
