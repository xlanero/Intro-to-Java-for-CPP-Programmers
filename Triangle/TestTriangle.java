public class TestTriangle {
	public static void main(String[] args) {
		
		System.out.println("Testing Triangle t1");
		System.out.println("-----------------------------");
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5,2), new MyPoint(4.2,3), new MyPoint(5,3.5));
		
		System.out.println("The area of Triangle t1 is: " + t1.getArea());
		System.out.println("The perimeter of Triangle t1 is: " + t1.getPerimeter());
		System.out.println("t1 contains point status: " + t1.contains(new MyPoint(3,3)));
		System.out.println("t1 contains triangle status: " + t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
		System.out.println("New triangle overlaps t1 status: " + t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4,-3), new MyPoint(2, 6.5))));
		
		System.out.println("\nTesting Triangle t2");
		System.out.println("-----------------------------");
		Triangle2D t2 = new Triangle2D(new MyPoint(0,0), new MyPoint(0, 2), new MyPoint(2, 0));
		
		System.out.println("The area of Triangle t2 is: " + t2.getArea());
		System.out.println("The perimeter of Triangle t2 is: " + t2.getPerimeter());
		System.out.println("t2 contains point status: " + t2.contains(new MyPoint(1,1)));
		System.out.println("t2 contains triangle status: " + t2.contains(new Triangle2D(new MyPoint(4, 5), new MyPoint(10.5, 3.2), new MyPoint(-0.5, -10.5))));
		System.out.println("New triangle overlaps t1 status: " + t2.overlaps(new Triangle2D(new MyPoint(1, 1.7), new MyPoint(-1, 1.7), new MyPoint(0, -3))));
	
	}
}
