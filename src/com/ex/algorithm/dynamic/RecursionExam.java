package com.ex.algorithm.dynamic;

import java.util.ArrayList;

public class RecursionExam {
	
	public void solve1() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					System.out.println(i + " " + j + " " + k);
				}
			}
		}
		
		System.out.println("-------------------------------");
		
		ArrayList<Integer> pick = new ArrayList<Integer>();
		recursion1(3, 3, pick);
	}
	
	private void recursion1(int count, int toPick, ArrayList<Integer> pick) {
		// base case
		if(toPick == 0) {	// print pick
			for(Integer i : pick) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < count; i++) {
			pick.add(i);
			recursion1(count, toPick - 1, pick);
			pick.remove(pick.size() - 1);
		}
		
	}

}
