package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		System.out.println("some code...1");

		try {
			System.out.println("some code...2");
			int result = (1 + 2 + 3) / b;
			System.out.println("some code...3");

		} catch (ArithmeticException e) {
			//예외처리
			//1. 사과
			System.out.println("미안해유");
			//2. 로깅 파일로깅
			System.out.println("error: " + e);
			//3. 정상 종료
			return;
		} finally {
			System.out.println("자원 정리");
		}
		//트라이 캐치 문 밑엔 아무것도 안적는게 좋음
		//System.out.println("some code...4");
	}
}
