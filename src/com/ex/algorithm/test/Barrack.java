package com.ex.algorithm.test;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Barrack {
	private int[][] mInput;
	private int mCount;
	private PriorityQueue<Integer> mQueue;
	
	public Barrack(int[][] input) {
		this.mInput = input;
		mQueue = new PriorityQueue<Integer>();
		mCount = mInput.length;
	}

	public void solve() {
		boolean[] isVisited = new boolean[mCount];
		int index = 0;
		int startX = 0;
		int startY = 0;
		int distance = 0;
		getMinPath(startX, startY, isVisited, index, distance);
		System.out.println(mQueue.peek());
	}
	
	private void getMinPath(int startX, int startY, boolean[] isVisited, int index, int distance) {
		
		if(index == mCount) {
//			System.out.println("preX: " + startX + ", preY: " + startY + ", index: " + index + ",dis: " + distance);
//			System.out.println("distance: " + distance);
			mQueue.add(distance);
			return;
		}
		
		ArrayList<Integer> positions;
		
		positions = moveToX(startX, startY, isVisited, index, distance);
		
		for(Integer pos : positions) {
			isVisited[pos] = false;
		}

		positions = moveToY(startX, startY, isVisited, index, distance);

		for(Integer pos : positions) {
			isVisited[pos] = false;
		}
	}
	
	private ArrayList<Integer> moveToX(int preX, int preY, boolean[] isVisited, int index, int distance) {
//		System.out.println("preX: " + preX + ", preY: " + preY + ", index: " + index + ",dis: " + distance);
		
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		int x = mInput[index][0];
		
		if(!isVisited[index]) {
			distance += Math.abs(preX - x);
			isVisited[index] = true;
			
			positions.addAll(removeCandidateXaxis(x, isVisited));
			positions.add(index);
		}
		
		getMinPath(x, preY, isVisited, index + 1, distance);
		
		return positions;
	}

	private ArrayList<Integer> moveToY(int preX, int preY, boolean[] isVisited, int index, int distance) {
//		System.out.println("preX: " + preX + ", preY: " + preY + ", index: " + index + ", dis: " + distance);
		
		ArrayList<Integer> positions = new ArrayList<Integer>();
		int y = mInput[index][1];

		if(!isVisited[index]) {
			distance += Math.abs(preY - y);
			isVisited[index] = true;

			positions.addAll(removeCandidateYaxis(y, isVisited));
			positions.add(index);
		}
		
		
		getMinPath(preX, y, isVisited, index + 1, distance);
		
		return positions;
	}
	
	private ArrayList<Integer> removeCandidateXaxis(int x, boolean[] isVisited) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for(int i = 0; i < mCount; i++) {
			for(int j = 0; j < 2; j++) {
				if(mInput[i][j] == x) {
					isVisited[i] = true;
					positions.add(i);
				}
			}
		}
		
		return positions;
	}

	private ArrayList<Integer> removeCandidateYaxis(int y, boolean[] isVisited) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for(int i = 0; i < mCount; i++) {
			for(int j = 0; j < 2; j++) {
				if(mInput[i][j] == y) {
					isVisited[i] = true;
					positions.add(i);
				}
			}
		}
		
		return positions;
	}
}
