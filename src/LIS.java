import java.util.ArrayList;


public class LIS {
	
	private ArrayList<Integer> mInput;
	private ArrayList<Integer> mCache;
	
	public LIS(ArrayList<Integer> input) {
		mInput = input;
		mCache = new ArrayList<Integer>(mInput.size());
		
		for(int i = 0; i < mInput.size(); i++) {
			mCache.add(-1);
		}
	}
	
	public int solve() {
		int longestLength = getLongestLength(mInput);
		return longestLength;
	}
	
	public int solve2() {
		int longestLength = getLongestLength(0, mInput);
		return longestLength;
	}

	private int getLongestLength(ArrayList<Integer> list) {
		if(list.isEmpty())
			return 0;
		
		int maxSize = 0;
		
		
		int comp = 0;
		for(int i = 0; i < list.size(); i++) {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			comp = list.get(i);
			
			for(int j = i + 1; j < list.size(); j++) {
				if(comp < list.get(j)) {
					subList.add(list.get(j));
				}
			}
			
			maxSize = Math.max(maxSize, 1 + getLongestLength(subList));
		}
		
		return maxSize;
	}
	
	private int getLongestLength(int start, final ArrayList<Integer> list) {
		
		int maxSize;
		
		if(mCache.get(start) != -1) {
			System.out.println("Cache hit, index: " + start);
			maxSize = mCache.get(start);
			return maxSize;
		}
		
		
		maxSize = 1;
		
		for(int i = start + 1; i < list.size(); i++) {
			if(list.get(start) < list.get(i)) {
				maxSize = Math.max(maxSize, 1 + getLongestLength(i, list));
				mCache.add(i, maxSize);
			}
		}
		
		return maxSize;
		
	}
}
