package graph;

public class SudokuGridFilling {

	public static void main(String[] args) {

		int[][] grid = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		int n = grid.length;

		printGrid(grid);

		System.out.println(SudokuSolvable(grid, 0, 0) + "\n\n");

		printGrid(grid);

	}

	private static boolean SudokuSolvable(int[][] grid, int row, int col) {
		
		System.out.println(row+","+col);
		
		if (row >= 8 && !unassignedGrid(grid)) {
			return true;
		}
		
		if (col >= 8 && row < 8) {
			row++;
			col = 0;
		} 
		
		//System.out.println("Before Exception : "+row+","+col);
		while (grid[row][col] != 0) {
			if (col >= 8) {
				row++;
				col = 0;
			} else {
				col++;
			}
		}
		
		/*if (col > 8) {
			row++;
			col = 0;
		} else {
			col++;
		}*/

		/*if (row > 8)
			return false;

		if (!unassignedGrid(grid))
			return true;*/

		/*if (grid[row][col] != 0) {
			if (col < 8)
				SudokuSolvable(grid, row, col + 1);
			else
				SudokuSolvable(grid, row + 1, 0);

		}*/
		
		

		for (int number = 1; number <= 9; number++) {
			
			System.out.println("Checking number " + number + " in cell "+row+","+col);

			if (isSafe(grid, row, col, number)) {
				grid[row][col] = number;
				System.out.println("Filled number " + number + " in cell "+row+","+col);
				
				if (SudokuSolvable(grid, row, col + 1)) {
					return true;
				}
				
				/*if(col<8 && SudokuSolvable(grid, row, col+1))
					return true;
				else if( SudokuSolvable(grid, row + 1, 0))
					return true;*/
				//else 
				//	continue;
			}
		}
		grid[row][col] = 0;

		return false;		
	}

	private static boolean isSafe(int[][] grid, int row, int col, int number) {

		boolean flag_cols = true, flag_rows = true, flag_box = true;
		int rowIndex = row - row % 3;
		int colIndex = col - col % 3;

		for (int i = 0; i < grid.length; i++) {
			// checking the column for unique 1-9 combinations
			if (grid[row][i] == number) {
				flag_cols = false;
				return false;
			}

			// checking the rows for unique 1-9 combinations
			if (grid[i][col] == number) {
				flag_rows = false;
				return false;
			}
		}

		// checking the box for unique 1-9 combinations
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i + rowIndex][j + colIndex] == number) {
					flag_box = false;
					return false;
				}
			}
		}

		return (flag_rows && flag_cols && flag_box);

	}

	private static boolean unassignedGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 0)
					return true;
			}
		}
		return false;
	}

	public static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
