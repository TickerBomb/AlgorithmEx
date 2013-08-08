import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

	private static BufferedReader reader;
	private static String token;
	private static StringTokenizer st;
	private static String line;

	public static void main(String[] args) {
		/**
		reader = new BufferedReader(new InputStreamReader(System.in));

        int cases = 0;
        cases = getInt();
		
        while(cases-- > 0) {
//            System.out.println("People, " + people);
        	String input = getString();
        }
        **/
		testTopoSort2();
	}
	
	private static String peekToken() {
		if(token == null) {
			try {
				while(st == null || !st.hasMoreTokens()) {
					line = reader.readLine();
					if(line == null) {
						return null;
					}
					st = new StringTokenizer(line);
				}
				
				token = st.nextToken();
			} catch (IOException e) {
			}
			
		}
		return token;
	}
	
	private static String nextToken() {
		String ans = peekToken();
		token = null;
		return ans;
	}
	
	private static int getInt() {
		return Integer.parseInt(nextToken());
	}

	private static String getString() {
		return nextToken();
	}
	
	
	public static void testTopoSort2() {

		TopoSort2.Vertex v1 = new TopoSort2.Vertex(1);
		TopoSort2.Vertex v2 = new TopoSort2.Vertex(2);
		TopoSort2.Vertex v3 = new TopoSort2.Vertex(3);
		TopoSort2.Vertex v4 = new TopoSort2.Vertex(4);
		TopoSort2.Vertex v5 = new TopoSort2.Vertex(5);
		TopoSort2.Vertex v6 = new TopoSort2.Vertex(6);
		TopoSort2.Vertex v7 = new TopoSort2.Vertex(7);
		TopoSort2.Vertex v8 = new TopoSort2.Vertex(8);
		TopoSort2.Vertex v9 = new TopoSort2.Vertex(9);
		TopoSort2.Vertex v10 = new TopoSort2.Vertex(10);
		
		ArrayList<TopoSort2.Vertex> vertexes = new ArrayList<TopoSort2.Vertex>();
		
		vertexes.add(v1);
		vertexes.add(v2);
		vertexes.add(v3);
		vertexes.add(v4);
		vertexes.add(v5);
		vertexes.add(v6);
		vertexes.add(v7);
		vertexes.add(v8);
		vertexes.add(v9);
		vertexes.add(v10);
		
		TopoSort2 ts2 = new TopoSort2(vertexes);
		ts2.updateAdjacentList(1, 2);
		ts2.updateAdjacentList(2, 3);
		ts2.updateAdjacentList(3, 4);
		ts2.updateAdjacentList(4, 5);
		ts2.updateAdjacentList(6, 7);
		ts2.updateAdjacentList(6, 8);
		ts2.updateAdjacentList(6, 9);
		ts2.updateAdjacentList(7, 1);
		ts2.updateAdjacentList(8, 2);
		ts2.updateAdjacentList(9, 4);
		ts2.updateAdjacentList(10, 3);
		
		ts2.dfsAll();
		
	}
	public static void testTopoSort() {
		
		ArrayList<TopoSort.Vertex> vertexes = new ArrayList<TopoSort.Vertex>();
		
		TopoSort.Vertex v1 = new TopoSort.Vertex("1");
		TopoSort.Vertex v2 = new TopoSort.Vertex("2");
		TopoSort.Vertex v3 = new TopoSort.Vertex("3");
		TopoSort.Vertex v4 = new TopoSort.Vertex("4");
		TopoSort.Vertex v5 = new TopoSort.Vertex("5");
		TopoSort.Vertex v6 = new TopoSort.Vertex("6");
		TopoSort.Vertex v7 = new TopoSort.Vertex("7");
		TopoSort.Vertex v8 = new TopoSort.Vertex("8");
		TopoSort.Vertex v9 = new TopoSort.Vertex("9");
		TopoSort.Vertex v10 = new TopoSort.Vertex("10");
		
		v1.indegree = 1;
		v1.adjacentList.add(v2);
		
		v2.indegree = 2;
		v2.adjacentList.add(v3);
		
		v3.indegree = 2;
		v3.adjacentList.add(v4);
		
		v4.indegree = 2;
		v4.adjacentList.add(v5);
		
		v5.indegree = 1;
		
		v6.indegree = 0;
		v6.adjacentList.add(v7);
		v6.adjacentList.add(v8);
		v6.adjacentList.add(v9);
		
		v7.indegree = 1;
		v7.adjacentList.add(v1);
		
		v8.indegree = 1;
		v8.adjacentList.add(v2);
		
		v9.indegree = 1;
		v9.adjacentList.add(v4);
		
		v10.indegree = 0;
		v10.adjacentList.add(v3);
		
		vertexes.add(v1);
		vertexes.add(v2);
		vertexes.add(v3);
		vertexes.add(v4);
		vertexes.add(v5);
		vertexes.add(v6);
		vertexes.add(v7);
		vertexes.add(v8);
		vertexes.add(v9);
		vertexes.add(v10);

		TopoSort ts = new TopoSort(vertexes);
		List<TopoSort.Vertex> result = ts.solve();
		
		for(TopoSort.Vertex vertex : result) {
			System.out.print(vertex.value + " -> ");
		}
	}
	
	public static void testEncryption(String input) {
		StringEncryption st = new StringEncryption(input);
		System.out.println(st.solve());
	}

	public static void testDrawRect(DrawRect.Point[] p) {
		DrawRect dr = new DrawRect(p);
		dr.solve();
		System.out.println(dr.result.x + " " + dr.result.y);

	}
	
	public static void testHeap(int[] input) {
		Heap heap = new Heap(input);
		System.out.println(heap.solve());
	}
	
	public static void testNERD(int[] p, int[] q) {
		NERD nerd = new NERD(p, q);
		int result = nerd.solve();
		System.out.println(result);
	}
	
	public static void testLIS() {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(3);
		input.add(2);
		input.add(1);
		input.add(7);
		input.add(5);
		input.add(4);
		input.add(2);
		input.add(6);
		LIS lis = new LIS(input);
		
		System.out.println("lis : " + lis.solve());
		
		System.out.println("lis2 : " + lis.solve2());
	}
	
	public static void testQuiz() {
		
		ArrayList<Quiz.Point> pointlist = new ArrayList<Quiz.Point>();
		
		pointlist.add(new Quiz.Point(2, 1));
		pointlist.add(new Quiz.Point(2, 0));
		pointlist.add(new Quiz.Point(0, 0));
//		pointlist.add(new Quiz.Point(1, 4));
//		pointlist.add(new Quiz.Point(0, 1));
//		pointlist.add(new Quiz.Point(1, 2));
		
		Quiz qz = new Quiz(3, pointlist);
		qz.solve();
		
		
	}
	
	public static void testNumeric() {
		ArrayList<String> input = new ArrayList<String>();
		
		input.add("XYZ");
//		input.add("XY");
//		input.add("6PP");
		
//		input.add("A");
//		input.add("B");
//		input.add("10");
		
		Numeric nc = new Numeric(input);
		System.out.println("count : " + nc.getCharCount());
		nc.solve(new ArrayList<Numeric.CharInfo>(), 0);
	}
}
