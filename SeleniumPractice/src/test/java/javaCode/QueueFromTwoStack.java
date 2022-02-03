package javaCode;

import java.util.Stack;

public class QueueFromTwoStack{

	private Stack<Integer> stack1 = new Stack<Integer>();
	private Stack<Integer> stack2= new Stack<Integer>();

	public void enqueue(int x)
	{
		System.out.println("pushed element is " + stack1.push(x));
	}


	public void dequeue()
	{
		if(stack2.isEmpty())
		{
			if(stack1.empty())
			{
				System.out.println(" Cannot dequeue value. Queue is empty ");
			}
			else
			{
				while(!stack1.isEmpty())
				{
					stack2.push(stack1.pop());
				}
			}
		}
		System.out.println("popped element is " +stack2.pop());
	}

	public Boolean isEmpty()
	{
		if(stack1.isEmpty() && stack2.isEmpty())
			return true;
		else 
			return  false;
	}

	public static void main(String[] args) {
		QueueFromTwoStack qu = new QueueFromTwoStack();
		qu.enqueue(3);
		qu.enqueue(4);
		qu.enqueue(5);
		qu.dequeue();
		qu.enqueue(6);
		qu.enqueue(7);
		qu.dequeue();
		qu.dequeue();
		qu.dequeue();
		qu.dequeue();
		qu.isEmpty();
	}
}

