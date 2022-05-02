package collection;

import java.util.Stack;

public class StactkTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("스펀지밥");
		s.push("뚱이");
		s.push("징징이");
		
		while(!s.isEmpty()) {
			String str = s.pop();
			System.out.println(str);
		}
		System.out.println("-------------");
		//비어있는 경우 예외발생
		//s.pop();
		s.push("스펀지밥");
		s.push("뚱이");
		s.push("징징이");
		
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}

}
