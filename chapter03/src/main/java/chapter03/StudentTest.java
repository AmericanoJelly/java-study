package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		new Student();
		Student s1 = new Student();
		s1.setGrade(1);
		
		Person p1 = s1; 	//upcasting(암시적, Implicity)
		p1.setName("짱구");
		
		Student s2 = (Student)p1;	//downcasting(명시적, Explicity)
		s2.setMajor("cs");
	}

}
