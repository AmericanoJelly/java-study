package prob01;

public class Printer {

	public int num;
	public boolean b;
	public double score;
	public String name;

	/*
	 * public Printer() {
	 * 
	 * }
	 * 
	 * public Printer(int num,boolean b,double d,String name) { this.num = num;
	 * this.b = b; this.score = d; this.name = name; }
	 * 
	 * 
	 * public int getNum() { return num; }
	 * 
	 * public void setNum(int num) { this.num = num; }
	 * 
	 * public boolean isB() { return b; }
	 * 
	 * public void setB(boolean b) { this.b = b; }
	 * 
	 * public double getScore() { return score; }
	 * 
	 * public void setScore(double score) { this.score = score; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public void println() { System.out.println(num); System.out.println(b);
	 * System.out.println(score); System.out.println(name); }
	 * 
	 */
	
	//제너릭 메소드
	/*
	 * public <T> void println(T t) { System.out.println(t); }
	 */
	//가변파라미터 !제너릭메소드
	public int sum(int... nums) {
		int sum = 0;
		for(int n : nums) {
			sum += n;
		}
		return sum;
	}
	
	//제너릭 + 가변파라미터
	public <T> void println(T... ts) {
		for(T t: ts) {
		System.out.print(t + " ");
		}
		System.out.println("");
	}
	


}
