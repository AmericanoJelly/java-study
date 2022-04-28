package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		
		  char[] ch = str.toCharArray(); //string을 char형 배열로 바꿔준다.
		  
		    for( int i=0 ; i < ch.length/2 ; i++ ) {
		        char tmp = ch[ i];
		        ch[i] = ch [ch.length-1-i];
		        ch [ch.length-1-i] = tmp;
		    }
		    return(ch);
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}