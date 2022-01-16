package JavaCode;

interface one{
	
	void a();
	void b();
}

interface two{
	
	void c();
	void b();
}

public class interfaceprogram implements one,two{
	public void a()
	{
		
		System.out.println("AA");
	}

	public void b()
	{
		
		System.out.println("BB");
	}
	public void c()
	{
		
		System.out.println("CC");
	}
	
	
	public static void main(String[] arg)
	{
		one o = new interfaceprogram();
		two t = new interfaceprogram();
		t.b();
		interfaceprogram i = new interfaceprogram();
		i.c();
	}
}
