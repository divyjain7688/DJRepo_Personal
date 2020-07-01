/*package JavaCode;

interface Printable{  
void print();  
default void Defprint()
{
	System.out.println("Defprint");
	}
}  


interface Showable extends Printable{  
void show(); 
default void Defshow()
{
	System.out.println("Defshow");
	}
}  


class TestInterface implements Showable,Printable{  
public void print(){System.out.println("print");}  
public void show(){System.out.println("show");}  
public void Defprint(){System.out.println("child Defprint");}  
public void Defshow(){System.out.println("chjild Defshow");}  
}

public class Interface {
	public static void main(String arg[])
	{
		Printable p = new TestInterface();
		Showable s = new TestInterface();
		p.print();
		p.Defprint();
		s.print();
		s.show();
		s.Defprint();
		
		
	}

}

print
child Defprint
print
show
child Defprint
*/