package package1;

import java.util.ArrayList;

public class AdjacencyListRepresentationOfGraphInJava {
	
	public static void addEdge(ArrayList<ArrayList<Integer>> graphAdj, int start, int dest, int V) {
		
		if(start >= V || dest >= V) {
			
			System.out.println("Invalid Input");
			return;
		}
		
		graphAdj.get(start).add(dest);
		graphAdj.get(dest).add(start); // do this only if the graph is non directed
		
	}
	
	public static void printGraph(ArrayList<ArrayList<Integer>> adjGraph) {
		
		for(int i = 0; i<adjGraph.size(); i++) {
			
			System.out.println("Adjacency list of node " + i + " are ->");
			
			for(int j = 0; j<adjGraph.get(i).size(); j++) {
				
				System.out.print(" " + adjGraph.get(i).get(j));
			}
			
			System.out.println();
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		int V = 5;
		
		ArrayList<ArrayList<Integer>> graphAdj
				= new ArrayList<ArrayList<Integer>>(V);
		
		for(int i = 0; i < V; i++) {
			
			graphAdj.add(new ArrayList<>());
		}
		
		addEdge(graphAdj, 0, 1, V);
        addEdge(graphAdj, 0, 4, V);
        addEdge(graphAdj, 1, 2, V);
        addEdge(graphAdj, 1, 3, V);
        addEdge(graphAdj, 1, 4, V);
        addEdge(graphAdj, 2, 3, V);
        addEdge(graphAdj, 3, 4, V);
          
        printGraph(graphAdj);
	}
	
	
}
