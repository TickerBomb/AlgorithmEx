package com.ex.algorithm.graph;
import java.util.ArrayList;
import java.util.Collections;


public class TopoSort2 {
	
	private ArrayList<Vertex> vertexes;
	private ArrayList<ArrayList<Integer>> adjacentList;
	private ArrayList<Integer> result;
	
	public TopoSort2(ArrayList<Vertex> vertexes) {
		this.vertexes = vertexes;
		adjacentList = new ArrayList<ArrayList<Integer>>(vertexes.size());
		result = new ArrayList<Integer>();

		for(int i = 0; i < vertexes.size(); i++) {
			adjacentList.add(new ArrayList<Integer>());
		}
	}
	
	public void updateAdjacentList(int x, int y) {
		adjacentList.get(x-1).add(y);
	}
	
	public void dfs(int index) {
		
		Vertex v = vertexes.get(index);
		System.out.print(v.value + " <- ");
		v.isVisited = true;
		
		for(Integer y : adjacentList.get(index)) {
			if(!vertexes.get(y-1).isVisited) {
				dfs(y-1);
			}
		}
		
		result.add(index + 1);
	}
	
	public void dfsAll() {
		for(int i = 0; i < vertexes.size(); i++) {
			Vertex v = vertexes.get(i);
			if(!v.isVisited) {
				dfs(i);
			}
		}
		
		System.out.println("");
		Collections.reverse(result);
		for(Integer it : result) {
			System.out.print(it + " -> ");
		}
	}
	
	public static class Vertex {
		public int value;
		public boolean isVisited;
		
		public Vertex(int value) {
			this.value = value;
		}
	}
}
