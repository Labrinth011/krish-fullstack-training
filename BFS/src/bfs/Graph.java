package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* The following code represents a graph data structure as an Adjacency List
 * using an ArrayList in Java
 */

public class Graph {
	static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v) {
		adjacencyList.get(u).add(v);
		adjacencyList.get(v).add(u);
	}
	
	static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
		for(int i = 0; i < adjacencyList.size(); i++) {
			for(int j = 0; j < adjacencyList.get(i).size(); j++) {
				System.out.print(i + " " + adjacencyList.get(i).get(j));
				System.out.println();
			}
		}
	}
	
	// Implementation of BFS using queue
	static void breadthFirstTraversal(ArrayList<ArrayList<Integer>> adjacencyList) {
		
		boolean visited[] = new boolean [adjacencyList.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited[0] = true;
		queue.add(0);
		
		while(queue.size() != 0) {
			int dequeuedVertex = queue.poll();
			System.out.print(dequeuedVertex + " ");
			
			for(int i = 0; i < adjacencyList.get(dequeuedVertex).size(); i++) {
				if(!visited[adjacencyList.get(dequeuedVertex).get(i)]) {
					visited[adjacencyList.get(dequeuedVertex).get(i)] = true;
					queue.add(adjacencyList.get(dequeuedVertex).get(i));
				}
			}
		}
		
		System.out.println();	
	}
	
	public static void main(String[] args) {
		// Number of vertices of the sample graph to be passed to breadthFirstTraversal() method
		int numberOfVerticesForBFS = 7;
		
		// Graph representation as an adjacency list to be passed to breadthFirstTraversal()
		ArrayList<ArrayList<Integer>> adjacencyListForBFS = new ArrayList<ArrayList<Integer>> (numberOfVerticesForBFS);
		
		/* Add the empty Integer ArrayLists to adjacencyListForBFS to store 
		corresponding adjacency vertices of each vertex to*/
		for(int i = 0; i < numberOfVerticesForBFS; i++) {
			adjacencyListForBFS.add(new ArrayList<Integer>());
		}
		
		// Add edges to adjacencyListForBFS
		addEdge(adjacencyListForBFS, 0, 1);
		addEdge(adjacencyListForBFS, 0, 2);
		addEdge(adjacencyListForBFS, 1, 3);
		addEdge(adjacencyListForBFS, 2, 4);
		addEdge(adjacencyListForBFS, 2, 6);
		addEdge(adjacencyListForBFS, 4, 5);
		addEdge(adjacencyListForBFS, 5, 6);
		
		breadthFirstTraversal(adjacencyListForBFS);
	}
}
 