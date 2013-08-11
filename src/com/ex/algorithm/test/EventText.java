package com.ex.algorithm.test;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class EventText {
	
	private final String SPECIAL_CHAR = "!@#$%^&*()-=\\|[]{};':',./<>?";
	private ArrayList<String> textList;
	private PriorityQueue<WordInvolve> result;
	
	public EventText(ArrayList<String> textList) {
//		
//		for(char a = 'a'; a <= 'z'; a++) {
//			System.out.println("char: " + a + ", : " + (a - 'a'));
//		}
//
//		for(char A = 'A'; A <= 'Z'; A++) {
//			System.out.println("char: " + A + ", : " + (A - 'A'));
//		}
//		
//		System.out.println("a: " + (int)'a');
//		System.out.println("A: " + (int)'A');
//		System.out.println("¤¡: " + (int)'¤¡');
		
		this.textList = textList;
		this.result = new PriorityQueue<WordInvolve>();
	}
	
	public void solve() {
		for(String text: textList) {
			int position = 0;
			position = hasSpecialChar(text);
			if(position == 1) {
				position++;
			}
			int count = 0;
			if(position > 0) {
				while(position < 20) {
//					System.out.println("!!!!!!!!!!!!text: " + text + "pos: " + hasSpecialChar(text));
//					System.out.println("position : " + position);
					if(position < text.length()) {
						int c = hasSameText(text.subSequence(0, position), text);
						if(c >= count && position > 1) {
							result.add(new WordInvolve(c, text.subSequence(0, position).toString()));
							System.out.println("text: " + text.subSequence(0, position) + ", count: " + count);
							count = c;
						}
						else {
							break;
						}
					}
					position++;
				}
			}
		}
		
		System.out.println("output: " + result.element().involveCnt + ", word: " + result.element().word);
	}
	
	private int hasSpecialChar(String text) {
		int length = 0;
		int position = -1;
		length = Math.min(text.length(), 20);
		
		for(int i = 0; i < length; i++) {
			char c = text.charAt(i);
			String ch = String.valueOf(c);
//			System.out.println("text: " + text + ", " + ch);

			position++;
			
			if( SPECIAL_CHAR.contains(ch)) {
				break;
			}
		}

		if(position == 0)
			position++;
		return position;
	}
	
	private int hasSameText(CharSequence charSequence, String origin) {
//		System.out.println("hasSameText: [" + charSequence + "]");
		
		int count = 0;
		for(String text: textList) {
			if(text.equals(origin) || text.length() < charSequence.length()) {
				continue;
			}

//			System.out.println("comp: " + text.subSequence(0, charSequence.length()) + ", ori: " + charSequence);
			if(text.subSequence(0, charSequence.length()).equals(charSequence)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static class WordInvolve implements Comparable<WordInvolve> {
		int involveCnt;
		String word;
		
		public WordInvolve(int count, String word) {
			System.err.println("count: " + count + ",word: " + word);
			involveCnt = count;
			this.word = word;
		}

		@Override
		public int compareTo(WordInvolve o) {
			if(involveCnt > o.involveCnt)
				return -1;
			else if(involveCnt < o.involveCnt)
				return 1;
			else {
				if(this.word.length() > o.word.length()) {
					return -1;
				}
				else if(this.word.length() < o.word.length()) {
					return 1;
				}

			}

			return 0;
		}
		
		
	}
}
