package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * RAT IN A MAZE PROBLEM Consider a rat placed at (0, 0) in a square matrix
 * m[][] of order n and has to reach the destination at (n-1, n-1). Your task is
 * to complete the function which returns a sorted array of strings denoting all
 * the possible directions which the rat can take to reach the destination at
 * (n-1, n-1). The directions in which the rat can move are 'U'(up), 'D'(down),
 * 'L' (left), 'R' (right).
 * 
 * @author Aastha Jain
 *
 */
public class RatInAMaze {

	// Directions 'R' (right),'D'(down),'U'(up), , 'L' (left).
	public static int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }, };

	// static int[][] maze = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0,
	// 1, 0, 0 }, { 0, 1, 1, 1 } };

	static int[][] maze = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

	static boolean visited[][] = new boolean[maze.length][maze.length];

	public static void main(String[] args) {

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + " ");
				if (maze[i][j] == 0)
					visited[i][j] = true; // there is a wall
			}
			System.out.println();
		}

		int source_i = 0, source_j = 0;

		for(String i:printPath(maze, visited, source_i, source_j)){
			System.out.print(i+" ");
		}

	}

	private static ArrayList<String> printPath(int[][] maze, boolean[][] visited, int x, int y) {

		List<String> arr=new ArrayList<String>();
		System.out.println("\n\n"+SolveMaze(maze, visited, x, y,arr));
	    return (ArrayList<String>) arr;

	}

	private static boolean SolveMaze(int[][] maze, boolean[][] visited, int x, int y,List<String> arr) {

		if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
			maze[x][y] = 1;
			return true;
		}

		if (maze[x][y] == 0)
			return false;

		for (int[] dir : directions) {
			int i = x + dir[0];
			int j = y + dir[1];

			if (isSafe(i, j, maze) && !visited[x][y]) {
				arr.add(printDirection(dir[0], dir[1]));
				maze[x][y] = 0; // put a wall that is visited
				visited[x][y] = true;

				if (SolveMaze(maze, visited, i, j,arr)){
					maze[x][y] = 1;
					return true;
				}

				/* Backtrack: unmark X and Y */
				
				return false;
			}
		}
		return false;

	}

	private static String printDirection(int i, int j) {
		if (i == -1 && j == 0)
			return "U";
		else if (i == 1 && j == 0)
			return "D";
		else if (i == 0 && j == -1)
			return "L";
		else
			return "R";
	}

	private static boolean isSafe(int x, int y, int[][] maze) {
		return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
	}

}
