package chapter04;

public class ObjetTest01 {

	public static void main(String[] args) {
		Point p = new Point(10,10);
		
		/*
		 * Class klass = p.getClass(); 
		 * System.out.println(p.getClass(klass.getName()));
		 */
		System.out.println(p.getClass().getName());
		System.out.println(p.hashCode()); //address 기반의 해싱값
										  //address x	reference x
		
		System.out.println(p.toString()); //getClass() + "@" + hashCode()
		System.out.println(p); 

	}

}
