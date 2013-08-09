package com.ex.algorithm.tree;
import java.util.Collections;
import java.util.PriorityQueue;


public class Heap {

	private int[] input;
	private int[] ranNum;
	private int result;
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	public Heap(int[] ranNum) {
		this.ranNum = ranNum;
		this.result = 0;

		maxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();

		initInputValues();
	}

	private void initInputValues() {
		int length = ranNum[0];

		input = new int[length];
		input[0] = 1983;

		for(int i = 1; i < length; i++) {
			input[i] = (int) ((input[i - 1] * (long)ranNum[1] + ranNum[2]) % 20090711);
		}
	}

	private void add(int element) {

		if(maxHeap.size() == minHeap.size()) {	// maxheap 에 먼저 넣는다.
			maxHeap.add(element);
		}
		else {	// maxHeap 이 더 큰 경우
			minHeap.add(element);
		}

		Integer leftMax = 0;
		Integer rightMin = 0;

		leftMax = maxHeap.peek();
		rightMin = minHeap.peek();

		if(leftMax != null && rightMin != null && (leftMax > rightMin)) {
			minHeap.add(maxHeap.poll());
			maxHeap.add(minHeap.poll());

			leftMax = maxHeap.peek();
			rightMin = minHeap.peek();
		}
		result = (result +  maxHeap.peek()) % 20090711;
	}

	public int solve() {
		for(int i = 0; i < input.length; i++) {
			add(input[i]);
		}

		return result;
	}
}
