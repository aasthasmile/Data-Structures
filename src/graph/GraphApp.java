package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GraphApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };
		Graph graph = new Graph<>(8, names);

		graph.addEdgeDirected(0, 1);
		graph.addEdgeDirected(1, 2);
		graph.addEdgeDirected(2, 3);
		graph.addEdgeDirected(2, 4);
		graph.addEdgeDirected(1, 7);
		graph.addEdgeDirected(7, 4);
		graph.addEdgeDirected(4, 6);
		graph.addEdgeDirected(4, 5);

		graph.printAdjacencyList();

		//graph.printAdjacencyMatrix();

		System.out.println("DFS Traversal of Graph :\n");
		graph.DFSTraversal(0, graph.visited);

		graph.DFSTraversal2(0, graph.visited);
		
		System.out.println("BFS Traversal of the graph :\n");
		graph.BFSTraversal(0, graph.visited);

		System.out.println("\n\n-------Job Assigment Problem----------");
		// JobAssignmentProblem();

	}

	public static void JobAssignmentProblem() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of workers :");
		int numberOfWorkers = Integer.parseInt(sc.nextLine());

		Integer[] jobID = new Integer[numberOfWorkers];
		for (int i = 0; i < numberOfWorkers; i++) {
			jobID[i] = i;
		}

		Graph<Integer> jobAssigment = new Graph<Integer>(numberOfWorkers, jobID);
		System.out.println("Enter the cost matrix :");
		for (int i = 0; i < jobAssigment.adjacentMatrix.length; i++) {
			for (int j = 0; j < jobAssigment.adjacentMatrix[0].length; j++) {
				jobAssigment.addEdgeWeighted(i, j, sc.nextInt());
				// 9 2 7 8 6 4 3 7 5 8 1 8 7 6 9 4
			}
		}

		// jobAssigment.MinCost(0, 0, visited, traversed);

	}

}
