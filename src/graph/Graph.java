package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph<T> {

	int adjacentMatrix[][];
	int costMatrix[][];
	boolean visited[];
	int numberOfVertex;
	T names[];
	HashMap<Integer, List<Integer>> adjacencyList;

	@SuppressWarnings("unchecked")
	public Graph(int VertexCount, T[] name) {
		this.numberOfVertex = VertexCount;
		this.adjacentMatrix = new int[VertexCount][VertexCount];
		this.visited = new boolean[VertexCount];
		this.names = name;
		adjacencyList = new HashMap<Integer, List<Integer>>();
		for (int ii = 0; ii < numberOfVertex; ii++) {
			if (!adjacencyList.containsKey(ii))
				adjacencyList.put(ii, new ArrayList<Integer>());
		}
	}

	void addToAdjacencyList(int i, int j) {
		adjacencyList.get(i).add(j);
	}

	void printAdjacencyList() {
		for (int i = 0; i < numberOfVertex; i++) {
			System.out.println(i + " --> " + adjacencyList.get(i));
		}
	}

	/**
	 * To add an edge to an undirected graph ,we need to add edge from i to j as
	 * well as from j to i.
	 */
	public void addEdgeUndirected(int i, int j) {
		if (i >= 0 && i < numberOfVertex && j >= 0 && j < numberOfVertex) {
			adjacentMatrix[i][j] = 1;
			adjacentMatrix[j][i] = 1;
		} else {
			System.out.println(i + " and " + j + " are Index Out of Range");
		}
		addToAdjacencyList(i, j);
	}

	/**
	 * To add an edge to a directed graph we need to add an edge from i to j.
	 */
	public void addEdgeDirected(int i, int j) {
		if (i >= 0 && i < numberOfVertex && j >= 0 && j < numberOfVertex)
			adjacentMatrix[i][j] = 1;
		else
			System.out.println(i + " and " + j + " are Index Out of Range");

		addToAdjacencyList(i, j);
	}

	public void addEdgeWeighted(int i, int j, int weight) {
		if (i >= 0 && i < numberOfVertex && j >= 0 && j < numberOfVertex)
			costMatrix[i][j] = weight;
		else
			System.out.println(i + " and " + j + " are Index Out of Range");
		addToAdjacencyList(i, j);
	}

	/**
	 * Deleting an edge between two vertexes i and j.
	 */
	public void deleteEdge(int i, int j) {
		if (i >= 0 && i < numberOfVertex && j >= 0 && j < numberOfVertex) {
			adjacentMatrix[i][j] = 0;
			adjacentMatrix[j][i] = 0;
		}
	}

	void printAdjacencyMatrix() {
		for (int i = 0; i < adjacentMatrix.length; i++) {
			for (int j = 0; j < adjacentMatrix[0].length; j++) {
				System.out.print(adjacentMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public T namesArray(int i) {
		return names[i];
	}

	/**
	 * Depth First Traversal consist of 3(Preorder ,Inorder,Postorder) Traversal
	 * of the graph. We need a mechanism for traversing all the edges from
	 * source to destination such that all the vertexes are traversed and we go
	 * through all the edges.
	 */
	public void DFSTraversal(int rowIndex, boolean[] visited) {

		if (visited[0] == false) {
			System.out.print(names[0] + " ");
			visited[0] = true;
		}
		for (int j = 0; j < numberOfVertex; j++) {
			if (adjacentMatrix[rowIndex][j] == 1 && !visited[j]) {

				System.out.print(names[j] + " ");
				visited[j] = true;
				DFSTraversal(j, visited);
			}

		}
	}

	public void DFSTraversal2(int rowIndex, boolean[] visited) {
		if (visited[rowIndex] == false) {

			visited[rowIndex] = true;
			System.out.print(names[rowIndex] + " ");

			if (!(adjacencyList.get(rowIndex)).isEmpty()) {

				for (int vertexNo : adjacencyList.get(rowIndex)) {
					if (!visited[vertexNo])
						DFSTraversal2(vertexNo, visited);

				}
			}
		}
	}

	/** BFSTraversal of the graph -level order traversal **/
	public void BFSTraversal(int rowIndex, boolean visited[]) {
		
		Queue<Integer> queue =new LinkedList<>();
		queue.add(rowIndex);
		visited[rowIndex] = true;
		System.out.print(names[rowIndex] + " ");

		while (!queue.isEmpty()) {
			
			for (int vertexNo : adjacencyList.get(queue.poll())) {
				
				if (!visited[vertexNo]){
					visited[vertexNo]=true;
					System.out.print(names[vertexNo]+" ");
					queue.add(vertexNo);
				}
			}
		}

	}

	/** Finding a cycle in an undirected graph */
	boolean findCycle() {
		for (int i = 0; i < numberOfVertex; i++) {
			if (isCycle(i)) {
				return true;
			}
		}
		return false;

	}

	private boolean isCycle(int i) {
		return true;
	}

	public HashMap<Integer, Integer> MinCost(int workerId, int cost, boolean visited[],
			HashMap<Integer, Integer> traversed) {

		// PriorityQueue<String> pq=new PriorityQueue<>();

		int min = Integer.MAX_VALUE, minindex = -1;
		for (int j = 0; j < numberOfVertex; j++) {
			if (adjacentMatrix[workerId][j] < min && !visited[j]) {
				minindex = j;
				min = Math.min(adjacentMatrix[workerId][j], min);
			}
		}
		cost = cost + min;

		traversed.put(workerId, minindex);

		visited[traversed.get(0)] = true;

		if (workerId < numberOfVertex - 1) {
			MinCost(workerId + 1, cost, visited, traversed);
		}
		return traversed;
	}

	public void calculateCost() {
		boolean visited[] = new boolean[numberOfVertex];
		HashMap<Integer, Integer> traversed = new HashMap<Integer, Integer>();

		MinCost(0, 0, visited, traversed);

	}

}
