package dfs;

import java.util.ArrayList;
import java.util.Stack;

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
	
	// Iterative implementation of DFS algorithm using a stack
	static void depthFirstTraversal(ArrayList<ArrayList<Integer>> adjacencyList) {
		boolean visited[] = new boolean [adjacencyList.size()];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		while(!stack.empty()) {
			int popedVertex = stack.peek();
			stack.pop();
			
			if(visited[popedVertex] == false) {
				System.out.print(popedVertex + " ");
				visited[popedVertex] = true;
			}
			
			for(int i = 0; i < adjacencyList.get(popedVertex).size(); i++) {
				int a = adjacencyList.get(popedVertex).get(i);
				if(!visited[a]) {
					stack.push(a);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// Number of vertices of the sample graph to be passed to depthFirstTraversal() method
		int numberOfVerticesForDFS = 8;
		
		// Graph representation as an adjacency list to be passed to depthFirstTraversal()
		ArrayList<ArrayList<Integer>> adjacencyListForDFS = new ArrayList<ArrayList<Integer>> (numberOfVerticesForDFS);
		
		/* Add the empty Integer ArrayLists to adjacencyListForDFS to store 
		corresponding adjacency vertices of each vertex to*/
		for(int i = 0; i < numberOfVerticesForDFS; i++) {
			adjacencyListForDFS.add(new ArrayList<Integer>());
		}
		
		// Add edges to adjacencyListForDFS
		addEdge(adjacencyListForDFS, 0, 3);
		addEdge(adjacencyListForDFS, 1, 2);
		addEdge(adjacencyListForDFS, 2, 6);
		addEdge(adjacencyListForDFS, 3, 5);
		addEdge(adjacencyListForDFS, 3, 7);
		addEdge(adjacencyListForDFS, 4, 7);
		addEdge(adjacencyListForDFS, 5, 6);	
		
		depthFirstTraversal(adjacencyListForDFS);
	}
}
 