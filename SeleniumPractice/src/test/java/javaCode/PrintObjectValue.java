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
		System.out.println(p.toString());
	}
	
	public String toString()
	{
		return "testing";
	}

}
