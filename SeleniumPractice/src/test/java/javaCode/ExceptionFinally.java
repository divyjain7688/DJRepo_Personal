package javaCode;

import javax.management.RuntimeErrorException;

import org.apache.commons.lang.NullArgumentException;

public class ExceptionFinally {
	static int i=6;
	public static void main(String ard[])
	{
		
		System.out.println(testMethod());
		
	}	
		public static int testMethod()
		{
			try 
			{	
				throw new NullArgumentException(null);
			}
			catch(Exception e)
			{
				i=10;
		//		System.exit(0);
				return i;
			}
			finally
			{
				System.out.println("I am in finally block");
			}
		}
	

}




//finally value will be executed then catch will return value to calling method