import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class TopoSort {
	private List<Vertex> vertexes;
	private Queue<Vertex> queue;
	
	public TopoSort(List<Vertex> vertexes) {
		this.vertexes = vertexes;
		queue = new ArrayDeque<Vertex>(vertexes.size());
	}
	
	public List<Vertex> solve() {
		
		ArrayList<Vertex> result = new ArrayList<Vertex>(vertexes.size());
		
		for(Vertex vertex: vertexes) {
			if(vertex.indegree == 0) {
				queue.add(vertex);
				result.add(vertex);
			}
		}
		
		while(!queue.isEmpty()) {
			Vertex v = queue.poll();
			
			for(Vertex vertex: v.adjacentList) {
				--vertex.indegree;
				if(vertex.indegree == 0) {
					queue.add(vertex);
					result.add(vertex);
				}
			}
		}
		
		return result;
	}
	

	public static class Vertex {
		String value;
		List<Vertex> adjacentList;
		int indegree;
		
		public Vertex(String value) {
			this.value = value;
			adjacentList = new ArrayList<Vertex>();
		}
	}
	
	
}
