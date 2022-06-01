package main;

import java.util.ArrayList;

public class Graph {
	
	static int time = 0;
	
	// Function to add an edge into the graph
	static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v) {
		adjacencyList.get(u).add(v);
		adjacencyList.get(v).add(u);
	}
	
	// Function to find articulation points using depth first search
	static void findArticulationPoints(ArrayList<ArrayList<Integer>> adjacencyList) {
		int numberOfVertices = adjacencyList.size();		
		
		// Initializing required arrays
		boolean visited[] = new boolean[numberOfVertices]; // Array to store whether a vertex has been visited or not in DFS
		int depths[] = new int[numberOfVertices]; // Array to store depth of each vertex		
		int lows[] = new int[numberOfVertices]; // Array to store lowest depth of each vertex
		boolean isArticulationPoint[] = new boolean[numberOfVertices]; // Array to store whether a vertex is an articulation point or not
		
		/* To be used as the parent vertex when passing in 
		the starting node/root as the currentVertex */
		int parent = -1;
		
		// Iteratively call the recursive findArticulationPointsUtil function to find articulation
		// points in a graph for every vertex
		for(int u = 0; u < numberOfVertices; u++) {
			if(visited[u] == false) {
				findArticulationPointsUtil(adjacencyList, u, visited, depths, lows, parent, isArticulationPoint);
			}
		}
		
		// Print articulation points if any
		for(int u = 0; u < numberOfVertices; u++) {
			if(isArticulationPoint[u] == true) {
				System.out.print(u + " ");
			}
		}
		System.out.println();	
	}
	
	static void findArticulationPointsUtil(ArrayList<ArrayList<Integer>> adjacencyList, int currentVertex,
			boolean[] visited, int[] depths, int[] lows, int parent, boolean[] isArticulationPoint) {
		// Count of children in DFS Spanning Tree for each vertex
		int children = 0;
		
		// Mark the current node as visited
		visited[currentVertex] = true;
		
		// Initialize depth and low values
		depths[currentVertex] = lows[currentVertex] = ++time;
		
		// Go through all the vertices adjacent to the current vertex
		for(Integer adjacentVertex : adjacencyList.get(currentVertex)) {
			// If adjacentVertex is not visited yet, then make it a child of currentVertex
			// in DFS tree and recur for it
			if(!visited[adjacentVertex]) {
				children++;
				findArticulationPointsUtil(adjacencyList, adjacentVertex, visited, depths, lows, currentVertex, isArticulationPoint);
			
				// Check if the subtree rooted with adjacentVertex has a connection 
				// to one of the ancestors of currentVertex
				lows[currentVertex] = Math.min(lows[currentVertex], lows[adjacentVertex]);
				
				// Current vertex is an articulation point if any of following conditions are satisfied
				
				// If currentVertex is root of DFS Spanning Tree and has two or more children
				if((parent == -1) && (children > 1)) {
					isArticulationPoint[currentVertex] = true;
				}
				
				// If currentVertex is not root node and lowest depth of one of 
				// its adjacentVertex is more than depth value of currentVertex
				if((parent != -1) && (lows[adjacentVertex] >= depths[currentVertex])) {
					isArticulationPoint[currentVertex] = true;
				}	
			}
			// Update lowest depth value of currentVertex for parent function calls
			else if(adjacentVertex != parent) {
				lows[currentVertex] = Math.min(lows[currentVertex], depths[adjacentVertex]);
			}
		}
	}

	public static void main(String[] args) {
		// Number of vertices of the sample graph
		int numberOfVertices = 9;
		
		// Graph representation as an adjacency list
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>> (numberOfVertices);
		
		/* Add the empty Integer ArrayLists to adjacencyList to store 
		corresponding adjacency vertices of each vertex*/
		for(int i = 0; i < numberOfVertices; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		
		// Add edges to adjacencyList
		addEdge(adjacencyList, 0, 1);
		addEdge(adjacencyList, 0, 3);
		addEdge(adjacencyList, 1, 2);
		addEdge(adjacencyList, 2, 3);
		addEdge(adjacencyList, 2, 4);
		addEdge(adjacencyList, 2, 5);
		addEdge(adjacencyList, 4, 5);
		addEdge(adjacencyList, 5, 6);
		addEdge(adjacencyList, 6, 7);
		addEdge(adjacencyList, 6, 8);
		addEdge(adjacencyList, 7, 8);
		
		// Calling the function to find articulation points
		System.out.println("Articulation points are:");
		findArticulationPoints(adjacencyList);
	}
}
