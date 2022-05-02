package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		// String method들..
		String s1 = "aBcABCabcAbc";
		System.out.println(s1.length());
		System.out.println(s1.charAt(2));
		System.out.println(s1.indexOf("abc"));
		System.out.println(s1.indexOf("abc",7));
		System.out.println(s1.substring(3));
		System.out.println(s1.substring(3,5));
		
		String s2 = "  ab  cd  ";
		String s3 = "efg,hij,klm,nop,qrs";
		
		String s4 = s2.concat(s3);
		System.out.println(s4);
		
		System.out.println("-----" + s2.trim() + "-----"); //양쪽끝의 스페이스를 없앰
		System.out.println("-----" + s2.replaceAll(" ","") + "-----"); //모든 스페이스를 없앰
		
		String[] token = s3.split(","); //분리
		for(String s : token) { 		//for each
			System.out.println(s);
		}
		
		String[] tokens2 = s3.split(" "); //분리가 안되더라도 실행된다
		for(String s : tokens2) {
			System.out.println(s);
		}
		
		// +:  String concat(연결)연산자
		//객체는 더할 수 없다, 아래와 같은결과 
		//String s5 = "Hello" + "World" + "Java" + "1.8"; 
		
		//객체 연결할 수 있다
		//StringBuffer은 값을 계속 추가해줄 수 있다.
		String s5 = new StringBuffer("Hello")
			.append("world")
			.append("Java")
			.append("1.8").toString(); 
		
		System.out.println(s5);
		
		String s6 = "";
		for(int i = 0; i < 1000000; i++) {
			//1000000만번 new 메모리많이 차지함
			//s6 = s6 + i;
			//s6 = new StringBuffer(s6).append(i).toString();
		}
		
		StringBuffer sb6 = new StringBuffer("");
		for(int i = 0; i < 1000000; i++) {
			sb6.append(i);
		}
		
		String s7 = sb6.toString();
		System.out.println(s7.length());
		
		
	}

}
