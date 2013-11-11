package com.ex.algorithm.test;


public class Picnic {
	int numOfPerson;
	int numOfPair;
	boolean[][] isFriend;
	int mCount;
	
	public Picnic(int person, int pair, int[] input) {
		this.numOfPerson = person;
		this.numOfPair = pair;

		isFriend = new boolean[numOfPerson][numOfPerson];
		
		for(int i = 0; i < input.length; i++) {
			if(i % 2 == 1) {
				int x = input[i - 1];
				int y = input[i];
				isFriend[x][y] = true;

				isFriend[y][x] = true;
			}
		}
	}
	
	public void solve() {
		boolean[] isPaired = new boolean[numOfPerson];
		mCount = makePair(isPaired);
		System.out.println("Count: "+ mCount);
	}

	private int makePair(boolean[] isPaired) {
		if(isAllMatched(isPaired))
			return 1;
		
		int firstPosition = getFirstPosition(isPaired);
		int ret = 0;

		// find My Friend
		for(int i = firstPosition + 1; i < numOfPerson; i++) {
			if(isPaired[i])
				continue;
			if(isFriend[firstPosition][i] == true) {
				isPaired[firstPosition] = isPaired[i] = true;
				// find next
				ret = ret + makePair(isPaired);
				isPaired[firstPosition] = isPaired[i] = false;
			}
		}

		return ret;
	}
	
	private boolean isAllMatched(boolean[] isPaired) {
		for(int i = 0; i < isPaired.length; i++) {
			if(isPaired[i] == false)
				return false;
		}
		return true;
	}
	
	private int getFirstPosition(boolean[] isPaired) {
		int position = -1;
		
		for(int i = 0; i < isPaired.length; i++) {
			if(!isPaired[i]) {
				position = i;
				break;
			}
		}

		return position;
	}
}
