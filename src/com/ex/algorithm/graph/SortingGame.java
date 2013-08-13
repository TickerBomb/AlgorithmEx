package com.ex.algorithm.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SortingGame {
	
	private ArrayList<Integer> input;
	private Vertex expected;
	private ArrayDeque<Vertex> queue;
	private HashSet<Vertex> hashSet;
	private HashMap<Integer, HashSet<Vertex>> hashMap;
	
	public SortingGame(ArrayList<Integer> input) {
		this.input = input;
		ArrayList<Integer> sortedList;
		Collections.sort(sortedList = new ArrayList<Integer>(input));
		
		expected = new Vertex(sortedList);
		
		queue = new ArrayDeque<SortingGame.Vertex>();
		hashSet = new HashSet<Vertex>();
		hashMap = new HashMap<Integer, HashSet<Vertex>>();
	}
	
	public void solve() {
		final Vertex v = new Vertex(input);
		queue.add(v);
		hashSet.add(v);
		
		int count = 0;

		while(!queue.isEmpty()) {

			/**
			if(expected.equals(queue.peek())) {
				Vertex resultVertex = queue.peek();
				System.out.println(resultVertex.depth);
				
				/**
				while(resultVertex.parent != null) {
					System.out.println("parent: " + resultVertex.parent);
					resultVertex.parent = resultVertex.parent.parent;
					
				}
				break;
			}
		**/
			
			Vertex parentVertex = queue.remove();
			
			ArrayList<Integer> numList = parentVertex.value;
			List<Integer> subList;
			for(int i = 0; i < numList.size(); i++) {
				for(int j = i + 1; j <= numList.size(); j++) {
					subList = numList.subList(i, j);
					subList = new ArrayList<Integer>(subList);
					Collections.reverse(subList);

					ArrayList<Integer> newList = new ArrayList<Integer>();
					newList.addAll(numList.subList(0, i));
					newList.addAll(subList);
					newList.addAll(numList.subList(j, numList.size()));
					int depth = parentVertex.depth;
					Vertex newVertex = new Vertex(newList);
					newVertex.parent = parentVertex;

					if(!hashSet.contains(newVertex)) {
						newVertex.depth = ++depth;
						queue.add(newVertex);
						hashSet.add(newVertex);
					}
					count++;
				}
			}
		}
		System.out.println("count: " + count);
	}
	
	public void solve2() {
		
		Vertex v = convertInputVertex();

		preCalc(input.size());
		/**
		
		HashSet<Vertex> set = hashMap.get(input.size());
		Iterator<Vertex> it = set.iterator();
		while(it.hasNext()) {
			Vertex target = it.next();
			if(target.equals(v)) {
				System.out.println(target);
				break;
			}
		}
		**/
	}
	
	private void preCalc(int length) {
		HashSet<Vertex> set = hashMap.get(length);
		if(set != null)
			return;
		
		set = new HashSet<Vertex>();

		hashMap.put(length, set);

		ArrayList<Integer> virtualInput = new ArrayList<Integer>();
		
		for(int i = 0; i < length; i++) {
			virtualInput.add(i);
		}
		
		System.out.println("start");
		for(int j = 0; j < 40320; j++) {
			System.out.println("");
		}

		System.out.println("end");

		input = virtualInput;

		final Vertex v = new Vertex(input);
		queue.add(v);
		set.add(v);

		int count = 0;
		while(!queue.isEmpty()) {
			Vertex parentVertex = queue.remove();
			
			int pivot = 0;
			ArrayList<Integer> numList = parentVertex.value;
			pivot = parentVertex.pivot;
			List<Integer> subList;
			for(int i = pivot; i < numList.size(); i++) {
				for(int j = i + 2; j <= numList.size(); j++) {
					subList = numList.subList(i, j);
					subList = new ArrayList<Integer>(subList);
					Collections.reverse(subList);

					ArrayList<Integer> newList = new ArrayList<Integer>();
					newList.addAll(numList.subList(0, i));
					newList.addAll(subList);
					newList.addAll(numList.subList(j, numList.size()));
					int depth = parentVertex.depth;
					Vertex newVertex = new Vertex(newList);
					newVertex.parent = parentVertex;

					if(!set.contains(newVertex)) {
						newVertex.depth = ++depth;
						newVertex.pivot = i + 1;
						queue.add(newVertex);
						set.add(newVertex);
					}
					count++;
				}
			}
		}
		
		System.out.println("count: " + count);
		System.out.println("setSize: " + set.size());
	}
	
	private Vertex convertInputVertex() {
		ArrayList<Integer> converted = new ArrayList<Integer>(input.size());
		
		for(int i = 0; i < input.size(); i++) {
			int index = 0;
			for(int j = 0; j < input.size(); j++) {
				if(input.get(i) > input.get(j)) {
					index++;
				}
			}
			converted.add(index);
		}
		
		Vertex vertex = new Vertex(converted);
		return vertex;
	}
	
	public static class Vertex {
		public Vertex parent;
		public ArrayList<Integer> value;
		public int depth;
		public int pivot;
		public Vertex(ArrayList<Integer> value) {
			this.value = value;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			for(Integer i : value) {
				sb.append(i + " ");
			}
			sb.append("], d: " + depth);
			return sb.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.get(0));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Vertex other = (Vertex) obj;
			
			for(int i = 0; i < value.size(); i++) {
				if(value.get(i) != other.value.get(i)) {
					return false;
				}
			}

			return true;
		}
	}
}
