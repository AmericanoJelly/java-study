package chapter04;

//싱글톤으로 유지하기
//하나의 객체유지
public class MyClass {
	private static MyClass instance = null;
	//외부에서 생성 못하게 한다
	private MyClass() {
		
	}

	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}

}
