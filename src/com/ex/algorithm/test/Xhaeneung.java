package com.ex.algorithm.test;

import java.util.ArrayList;
import java.util.Arrays;

public class Xhaeneung {
	private String[] TEMP_NUMBER = {"zero", "one", "two", "three", "four", "five" 
											, "six", "seven", "eight", "nine", "ten"};
	
	private ArrayList<String> mNumber;
	
	private String mLeft;
	private String mRight;
	private String mOperation;
	private String mResult;
	
	public Xhaeneung(String left, String operation, String right, String result) {
		init();
		mLeft = convert(left);
		mOperation = operation;
		mRight = convert(right);
		mResult = convert(result);
		
		printInput();
	}
	
	private void printInput() {
		System.out.println(findNumber(mLeft) + mOperation + findNumber(mRight) + " = " + findNumber(mResult));
	}
	
	private int findNumber(String input) {
		return mNumber.indexOf(input);
	}
	
	private void init() {
		mNumber = new ArrayList<String>(TEMP_NUMBER.length);
		
		for(int i = 0; i < TEMP_NUMBER.length; i++) {
			char[] temp = TEMP_NUMBER[i].toCharArray();
			Arrays.sort(temp);
			mNumber.add(String.valueOf(temp));
		}
	}
	
	private String convert(String src) {
		char[] temp = src.toCharArray();
		Arrays.sort(temp);
		return String.valueOf(temp);
	}
	
	public boolean solve() {
		int left = findNumber(mLeft);
		int right = findNumber(mRight);
		int result = findNumber(mResult);
		
		if((left < 0) || (right < 0) || (result < 0))
			return false;

		if(mOperation.equals("+")) {
			if((left + right) == result) {
				return true;
			}
		}
		else if(mOperation.equals("-")) {
			if((left - right) == result) {
				return true;
			}
			
		}
		else if(mOperation.equals("*")) {
			if((left * right) == result) {
				return true;
			}
			
		}
		else if(mOperation.equals("/")) {
			if((left / right) == result) {
				return true;
			}
		}
		
		return false;
	}
}
