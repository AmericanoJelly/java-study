package prob6;

public class Rectangle extends Shape implements Resizable{
	private double width;
	private double height;
	
	public Rectangle(int i, int j) {
	
	}

	@Override
	public double Area() {
		double result = width*height;
		return result;
		
	}

	@Override
	public double Perimeter() {
		
		double result = (width*height)*2;
		return result;
	}

	@Override
	public void resize(double s) {
		width = width*s;
		height = height*s;
		
	}

}
