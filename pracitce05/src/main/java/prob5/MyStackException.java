package prob5;

public class MyStackException extends Exception {
	
	public MyStackException(String ex) {
		super("Prob5.MyStackException: stack is empty");
	}

}
