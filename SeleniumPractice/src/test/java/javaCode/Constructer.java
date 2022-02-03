package javaCode;
/*package Basics;

public class Constructer {
	 int id;  
	    String name;  
	    int age;  
	Constructer(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	Constructer(int id,String name,int age)
	{
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
    void display(){System.out.println(id+" "+name+" "+age);}  

    public static void main(String args[])
    {
    	Constructer c1 = new Constructer(111,"divy");
    	Constructer c2 = new Constructer(112,"aaru",26);
    	
    	c1.display();
    	c2.display();
    }

}
111 divy 0
112 aaru 26
*/





/*package Basics;

public class Constructer {
	 int id;  
	    String name;  
	    int age;  
	Constructer(int id,String name,int age)
	{
		this.id=id;
		this.name=name;
		this.age= age;
	}
	Constructer(Constructer b)
	{
		this.id=b.id;
		this.name=b.name;
		this.age=b.age;
	}
	
    void display(){System.out.println(id+" "+name+" "+age);}  

    public static void main(String args[])
    {
    	Constructer c1 = new Constructer(111,"divy",29);
    	Constructer c2 = new Constructer(c1);
    	
    	c1.display();
    	c2.display();
    }

}
111 divy 29
111 divy 29*/






/*package Basics;

public class Constructer {
	 int id;  
	    String name;  
	    int age;  
	Constructer(int id,String name,int age)
	{
		this.id=id;
		this.name=name;
		this.age= age;
	}
	Constructer(Constructer b)
	{
		this.id=b.id;
		this.name=b.name;
		this.age=b.age;
	}
	
    void display(){System.out.println(id+" "+name+" "+age);}  

    public static void main(String args[])
    {
    	Constructer c1 = new Constructer(111,"divy",29);
    	Constructer c2 = new Constructer(c1);
    	
    	c1.display();
    	c2.display();
    }

}
111 divy 29
111 divy 29
*/












public class Constructer {
	 int id;  
	    String name;  
	    int age;  
		Constructer(){};

	Constructer(int id,String name,int age)
	{
		this.id=id;
		this.name=name;
		this.age= age;
	}

	
    void display(){System.out.println(id+" "+name+" "+age);}  

    public static void main(String args[])
    {
    	Constructer c1 = new Constructer(111,"divy",29);
    	Constructer c2 = new Constructer();
    	c2.id=c1.id;
    	c2.name=c1.name;
    	c2.age=c1.age;
    	
    	c1.display();
    	c2.display();
    }

}
/*111 divy 29
111 divy 29
*/