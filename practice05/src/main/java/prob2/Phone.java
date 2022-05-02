package prob2;

public class Phone {

	public void execute( String function ) {
		if("통화".equals(function)) {
			call();
			return;
		}
		
	}
	
	private void call(){
		System.out.println( "통화기능시작" );
	}

}
