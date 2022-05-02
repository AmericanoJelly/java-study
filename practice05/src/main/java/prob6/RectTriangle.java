package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle(int i, int j) {

	}

	@Override
	public double Area() {
		double result = width*height/2;
		return result;
		
	}

	@Override
	public double Perimeter() {
		double result = width + height + Math.sqrt((width*width) + (height*height));
		return result;
		
	}


	
}
