import java.lang.Math;
import java.awt.geom.Line2D;

public class Triangle2D {
	MyPoint p1;
	MyPoint p2;
	MyPoint p3;
		
	
	//getter and setter methods for p1,p2,p3
	public MyPoint getP1() {
		return this.p1;
	}
	
	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}
	
	public MyPoint getP2() {
		return this.p2;
	}
	
	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}
	
	public MyPoint getP3() {
		return this.p3;
	}
	
	public void setP3(MyPoint p3) {
		this.p3 = p3;
	}
	
	//no arg constructor, sets to default x,y coordinates
	public Triangle2D() {
		this.p1 = new MyPoint(0, 0);
		this.p2 = new MyPoint(1, 1);
		this.p3 = new MyPoint(2, 5);
	}
	
	//constructor that creates triangle with specified points
	public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
		setP1(p1);
		setP2(p2);
		setP3(p3);
	}
	
	//returns area of triangle
	public double getArea() {
		
		double side1 = p1.distance(p2);
		double side2 = p2.distance(p3);
		double side3 = p3.distance(p1);
		
		double s = ((side1 + side2 + side3) / 2);
        return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
       
	}
	
	//returns perimeter of triangle
	public double getPerimeter() {
		double side1 = p1.distance(p2);
		double side2 = p2.distance(p3);
		double side3 = p3.distance(p1);
		
		return side1 + side2 + side3;
	}
	
	//returns true with specified point p is inside this triangle
	public boolean contains(MyPoint p) {
	
		Triangle2D t1 = new Triangle2D(p1, p2, p);
		Triangle2D t2 = new Triangle2D(p2, p3, p);
		Triangle2D t3 = new Triangle2D(p1, p3, p);
		
		double area = this.getArea();
		double a1 = t1.getArea();
		double a2 = t2.getArea();
		double a3 = t3.getArea();
		double area2 = a1 + a2 + a3;
		
		return Math.round(area2) == Math.round(area);
		
	}
	
	//returns true if specified triangle is inside this triangle
	public boolean contains(Triangle2D t) {
		boolean fullTriangleInside = false;
		
		boolean p1Inside = this.contains(t.p1);
		boolean p2Inside = this.contains(t.p2);
		boolean p3Inside = this.contains(t.p3);
		
		//if all three points are inside the triangle, then triangle t is in the triangle
		if (p1Inside && p2Inside && p3Inside) {
			fullTriangleInside = true;
		}
		
		return fullTriangleInside;
		
	}
	
	//returns true if specified triangle overlaps with this triangle
	public boolean overlaps(Triangle2D t) {
		//This function takes each side of the triangle and compares with each side of the passed in Triangle2D tri, looking for intersecting points
		//returns true if any of the lines overlap
		
		boolean triangleOverlaps = false;
		
		//checks side 1 of triangle with all sides of other triangle
		boolean compare1 = Line2D.linesIntersect(p1.getX(), p1.getY(),p2.getX(),p2.getY(),t.p1.getX(), t.p1.getY(),t.p2.getX(),t.p2.getY());
		boolean compare2 = Line2D.linesIntersect(p1.getX(), p1.getY(),p2.getX(),p2.getY(),t.p3.getX(), t.p3.getY(),t.p2.getX(),t.p2.getY());
		boolean compare3 = Line2D.linesIntersect(p1.getX(), p1.getY(),p2.getX(),p2.getY(),t.p1.getX(), t.p1.getY(),t.p3.getX(),t.p3.getY());
		
		//checks side 2 of triangle with all sides of other triangle
		boolean compare4 = Line2D.linesIntersect(p3.getX(), p3.getY(),p2.getX(),p2.getY(),t.p1.getX(), t.p1.getY(),t.p2.getX(),t.p2.getY());
		boolean compare5 = Line2D.linesIntersect(p3.getX(), p3.getY(),p2.getX(),p2.getY(),t.p3.getX(), t.p3.getY(),t.p2.getX(),t.p2.getY());
		boolean compare6 = Line2D.linesIntersect(p3.getX(), p3.getY(),p2.getX(),p2.getY(),t.p1.getX(), t.p1.getY(),t.p3.getX(),t.p3.getY());
	
	 	//checks side 3 of triangle with all sides of other triangle
		boolean compare7 = Line2D.linesIntersect(p3.getX(), p3.getY(),p1.getX(),p1.getY(),t.p1.getX(), t.p1.getY(),t.p2.getX(),t.p2.getY());
		boolean compare8 = Line2D.linesIntersect(p3.getX(), p3.getY(),p1.getX(),p1.getY(),t.p3.getX(), t.p3.getY(),t.p2.getX(),t.p2.getY());
		boolean compare9 = Line2D.linesIntersect(p3.getX(), p3.getY(),p1.getX(),p1.getY(),t.p1.getX(), t.p1.getY(),t.p3.getX(),t.p3.getY());
		
		
		if(compare1 || compare2 || compare3 || compare4 || compare5 || compare6 || compare7 ||compare8 || compare9) {
			triangleOverlaps = true;
		}
		return triangleOverlaps;
		
	}
}
