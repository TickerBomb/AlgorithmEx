import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.ex.algorithm.dynamic.Boggle;
import com.ex.algorithm.graph.Routing;
import com.ex.algorithm.graph.SortingGame;
import com.ex.algorithm.graph.TopoSort2;
import com.ex.algorithm.graph.WordConnect;
import com.ex.algorithm.test.Barrack;
import com.ex.algorithm.test.EventText;
import com.ex.algorithm.test.Paranoid;
import com.ex.algorithm.test.Picnic;
import com.ex.algorithm.test.RecursionExam;
import com.ex.algorithm.test.Xhaeneung;
import com.ex.algorithm.tree.Heap;
import com.ex.algorithm.tree.NERD;


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
        	String left = getString();
        	String operation = getString();
        	String right = getString();
        	getString();
        	String result = getString();
        	testXhaeneung(left, operation, right, result);
        }
        **/
//		testInvestment();
		testRecursionExam();
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
	
	private static void testPicnic() {
		int[] input = {0, 1, 1, 2, 2, 3, 3, 0, 0, 2, 1, 3};
		Picnic p = new Picnic(4, 6, input);
		p.solve();
		
	}
	
	private static void testBoggle() {
		
		ArrayList<String> input = new ArrayList<String>();
		input.add("URLPM");
		input.add("XPRET");
		input.add("GIAET");
		input.add("XTNZY");
		input.add("XOQRS");
		
		char[][] q = new char[5][];
		
		for(int i = 0; i < input.size(); i++) {
			q[i] = input.get(i).toCharArray();
		}

		Boggle boggle = new Boggle(q, "PRETTY");
		boggle.printInput();
		boggle.solve();
	}
	
	private static void testXhaeneung(String left, String operation, String right, String result) {
		Xhaeneung xe = new Xhaeneung(left, operation, right, result);
		if(xe.solve()) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	
	public static void testRecursionExam() {
		RecursionExam re = new RecursionExam();
//		re.solve();
		re.solve2();
	}
	
	/**
	public static void testInvestment() {
		Investment it = new Investment();
		it.solve();
	}
	**/

	public static void testRouting() {
		Routing rt = new Routing();
		rt.solve();
	}
	
	private static void testBarrack() {
//		int[][] input = {{8, 3}, {7, -4}, {8, 1}, {-2 , 1}, {6, -2}};
		int[][] input = {{8, 3}, {7, -4}, {8, 1}, {-2, 1}, {6, 2}};
		Barrack bk = new Barrack(input);
		bk.solve();
		
	}

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
//		text.add("占쌘듸옙 占쏙옙占�占쏙옙占쏙옙/占심뤄옙/占싻댐옙/청占쌀깍옙/占십극쇽옙占쏙옙/占쏙옙占쏙옙창/창占쏙옙/占쏙옙占쏙옙/占쏙옙占쏙옙占쏙옙摹堅占�AJ5521");
		text.add("[占쏙옙틱占쏙옙占쏙옙]占쏙옙틱책占쏙옙/占승쏙옙占쏙옙퓨占쏙옙책占쏙옙/PC책占쏙옙트/占쏙옙占쏙옙占쏙옙퓨占쏙옙책占쏙옙 GA454-6");
		text.add("占쌩뱄옙占쏙옙占쏙옙/占쏙옙占싸울옙 占쏙옙占쏙옙카占쏙옙蔘占쏙옙遣? 占쏙옙占싱댐옙 占� 占쏙옙占쏙옙카占쏙옙+占쏙옙酉��옙占쌔∽옙");
		text.add("[占식격쇽옙占쏙옙!!]占신억옙 占쌍니억옙 占쌩깍옙占쏙옙 2 (CD 1 + 占쏙옙책 1 占쏙옙占쏙옙)");
		text.add("占쌘듸옙 占쏙옙占�占쏙옙占쏙옙/占심뤄옙/占싻댐옙/청占쌀깍옙/占십극쇽옙占쏙옙/占쏙옙占쏙옙창/창占쏙옙/占쏙옙占쏙옙/占쏙옙占쏙옙占쏙옙摹堅占�AJ5521");
		text.add("[占식격쇽옙占쏙옙!!]占쌘뤄옙占쌓몌옙티 占쏙옙占쏙옙占쏙옙1P/占쌘뤄옙占싹우스/占쏙옙占신걜�");
		text.add("[占식격쇽옙占쏙옙!!]占썅구占쏙옙(102)");
		text.add("[占식격쇽옙占쏙옙!!]FBI 占쏙옙크占쏙옙");
		
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
