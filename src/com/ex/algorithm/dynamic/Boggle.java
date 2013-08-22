package com.ex.algorithm.dynamic;

public class Boggle {
	private int mRow = 5;
	private char[][] mInput;
	private String mWord;
	
	private final int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	private final int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public Boggle(char[][] input, String word) {
		mInput = input;
		mWord = word;
	}
	
	public void printInput() {
		for(int i = 0; i < mInput.length; i++) {
			for(int j = 0; j < mInput[i].length; j++) {
				System.out.print(mInput[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public void solve() {
		boolean found = false;
		for(int i = 0; i < mInput.length; i++) {
			for(int j = 0; j < mInput.length; j++) {
				found = findChar(i, j, mWord);
				if(found) {
					break;
				}
			}
			if(found)
				break;
		}
		System.out.println("found: " + found);
	}
	
	private boolean findChar(int y, int x, String word) {
		if(!isRange(x, y)) {
			return false;
		}
		
		if(mInput[y][x] == word.charAt(0)) {	// found!
			if(word.length() == 1) {	// end
				return true;
			}
			
			word = word.substring(1);
		}
		else {	// not found
			return false;
		}
		
		for(int i = 0; i < 8; i++) {
			if(findChar(y + dy[i], x + dx[i], word))
				return true;
		}
		
		return false;
	}
	
	private boolean isRange(int x, int y) {
		if(x < 0 || y < 0)
			return false;
		
		if(x > (mInput.length - 1) || y > (mInput.length - 1)) {
			return false;
		}
		
		return true;
	}
}
