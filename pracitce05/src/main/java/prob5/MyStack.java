package prob5;

public class MyStack {
	private int top = 0;
	private String[] buffer;
	
	public MyStack(int size) {
		buffer = new String[size];
	}
	
	public void push(String item) {
		this.buffer[0] = item;
	}
	
	public String pop() {
		return null;
	}
	
	public boolean isEmpty() {
		return false;
	}
	

}