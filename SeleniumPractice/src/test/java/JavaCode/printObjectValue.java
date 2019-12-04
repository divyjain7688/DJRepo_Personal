package JavaCode;

public class printObjectValue {
	
	public void setValue(String s)
	{
		System.out.println("testing is done" + s);
	}
	public static void main(String arg[])
	{
		printObjectValue p = new printObjectValue();
		p.setValue("test");
		System.out.println(p.toString());
	}

}
