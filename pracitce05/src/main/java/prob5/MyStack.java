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

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public String[] getBuffer() {
		return buffer;
	}

	public void setBuffer(String[] buffer) {
		this.buffer = buffer;
	}
	

}