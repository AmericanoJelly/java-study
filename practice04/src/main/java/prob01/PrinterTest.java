package prob01;

public class PrinterTest {

	public static void main(String[] args) {
		Printer printer = new Printer();

		printer.setNum( 10 );
		printer.setB( true );
		printer.setScore( 5.7 );
		printer.setName( "홍길동" );
		
		printer.println();
	}
}
