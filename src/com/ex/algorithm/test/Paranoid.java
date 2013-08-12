package com.ex.algorithm.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Paranoid {
	
	public Point[][] matrix;
	private Stack<Point> stack;
	private Queue<Point> queue;
	private Stack<Point> path;
	private int size;
	public Paranoid(int size, Queue q) {
		matrix = new Point[size][size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix[i][j] = new Point(i, j, (i * size) + j + 1);
				
				System.out.println(matrix[i][j]);
			}
		}
		
		this.queue = new LinkedList<Paranoid.Point>();
		while(!q.isEmpty()) {
			Point p;
			p = (Point) q.remove();
			queue.add(matrix[p.x][p.y]);
		}
		
		this.stack = new Stack<Point>();
		this.path = new Stack<Point>();
		
		this.size = size;
	}
	
	public void solve() {
		
		Point target = queue.remove();
		stack.push(target);
		
		addPath(target);
		
		while(!path.isEmpty()) {
			Point p = path.pop();
			System.out.println("path[" + p.x + "][" + p.y + "]:" + p.value);
		}
	}
	
	private void addPath(Point p) {
		
		System.out.print("current Path: ");
		for(Point po : path) {
			System.out.print(po.value + "->");
		}
		
		System.out.println("");
		System.out.println("addPath: " + p);
		int x = p.x;
		int y = p.y;
		
		if(p.visited)
			return;

		if(queue.contains(p)) {	
			if(p.value == 12 && queue.size() == 1) {
				System.out.println("oooooooooooooops");
			}
			if(!queue.peek().equals(p)) {	// 잘못된 순서인 경우 백한다.
				removePath(p);
				return;
			}
			else {
				stack.push(queue.remove());
			}
		}
		
		p.visited = true;
		path.push(p);
		
		// find next path to visit.
		
		int newX;
		int newY;
		// left
		newX = x;
		newY = y - 1;
		if(newY >= 0) {
			addPath(matrix[newX][newY]);
		}
		
		// up
		newX = x - 1;
		newY = y;
		if(newX >= 0) {
			addPath(matrix[newX][newY]);
		}

		// right
		newX = x;
		newY = y + 1;
		if(newY < size) {
			addPath(matrix[newX][newY]);
		}

		// down
		newX = x + 1;
		newY = y;
		if(newX < size) {
			addPath(matrix[newX][newY]);
		}
		
		checkValidate();
	}
	
	private void checkValidate() {
		if(!queue.isEmpty()) {

			Point remove = path.pop();
			remove.visited = false;
			
			if(!stack.isEmpty() && stack.contains(remove)) {
				((LinkedList<Point>)queue).addFirst(stack.pop());
			}
		 	
		}
		else {
			if(path.size() != size * size) {
				Point remove = path.pop();
				remove.visited = false;

				if(stack.contains(remove)) {
					queue.add(stack.pop());
				}
			}
		}
	}
	
	private void removePath(Point point) {
		
		/**
		Point target = stack.peek();

		if(path.contains(target)) {
			Point remove;
			while(!path.isEmpty()) {
				remove = path.peek();
				if(!remove.equals(target)) {
					remove = path.pop();
					remove.visited = false;
				}
				else {
					break;
				}
			}
			
		}
		**/
		path.remove(point);
	}
	
	public static class Point {
		int value;
		int x;
		int y;
		boolean visited;
		
		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Point [" + x + "][" + y + "]:" + value + ", visited=" + visited;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (value != other.value)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
		
	}

}
