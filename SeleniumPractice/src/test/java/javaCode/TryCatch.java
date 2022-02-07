package javaCode;

public class TryCatch {

	public static void validateAge(int i) throws InvalidAgeException
	{
		if(i<18)
		{
			System.out.println("age is "+ i);
			throw new  InvalidAgeException("Age is under 18 for vating");
		}
		else
		{
			System.out.println("User is eligible for vaoting");
		}
	}
		public static void main(String arg[]) throws InvalidAgeException 
	{
		
			validateAge(10);
		
		//		finally {
		//			System.out.println("finally");
		//		}
	}

}