import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.ex.algorithm.graph.SortingGame;
import com.ex.algorithm.graph.TopoSort2;
import com.ex.algorithm.graph.WordConnect;
import com.ex.algorithm.test.EventText;
import com.ex.algorithm.test.Paranoid;
import com.ex.algorithm.tree.Heap;
import com.ex.algorithm.tree.NERD;


public class Main {

	private static BufferedReader reader;
	private static String token;
	private static StringTokenizer st;
	private static String line;

	public static void main(String[] args) {
		reader = new BufferedReader(new InputStreamReader(System.in));

        int cases = 0;
        cases = getInt();
		
        while(cases-- > 0) {
        	int length = getInt();
        	ArrayList<Integer> input = new ArrayList<Integer>(length);
        	for(int i = 0; i < length; i++) {
        		input.add(getInt());
        	}
        	testSortingGame(input);
        }
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

	/**
	public static class SortingGame {

		private ArrayList<Integer> input;
		private Vertex expected;
		private ArrayDeque<Vertex> queue;
		private HashSet<Vertex> hashSet;

		public SortingGame(ArrayList<Integer> input) {
			this.input = input;
			ArrayList<Integer> sortedList;
			Collections.sort(sortedList = new ArrayList<Integer>(input));

			expected = new Vertex(sortedList);

			queue = new ArrayDeque<SortingGame.Vertex>();
			hashSet = new HashSet<Vertex>();
		}

		public void solve() {
			final Vertex v = new Vertex(input);
			queue.add(v);
			hashSet.add(v);

			while(!queue.isEmpty()) {

				if(expected.equals(queue.peek())) {
					Vertex resultVertex = queue.peek();
					System.out.println(resultVertex.depth);

					break;
				}

				Vertex parentVertex = queue.remove();

				ArrayList<Integer> numList = parentVertex.value;
				List<Integer> subList;
				for(int i = 0; i < numList.size(); i++) {
					for(int j = i + 1; j <= numList.size(); j++) {
						subList = numList.subList(i, j);
						subList = new ArrayList<Integer>(subList);
						Collections.reverse(subList);

						ArrayList<Integer> newList = new ArrayList<Integer>();
						newList.addAll(numList.subList(0, i));
						newList.addAll(subList);
						newList.addAll(numList.subList(j, numList.size()));
						int depth = parentVertex.depth;
						Vertex newVertex = new Vertex(newList);
						newVertex.parent = parentVertex;

						if(!hashSet.contains(newVertex)) {
							newVertex.depth = ++depth;
							queue.add(newVertex);
							hashSet.add(newVertex);
						}
					}
				}
			}
		}

		public static class Vertex {
			public Vertex parent;
			public ArrayList<Integer> value;
			public int depth;
			public Vertex(ArrayList<Integer> value) {
				this.value = value;
			}

			@Override
			public String toString() {
				StringBuffer sb = new StringBuffer();
				sb.append("[");
				for(Integer i : value) {
					sb.append(i + " ");
				}
				sb.append("], d: " + depth);
				return sb.toString();
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((value == null) ? 0 : value.get(0) * value.size());
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

				Vertex other = (Vertex) obj;

				for(int i = 0; i < value.size(); i++) {
					if(value.get(i) != other.value.get(i)) {
						return false;
					}
				}

				return true;
			}
		}
	}
	*/
	
	
	public static void testSortingGame(ArrayList<Integer> input) {
		SortingGame sg = new SortingGame(input);
		sg.solve2();
//		sg.solve();
	}
	
	public static void testParanoid() {
		LinkedList<Paranoid.Point> queue = new LinkedList<Paranoid.Point>();
		queue.add(new Paranoid.Point(0, 2, 5));
		queue.add(new Paranoid.Point(2, 4, 15));
		queue.add(new Paranoid.Point(3, 3, 19));
		queue.add(new Paranoid.Point(0, 1, 2));
		queue.add(new Paranoid.Point(3, 0, 16));
		queue.add(new Paranoid.Point(2, 1, 12));
		Paranoid pr = new Paranoid(5, queue);
		pr.solve();
	}
	public static void testEventText() {
		
		ArrayList<String> text = new ArrayList<String>();
//		text.add("핸디 방걸레 리필/걸레/밀대/청소기/초극세사/유리창/창문/세차/좋은집꾸미기/AJ5521");
		text.add("[엔틱가구]엔틱책상/좌식컴퓨터책상/PC책상세트/유선컴퓨터책상 GA454-6");
		text.add("◆무료배송/서인영 마스카라◆메이블린 샤이니 블랙 마스카라+대용량화장솜◆");
		text.add("[파격세일!!]씽씽 주니어 중국어 2 (CD 1 + 별책 1 포함)");
		text.add("핸디 방걸레 리필/걸레/밀대/청소기/초극세사/유리창/창문/세차/좋은집꾸미기/AJ5521");
		text.add("[파격세일!!]코렐그린티 소접시1P/코렐하우스/원더키친 ");
		text.add("[파격세일!!]축구공(102)");
		text.add("[파격세일!!]FBI 시크릿");
		
		EventText et = new EventText(text);
		et.solve();
		
	}
	
	public static void testWordConnect() {
		ArrayList<String> words = new ArrayList<String>();
		words.add("ab");
		words.add("cd");
//		words.add("aa");
//		words.add("ab");
//		words.add("bb");
//		words.add("dog");
//		words.add("god");
//		words.add("dragon");
//		words.add("need");
		WordConnect wc = new WordConnect(words);
		wc.solve();
	}
	
	
	public static void testTopoSort2() {

		/**
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
		
		*/

		ArrayList<TopoSort2.Vertex> vertexes = new ArrayList<TopoSort2.Vertex>();
		
		for(int i = 0; i < 26; i++) {
			vertexes.add(new TopoSort2.Vertex(i + 'a'));
		}
		TopoSort2 ts2 = new TopoSort2(vertexes);
		
		ArrayList<String> words = new ArrayList<String>();
//		words.add("dictionary");
//		words.add("english");
//		words.add("is");
//		words.add("ordered");
//		words.add("ordinary");
//		words.add("this");
		words.add("gg");
		words.add("kia");
		words.add("lotte");
		words.add("lg");
		words.add("hanwha");
//		ts2.makeGraph(words);
		/**
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
		**/
		
		ts2.dfsAll();
		
	}

	/**
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
	**/
	
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
