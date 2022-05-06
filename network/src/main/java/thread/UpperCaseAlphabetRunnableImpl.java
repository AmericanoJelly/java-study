package thread;

//일반 클래스 UpperCaseAlphabetRunnableImpl 스레드의 특성을 가지고있지않다.
public class UpperCaseAlphabetRunnableImpl extends UpperCaseAlphabet implements Runnable {

	@Override
	public void run() {
		print();
	}

}
