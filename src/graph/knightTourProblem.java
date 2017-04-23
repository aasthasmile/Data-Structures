package graph;

public class knightTourProblem {

	int move = 1;
	// {DDL} {DDR} {LLU} {LLD} {RRU} {RRD} {UUL} {UUR}
	static int[][] directions = { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 },
			{ 2, -1 } };

	public static void main(String[] args) {
		int[][] grid = new int[8][8];
		grid[0][0] = 1;

		knightTourProblem tour = new knightTourProblem();
		printGrid(grid);

		System.out.println(tour.findknightTour(grid, 0, 0, 2));

		printGrid(grid);

	}

	private boolean findknightTour(int[][] grid, int i, int j, int move) {
		//System.out.println(move);
		if (move > 64)
			return true;

		// if(!isValid(grid,i,j))
		// return false;

		for (int[] dir : directions) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (isValid(grid, x, y) && !isAssigned(grid, x, y)) {				
				grid[x][y] = move;

				if (findknightTour(grid, x, y, move + 1))
					return true;

				grid[x][y] = 0;
				//move--;
			}
		}
		return false;

	}

	private static boolean isAssigned(int[][] grid, int i, int j) {
		return (grid[i][j] != 0);
	}

	private static boolean isValid(int[][] grid, int i, int j) {
		return (i >= 0 && i < grid.length && j >= 0 && j < grid.length);
	}

	public static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
