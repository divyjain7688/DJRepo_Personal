package javaCode;

public class This {


	int rollno;  
	String name,course;  
	float fee;  
	This(int rollno,String name,String course){  
		this.rollno=rollno;  
		this.name=name;  
		this.course=course;  
	}  
	This(int rollno,String name,String course,float fee){  
		this(rollno,name,course);//reusing constructor  
		this.fee=fee;  
	}  
	void display(){System.out.println(rollno+" "+name+" "+course+" "+fee);}  

	public static void main(String args[]){  
		This s1=new This(111,"ankit","java");  
		This s2=new This(112,"sumit","java",6000f);  
		s1.display();  
		s2.display();  
	}
}