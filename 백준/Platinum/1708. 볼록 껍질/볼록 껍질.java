import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Main {
	
	private static class Point {
		long x;
		long y;
		
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static Point[] points;
	private static Point root;
	private static int N;
	
	public static void main(String[] args) throws Exception {
		N = read();
		points = new Point[N];
		root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
		
		for (int i = 0; i < N; i++) {
			points[i] = new Point(read(), read());
		}
		
		System.out.print(grahamScan());
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean isNegative = n == 13;
		
		if (isNegative) {
			n = System.in.read() & 15;
		}
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return isNegative ? ~n + 1 : n;
	}
	
	private static int grahamScan() {
		for (int i = 0; i < N; i++) {
			if (points[i].y < root.y) {
				root = points[i];
				
			} else if (points[i].y == root.y) {
				if (points[i].x < root.x) {
					root = points[i];
				}
			}
		}
		
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				int result = ccw(root, p1, p2);
				
				if (result > 0) {
					return -1;
					
				} else if (result < 0) {
					return 1;
					
				} else {
					long dist1 = distance(root, p1);
					long dist2 = distance(root, p2);
					
					if (dist1 > dist2) {
						return 1;
					}
				}
				
				return -1;
			}
		});
		
		Stack<Point> stack = new Stack<>();
		stack.add(root);
		
		for (int i = 1; i < N; i++) {
			while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points[i]) <= 0)) {
				stack.pop();
			}
			
			stack.add(points[i]);
		}
		
		return stack.size();
	}
	
	private static int ccw(Point a, Point b, Point c) {
		long result = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
		
		if (result > 0) {
			return 1;
		}
		
		if (result < 0) {
			return -1;
		}
		
		return 0;
	}
	
	private static long distance(Point a, Point b) {
		return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y);
	}
}
