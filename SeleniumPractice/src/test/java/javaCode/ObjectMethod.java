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
	
	 @Override public boolean equals(Object obj)
	    {
	 
	        
	        if (this == obj)
	            return true;
	 
	        // checking for two condition:
	        // 1) object is pointing to null
	        // 2) if the objects belong to
	        // same class or not
	        if (obj == null
	            || this.getClass() != obj.getClass())
	            return false;
	 
	  
	 
	        // checking if the two
	        // objects share all the same values
	        ObjectMethod o = (ObjectMethod)obj;
	        return this.name.equals(o.name)
	            && this.age == o.age;
	    }
	



	public static void main(String arg[])
	{
		ObjectMethod O1 = new ObjectMethod("Tod", 21);
		ObjectMethod O2 = new ObjectMethod("Tod", 21);
		
		System.out.println(O2);
		System.out.println(O1);

		System.out.println(O2.equals(O1));
	}
}
