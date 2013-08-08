
public class DrawRect {
	private Point[] points;
	public Point result;
	public DrawRect(Point[] points) {
		this.points = points;
	}

	public static class Point {
		public int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private Point getCenterPoint() {
		for(int i = 0; i < 3; i++) {
			if(points[i].x == points[(i+1) % 3].x) {
				if(points[i].y == points[(i+2) %3].y) {
					return points[i];
				}
			}
			else if(points[i].y == points[(i+1) % 3].y) {
				if(points[i].x == points[(i+2) %3].x) {
					return points[i];
				}
			}
		}
		return null;
	}

	public void solve() {
		result = cal(getCenterPoint());
	}

	private Point cal(Point p) {
		int x = 0;
		int y = 0;
		for(int i = 0; i < 3; i++) {
			if(p.x != points[i].x) {
				x = points[i].x;
			}
			if(p.y != points[i].y) {
				y = points[i].y;
			}
		}
		return new Point(x,y);
	}
}


