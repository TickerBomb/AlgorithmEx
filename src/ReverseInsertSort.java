import java.util.TreeSet;


public class ReverseInsertSort {
	
	private int[] result;
	private int[] input;
	
	private TreeSet<Integer> treeSet;
	
	public ReverseInsertSort(int[] input) {
		this.input = input;
		
		treeSet = new TreeSet();
		for(int i = 0; i < input.length; i++) {
			treeSet.add(input[i]);
		}
	}
	
	public void solve() {
		
	}

}
