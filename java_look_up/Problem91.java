/**
 * Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 */
public class Problem91 {
    public static int findMinimumPath(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int table[][] = new int[m][n];
        table[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            table[i][0] = table[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            table[0][i] = table[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (table[i - 1][j] > table[i][j - 1]) {
                    table[i][j] = table[i][j - 1] + grid[i][j];
                } else {
                    table[i][j] = table[i - 1][j] + grid[i][j];
                }
            }
        }
        return table[m - 1][n - 1];
    }

    public static void main(String args[]) {
        int grid[][] = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(findMinimumPath(grid));
    }
}
