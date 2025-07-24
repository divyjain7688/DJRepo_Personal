package javaCode;

public class PrintObjectValue {
	
	public void setValue(String s)
	{
		System.out.println("testing is done " + s);
	}
	public static void main(String arg[])
	{
		PrintObjectValue p = new PrintObjectValue();
		p.setValue("test");
		System.out.println(p);
		System.out.println("after to string called");
	}
	
	public String toString()
	{
        return "This is a PrintObjectValue object";
	}

}
