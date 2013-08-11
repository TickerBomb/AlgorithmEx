package com.ex.algorithm.graph;

import java.util.ArrayList;
import java.util.Collections;

public class WordConnect {
	
	private ArrayList<String> words;
	private int[][] adjacentArray;
	private ArrayList<Vertex> vertexes;
	private ArrayList<String>[][] outputwords;
	private ArrayList<Integer> myIndex;
	
	public WordConnect(ArrayList<String> words) {
		this.words = words;
		
		vertexes = new ArrayList<Vertex>();
		adjacentArray = new int[26][26];
		outputwords = new ArrayList[26][26];
		myIndex = new ArrayList<Integer>();
		
		for(char c = 'a'; c <= 'z'; c++) {
			vertexes.add(new Vertex(c));
		}
		
		makeGraph();
	}
	
	private void makeGraph() {
		
		for(String word : words) {
			char s_char = word.charAt(0);
			char e_char = word.charAt(word.length() - 1);
			int s = s_char - 'a';
			int e = e_char - 'a';
			
			Vertex s_vertex = vertexes.get(s);
			s_vertex.outdegree++;

			Vertex e_vertex = vertexes.get(e);
			e_vertex.indegree++;
			
			adjacentArray[s][e]++;
			if(outputwords[s][e] == null) {
				outputwords[s][e] = new ArrayList<String>();
			}
			outputwords[s][e].add(word);
		}
	}
	
	public void solve() {
		
		boolean touched = false;
		
		for(Vertex vertex: vertexes) {
			if(vertex.indegree + 1 == vertex.outdegree) {	// find euler trailer
				touched = true;
//				System.out.println("tariler");
				findEulerCircuit(vertex);
				break;
			}
		}
		
		if(!touched) {

			for(Vertex vertex: vertexes) {
				if(vertex.outdegree > 0) {
					findEulerCircuit(vertex);
					break;
				}
			}
		}
		
		
		Collections.reverse(myIndex);
//		System.out.println("myIndex size: " + myIndex.size());
		
		if(myIndex.size() - 1 != words.size()) {
			System.out.println("IMPOSSIBLE");
		}
		else {
			for(int j = 1; j < myIndex.size(); j++) {
				int i = j - 1;
				int s = myIndex.get(i);
				int e = myIndex.get(j);
				String word = outputwords[s][e].get(0);
				System.out.print(word + " ");
			}
			System.out.println("");
		}
		
	}
	
	private void findEulerCircuit(Vertex vertex) {
//		System.err.println("findEulerCircuit(): " + vertex.character);
		
		int vertexIndex = vertex.character - 'a';
//		System.out.println("findEulerCircuit(): " + vertexIndex);
		
		for(int i = 0; i < 26; i++) {
			while(adjacentArray[vertexIndex][i] > 0) {
				Vertex v = vertexes.get(i);
//				System.out.println("adj[" + vertexIndex + "][" + i + "]: " + adjacentArray[vertexIndex][i]);
				adjacentArray[vertexIndex][i]--;
//				System.out.println("inner findEulerCircuit(): " + v.character);
				findEulerCircuit(v);
//				System.out.println("inner findEulerCircuit(),index : " + (v.character - 'a'));
			}
		}

		myIndex.add(vertexIndex);
		
	}
	public static class Vertex {
		public char character;
		public int indegree;	// 안으로 들어오는 간선 수
		public int outdegree;	// 밖으로 나가는 간선 수

		public Vertex(char c) {
			character = c;
			indegree = 0;
			outdegree = 0;
		}
	}

}
