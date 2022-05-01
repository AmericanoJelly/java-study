package prob5;

public class MyStackException extends Exception {
	
	public MyStackException() {
		super("Prob5.MyStackException: stack is empty");
	}
	
	public MyStackException(String msg) {
		super(msg);
	}

}
