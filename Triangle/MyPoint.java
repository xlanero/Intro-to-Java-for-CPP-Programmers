import java.lang.Math;

public class MyPoint {
	
	//data fields x and y represent coordinates
	private double x;
	private double y;
	
	//get method for X coordinate
	public double getX() {
		return this.x;
	}
	
	//get method for Y coordinate
	public double getY() {
		return this.y;
	}
	
	//no argument constructor, creates point (0,0)
	public MyPoint() {
		this.x = 0;
		this.y = 0;
	}
	
	//constructor for specific coordinates
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	double distance(MyPoint obj) {
		return obj.distance(this.x, this.y);
	}

	//returns distance from this point to another point
	//with specified x and y coordinates
	public double distance(double otherX, double otherY) {
		return Math.sqrt(((this.y - otherY) * (this.y - otherY)) + ((this.x - otherX) * (this.x - otherX)));
	}
	
	
}
