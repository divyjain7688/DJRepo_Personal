package javaCode;

interface one{
	
	void a();
	void b();
}

interface two{
	
	void c();
	void b();
}

public class Interfaceprogram implements one,two{
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
		one o = new Interfaceprogram();
		two t = new Interfaceprogram();
		t.b();
		Interfaceprogram i = new Interfaceprogram();
		i.c();
	}
}
