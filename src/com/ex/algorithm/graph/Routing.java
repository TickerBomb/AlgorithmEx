package com.ex.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Routing {
	
	private ArrayList<Vertex> graph;
	private PriorityQueue<MinPath> priorityQueue;
	private HashMap<Vertex, Integer> shortestDistance;
	
	public Routing() {
		graph = new ArrayList<Vertex>();
		priorityQueue = new PriorityQueue<Routing.MinPath>();
		shortestDistance = new HashMap<Vertex, Integer>();
		makeGraph();
	}
	
	public void solve() {
		priorityQueue.add(new MinPath(0, graph.get(0)));
		shortestDistance.put(graph.get(0), 0);
		
		Integer minCost = null;
		
		while(!priorityQueue.isEmpty()) {
			MinPath minPath = priorityQueue.poll();
			Vertex vertex = minPath.v;
			int cost = minPath.distance;
			
			minCost = shortestDistance.get(vertex);
			
			if(minCost != null) {
				if(cost > minCost) {
					System.out.println("ooops");
					continue;
				}
			}
			
			for(Edge e: vertex.adjacentList) {
				MinPath path = new MinPath(e.weight + cost, e.to);
				if(!(shortestDistance.get(path.v) != null && (shortestDistance.get(path.v) < e.weight + cost))) {
					shortestDistance.put(e.to, e.weight + cost);
					priorityQueue.add(path);
				}
			}
		}
		
		System.out.println("least : " + minCost);
	}
	
	private void printGraph() {
		for(Vertex v: graph) {
			System.out.println(v.toString());
		}
		
	}
	
	private void makeGraph() {

		/**
		Vertex s = new Vertex('s');
		Vertex a = new Vertex('a');
		Vertex b = new Vertex('b');
		Vertex c = new Vertex('c');

		Edge sToa = new Edge(s, a, 2);
		Edge sToc = new Edge(s, c, 12);

		Edge aTob = new Edge(a, b, 4);
		Edge aTos = new Edge(a, s, 2);

		Edge bToa = new Edge(b, a, 4);
		Edge bToc = new Edge(b, c, 3);

		Edge cTob = new Edge(c, b, 3);
		Edge cTos = new Edge(c, s, 12);
		
		s.addEdge(sToa);
		s.addEdge(sToc);

		a.addEdge(aTob);
		a.addEdge(aTos);

		b.addEdge(bToa);
		b.addEdge(bToc);

		c.addEdge(cTob);
		c.addEdge(cTos);
		
		graph.add(s);
		graph.add(a);
		graph.add(b);
		graph.add(c);
		**/

		
		Vertex a = new Vertex('a');
		Vertex b = new Vertex('b');
		Vertex c = new Vertex('c');
		Vertex d = new Vertex('d');
		Vertex e = new Vertex('e');
		Vertex f = new Vertex('f');
		Vertex g = new Vertex('g');
		
		Edge aTob = new Edge(a, b, 5);
		Edge aToc = new Edge(a, c, 1);

		Edge bToa = new Edge(b, a, 5);
		Edge bTod = new Edge(b, d, 1);
		Edge bTog = new Edge(b, g, 3);
		Edge bTof = new Edge(b, f, 3);

		Edge cTod = new Edge(c, d, 2);
		Edge cToa = new Edge(c, a, 1);

		Edge dTob = new Edge(d, b, 1);
		Edge dToc = new Edge(d, c, 2);
		Edge dToe = new Edge(d, e, 5);
		Edge dTof = new Edge(d, f, 3);

		Edge eTod = new Edge(e, d, 5);

		Edge fTob = new Edge(f, b, 3);
		Edge fTod = new Edge(f, d, 3);
		Edge fTog = new Edge(f, g, 2);

		Edge gTob = new Edge(g, b, 3);
		Edge gTof = new Edge(g, f, 2);
		
		a.addEdge(aTob);
		a.addEdge(aToc);
		
		b.addEdge(bToa);
		b.addEdge(bTod);
		b.addEdge(bTog);
		b.addEdge(bTof);

		c.addEdge(cTod);
		c.addEdge(cToa);

		d.addEdge(dTob);
		d.addEdge(dToc);
		d.addEdge(dToe);
		d.addEdge(dTof);

		e.addEdge(eTod);

		f.addEdge(fTob);
		f.addEdge(fTod);
		f.addEdge(fTog);

		g.addEdge(gTob);
		g.addEdge(gTof);
		
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		graph.add(g);
		
		printGraph();
	}
	
	public static class MinPath implements Comparable<MinPath>{
		public int distance;
		public Vertex v;
		public MinPath(int distance, Vertex v) {
			this.distance = distance;
			this.v = v;
		}

		@Override
		public int compareTo(MinPath o) {
			if(distance < o.distance)
				return -1;
			
			if(distance > o.distance)
				return 1;

			return 0;
		}

		@Override
		public String toString() {
			return "MinPath [" + distance + "], v=" + v.value + "]";
		}
		
		
	}
	
	public static class Vertex {
		public char value;
		public ArrayList<Edge> adjacentList;
		
		public Vertex(char value) {
			this.value = value;
			adjacentList = new ArrayList<Edge>();
		}
		
		public void addEdge(Edge e) {
			adjacentList.add(e);
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("Vertex [" + value + "]");
			if(adjacentList.size() > 0) {
				sb.append(", ");
				for(Edge e :adjacentList) {
					sb.append(e.toString());
					sb.append(" ");
				}
			}
			return sb.toString();
		}
	}
	
	public static class Edge {
		public Vertex from;
		public Vertex to;
		int weight;
		
		public Edge(Vertex from, Vertex to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "[(" + from.value + ")->(" + to.value + ")[" + weight + "]]";
		}
		
		
	}

}