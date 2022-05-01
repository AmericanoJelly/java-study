package prob2;

public class SmartPhone extends Phone {

	public void execute( String function ) {
		if("앱".equals(function)) {
			App();
			return;
		}else if ("음악".equals(function)) {
			playMusic();
			return;
		}
		super.execute(function);
	}
	
	
	private void App(){
		System.out.println( "앱실행" );
	}
	
	protected void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
}
