
public class StringEncryption {
	
	private char[] word;
	private char[] result;

	
	public StringEncryption(String plainText) {
		word = new char[plainText.length()];
		result = new char[plainText.length()];
		
		for(int i = 0; i < word.length; i++) {
			word[i] = plainText.charAt(i);
		}
	}
	
	public char[] solve() {
		int mid = (word.length / 2) + (word.length % 2);
		
		for(int i = 0; i < word.length; i++) {
			if((i % 2) == 0) {
				result[i/2] = word[i];
			}
			else {
				result[mid+i/2] = word[i];
			}
		}

		return result;
	}
}
