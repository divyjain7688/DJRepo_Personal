package JavaCode;


 public class atest{  
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
		   String s= "Divyjain";
		  System.out.println(s.split("/")[0]);
	   } 
		  public static void main(String arg[])
		  {
		  char ch = 'a';
		  String.valueOf(ch);
		  System.out.println(ch+" "+ String.valueOf(ch));
		  
		  
		  int num = 1234; 

		  String s = Integer.toString(num); 

		  int[] intArray = new int[s.length()]; 


		  for(int i=0; i<s.length(); i++){
		      intArray[i] = Character.getNumericValue(s.charAt(i));
		  }
		  System.out.println(intArray);
		  
		//  System.out.println(q);
		  }
	   }
	