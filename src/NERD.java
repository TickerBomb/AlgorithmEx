import java.util.Map.Entry;
import java.util.TreeMap;


public class NERD {
	
	private final int[] x;
	private final int[] y;
	private TreeMap<Integer, Integer> map;

	public NERD(int[] x, int[] y) {
		this.x = x;
		this.y = y;

		map = new TreeMap<Integer, Integer>();
	}

	public int solve() {

		int sum = 0;

		for(int i = 0 ; i < x.length; i++) {

			if(isDominated(x[i], y[i])) {
				sum += map.size();
//				System.out.println("before continue, sum: " + sum + " ,size: " + map.size());
				continue;
			}

			removeDominated(x[i], y[i]);
			sum += map.size();
//			System.out.println("after remove, sum: " + sum + ", size: " + map.size());
		}

		
//		System.out.println("size: " + map.size());
		return sum;

	}

	public boolean isDominated(int x, int y) {
//		System.out.println("isDominated() x: " + x + ", y: " + y);

		Entry<Integer, Integer> entry = map.higherEntry(x);
		
//		System.out.println("entry: " + entry);

		if(entry != null) {
			int pX = entry.getKey();
			int pY = entry.getValue();

//			System.out.println("pX : " + pX);
//			System.out.println("pY : " + pY);

			if(pY >= y) {
				return true;
			}
		}

		map.put(x, y);

		return false;
	}

	public void removeDominated(int x, int y) {
//		System.out.println("removeDominated() x: " + x + ", y: " + y);

		Entry<Integer, Integer> entry;

		while((entry = map.lowerEntry(x)) != null) {
			if(entry != null) {
				int pX = entry.getKey();
				int pY = entry.getValue();

//				System.out.println("pX : " + pX);
//				System.out.println("pY : " + pY);

				if(pY <= y) {
					map.remove(pX);
				}
				else {
					break;
				}
			}
		}
	}
}
