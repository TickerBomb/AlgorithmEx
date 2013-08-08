import java.util.ArrayList;


public class Numeric {
	
	
	private ArrayList<String> mInput;
	private ArrayList<CharInfo> mCharInfoList;
	private int mCharSize;
	
	public Numeric(ArrayList<String> input) {
		mInput = input;
		
		mCharInfoList = new ArrayList<CharInfo>();
		
		makeUpCharInfoList();
		mCharSize = mCharInfoList.size();
	}
	
	private void makeUpCharInfoList() {
		
		ArrayList<Character> character = new ArrayList<Character>();
		
		for(String str: mInput) {
			
			for(int i = 0; i < str.length(); i++) {
				Character ch = str.charAt(i);
				
				if(!Character.isDigit(ch)) {
					if(!character.contains(ch)) {
						character.add(ch);
						mCharInfoList.add(new CharInfo(ch));
					}
				}
			}
		}
	}
	
	public void solve(ArrayList<CharInfo> info, int index) {
		if(info.size() == mCharSize) {
			// print
			for(CharInfo ch: info) {
				System.out.print(ch + " ");
			}
			System.out.println("");
			System.out.println("------------------------------------");
			return;
		}
		
		int i = info.size();
		if(i < 0)
			i = 0;
		
		for(i = 0; i < 10; i++) {
			mCharInfoList.get(index).value = i;
			info.add(mCharInfoList.get(index));
			solve(info, ++index);
			--index;
			info.remove(mCharInfoList.get(index));
		}
	}
	
	public int getCharCount() {
		return mCharInfoList.size();
	}
	
	public class CharInfo {
		Character ch;
		int value;
		public CharInfo(Character ch) {
			this.ch = ch;
		}
		@Override
		public String toString() {
			return "[" + ch + ", " + value + "]";
		}
		
		
	}
	
	public boolean isMatch() {
		return false;
	}
}
