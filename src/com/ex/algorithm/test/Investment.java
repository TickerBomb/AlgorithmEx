package com.ex.algorithm.test;

public class Investment {
//	http://www.acmicpc.net/problem/2662

	int companyA[] = {5,6,7,8};
	int companyB[] = {1,5,9,15};
	
	int company[][] = {{5,6,7,8},
					   {1,5,7,15}};
	final int MAX = 4;
	final int COMPANY_COUNT = 2;

	/**
	public void solve() {
		int result = 0;
		int index = 0;
		for(int i = 1; i <= MAX; i++) {
			if(result < subsum(i)) {
				result = subsum(i);
				index = i;
			}
		}
		System.out.println("result: " + result);
		System.out.println("index: " + index);
	}
	**/
	
	public void solve() {
		/**
		for(int i = 0; i < company.length; i++) {
			for(int j = 0; j < company[i].length; j++) {
				System.out.println("company[" + i + "][" + j + "]: " + company[i][j]);
			}
			System.out.println();
		}
		**/
		int result = subsum(4, 0);
		System.out.println("result: " + result);
	}
	
	public int subsum(int money, int depth) {
		// base case
		
		/**
		if(money > MAX)
			return;
			**/

		int sum = 0;
		int pivot = money - 1;
		
		int newIndex = 0;
		
		if(money == 0)
			return 0;

		System.out.println("subsum: " + money + ", " + depth);
		
		for(int i = money; i > 0; i--) {
			for(int j = depth; j < COMPANY_COUNT; j++) {
//				subsum(i, j);
				System.out.println("i: " + i + ",j: " +j);
			}
		}

		/**
		if((conIndex + 1 == COMPANY_COUNT)) {
			sum = company[conIndex][money - 1] + subsum(money - 1, conIndex);
		}
		else {
			sum = company[conIndex][money - 1] + subsum(money - 1, conIndex + 1);
		}
		**/
		
		
		/**
		if(money == 1) {
			return (Math.max(companyA[money - 1], companyB[money - 1]));
		}
		
		sum = Math.max(companyA[money - 1], companyB[money - 1]);
		
		for(int i = 1; i < money; i++) {
			int imsi = companyA[i - 1] + companyB[(money - 1) - i];
			sum = Math.max(sum, imsi);
		}
		**/
		
		return sum;
	}
}
