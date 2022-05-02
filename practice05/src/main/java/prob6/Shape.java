package prob6;

public abstract class Shape {
	private double Area;
	private double Perimeter;
	
	public abstract double Area();
	public abstract double Perimeter();
	
	public double getArea() {
		return Area;
	}
	public void setArea(double area) {
		Area = area;
	}
	public double getPerimeter() {
		return Perimeter;
	}
	public void setPerimeter(double perimeter) {
		Perimeter = perimeter;
	}
	
}
