package JavaCode;
import java.util.Stack;

public class balanceParan {

	public static void main(String arg[])
	{
		Boolean f = validParentheses("(())()(()(((())))))(())()(");
		System.out.println("falg is "+ f);
	}

	public  static boolean validParentheses( String braces ) 
	{
		int right=0;
		int left=0;
		//Stack<Boolean> STACK = new Stack<Boolean>()
		char brace[] = braces.toCharArray();
		for(int i=0;i<brace.length;i++)
		{
			if(brace[i]=='(')
			{
				right++;
			}
			else
			{
				left++;
			}
		}
		if(right==left)
			return true;
		else
			return false;
	}
}


