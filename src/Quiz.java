import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class Quiz {
	
	// 4x4
	
	int mMatrixSize;
	
	ArrayList<Point> mTarget;
	Vertex[][] mGraph;
	
	private Stack<Point> mPath;
	
	public Quiz(int size, ArrayList<Point> target) {
		mMatrixSize = size;
		mGraph = new Vertex[size][size];
		mTarget = target;
		
		mPath = new Stack<Point>();
		
		makeGraph();
	}
	
	private void makeGraph() {
		for(int i = 0; i < mMatrixSize; i++) {
			for(int j = 0; j < mMatrixSize; j++) {
				mGraph[i][j] = new Vertex(i, j);
			}
		}
		
		for(int i = 0; i < mMatrixSize; i++) {
			for(int j = 0; j < mMatrixSize; j++) {
				mGraph[i][j].makeAdjacentList();
			}
		}
	}
	
	private void findPath(Point start, Point end) {
		Vertex v = mGraph[start.x][start.y];
		Vertex target = mGraph[end.x][end.y];
		
		mPath.push(start);
		v.isVisit = true;
		
		// 다 탐색을 한 경우 종료를 한다.  조건은?
		if(mPath.size() == mMatrixSize * mMatrixSize) {
			System.out.println("finded all");
			for(Point path : mPath) {
				System.out.print(path + " ");
			}
			System.out.println("");
			System.out.println("--------------------");
			return;
		}
		
		
		
		
		// 2. 다 탐색을 하지 못한경우
		for(Vertex adj: v.adjacentList) {
		// 2-1. 인접 리스트를 탐색한다.
			if(!adj.isVisit) {	// 탐색하지 않은 정점
				Point adjPoint = new Point(adj.x, adj.y);

				if(adj.isMatch(target.x, target.y)) {	// 찾은 경우
					// 남은 경로를 더  뒤진다.
					int index = mTarget.indexOf(end);
					
					if(++index < mTarget.size()) {
						findPath(end, mTarget.get(index));
						continue;
					}
				}
				findPath(adjPoint, end);
				
				adj.isVisit = false;
				mPath.remove(adjPoint);
			}
		}
		
		
		
		
		
		/**
		if(v.isMatch(end.x, end.y)) {
			System.out.println("find");
			System.out.println("find " + mPath.size());
			
			if(mPath.size() == mMatrixSize * mMatrixSize) {

				for(Point path : mPath) {
					System.out.print(path + " ");
				}
				System.out.println("");
				System.out.println("--------------------");
				return;
			}
		}
		
		v.isVisit = true;
		
		for(Vertex adj: v.adjacentList) {
			if(!adj.isVisit) {
				adj.isVisit = true;
				
				Point adjPoint = new Point(adj.x, adj.y);
				mPath.push(adjPoint);
				
				if(target.isMatch(adj.x, adj.y)) {
					int newIndex = mTarget.indexOf(end);
					newIndex++;
					if(mTarget.size() == newIndex) {
						findPath(end, end);
//						findPath(adjPoint, end);
					}
					else {
						Point newEnd = mTarget.get(newIndex);
						findPath(end, newEnd);
					}
				}
				
				else {
					findPath(adjPoint, end);
				}
				
				mPath.remove(adjPoint);
				adj.isVisit = false;
			}
		}
		**/
	}
	
	public void solve() {
		Point a = mTarget.get(0);
		Point b = mTarget.get(1);
		findPath(a, b);
	}
	
	class Vertex {
		public int x;
		public int y;
		boolean isVisit;
		
		public LinkedList<Vertex> adjacentList;
		
		public Vertex(int x, int y) {
			this.x = x;
			this.y = y;
			adjacentList = new LinkedList<Vertex>();
		}
		
		private void makeAdjacentList() {
			int dx[] = {1, -1, 0, 0};
			int dy[] = {0, 0, 1, -1};
			
			for(int i = 0; i < dx.length; i++) {
				int x = this.x + dx[i];
				int y = this.y + dy[i];
				if(isValidate(x, y)) {
					adjacentList.add(mGraph[x][y]);
				}
			}
		}
		
		public boolean isMatch(int x, int y) {
			if(this.x == x && this.y == y)
				return true;
			
			return false;
		}

		@Override
		public String toString() {
			return "Vertex [x=" + x + ", y=" + y + ", isVisit=" + isVisit
					+ "]";
		}
	}
	
	
	private boolean isValidate(int x, int y) {
		if(x < 0 || y < 0)
			return false;
		
		if(x >= mMatrixSize || y >= mMatrixSize)
			return false;
		
		return true;
	}
	
	public static class Point {
		public int x;
		public int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
}
