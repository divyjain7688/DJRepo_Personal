package javaCode;

public class ObjectMethod {
	
	private String name;
	private int age;
	
	public ObjectMethod(String name,int age) {
		
		this.age=age;
		this.name=name;
	}
	@Override
	public String toString() {
		return name +" "+ age;
	}
	

	public static void main(String arg[])
	{
		ObjectMethod O1 = new ObjectMethod("Tod", 21);
		ObjectMethod O2 = new ObjectMethod("Tod", 21);
		
		System.out.println(O2);
		System.out.println(O1);

	}
}
