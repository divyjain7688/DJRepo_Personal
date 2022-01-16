package JavaCode;
import java.util.Stack;

public class balanceParan {

	public static void main(String arg[])
	{
		Boolean f = validParentheses("()");
		System.out.println("flag is "+ f);
	}

	public  static boolean validParentheses( String braces ) 
	{
		Stack<Character> stack = new Stack<Character>();
		char brace[] = braces.toCharArray();
		for(int i=0;i<brace.length;i++)
		{
			if(brace[i]=='(' || brace[i]=='{' || brace[i]=='[' )
			{
				stack.push(brace[i]);
			}
			else if(brace[i] == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(brace[i] == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }           
            } else if(brace[i] == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
}


