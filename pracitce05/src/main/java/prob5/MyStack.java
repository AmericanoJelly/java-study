package prob5;

public class MyStack {
	private int top = 0;
	private String[] buffer;
	
	public MyStack(int size) {
		buffer = new String[size];
	}

	public void push(String item) {
		buffer[++top] = item;
	}

	public String pop() throws MyStackException{
		if(top == 0) {
			throw new MyStackException();
			}
		String item = buffer[top];
		buffer[top] = null;
		top--;
		return item;
	}
	
	public boolean isEmpty() {		
		return (top == 0);
	}
	
	
}