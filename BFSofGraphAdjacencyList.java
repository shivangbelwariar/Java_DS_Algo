package package1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSofGraphAdjacencyList {

	public static void addEdge(ArrayList<ArrayList<Integer>> graphAdj, int start, int dest, int V) {
		
		if(start >= V || dest >= V) {
			
			System.out.println("Invalid Input");
			return;
		}
		
		graphAdj.get(start).add(dest);
		// graphAdj.get(dest).add(start); // do this only if the graph is non directed
		
	}
	
	public static void BFS(ArrayList<ArrayList<Integer>> adjGraph, int start, int visited[]) {
		
		Queue<Integer> quque = new LinkedList<>();
		
		quque.add(start);
		visited[start] = 1;
		
		while(!quque.isEmpty()) {
			
			Integer temp = quque.peek();
			quque.remove();
			
			System.out.print(temp + " ");
			
			for(int i = 0; i<adjGraph.get(temp).size(); i++) {
				
				if(visited[adjGraph.get(temp).get(i)] != 1) {
					
					quque.add(adjGraph.get(temp).get(i));
					
					visited[adjGraph.get(temp).get(i)] = 1;
				}
				
				
			}
		}
		
	}

	public static void main(String[] args) {
		
		int V = 9;
		
		ArrayList<ArrayList<Integer>> graphAdj
				= new ArrayList<ArrayList<Integer>>(V);
		
		for(int i = 0; i < V; i++) {
			
			graphAdj.add(new ArrayList<>());
		}
		
		addEdge(graphAdj, 0, 1, V);
        addEdge(graphAdj, 0, 2, V);
        addEdge(graphAdj, 1, 2, V);
        addEdge(graphAdj, 2, 0, V);
        addEdge(graphAdj, 2, 3, V);
        addEdge(graphAdj, 3, 3, V);
        addEdge(graphAdj, 3, 4, V);
        addEdge(graphAdj, 3, 5, V);
        addEdge(graphAdj, 5, 6, V);
        addEdge(graphAdj, 6, 7, V);
        addEdge(graphAdj, 7, 5, V);
        addEdge(graphAdj, 7, 8, V);
        
        int visited[] = new int[V];
        
        for(int i=0; i<V; i++) {
        	
        	visited[i] = 0;
        }
          
        BFS(graphAdj, 2, visited);
	}
	
}
