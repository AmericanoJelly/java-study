package prob3;

public class Prob2 {
	public static void main(String[] args) {
		Bird bird01 = new Duck();
		bird01.setName( "꽥꽥" );
		bird01.fly();
		bird01.sing();
		bird01.toString();
		
		Bird bird02 = new Sparrow();
		bird02.setName( "짹짹" );
		bird02.fly();
		bird02.sing();
		bird02.toString();
		
	}
}
