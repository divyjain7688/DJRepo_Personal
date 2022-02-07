package javaCode;


public class Permutation
{

	public static void main(String []args){
		String str="abs";
		permutation(str,"");


	}

	public static void permutation(String str,String ans) { 
		
		if(str.length()==0)
		{
			System.out.println(ans);
			return;
		}
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			String ros = str.substring(0,i)+str.substring(i+1);
			permutation(ros, ans+ch);
		}
	}
}
