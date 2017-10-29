/**
 * Number of Islands
 * Given a 2-d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */


/**
 * This is an variation of the standard problem: “Counting number of connected components in a undirected graph”.
 * A connected component of an undirected graph is a subgraph in which every two vertices are connected to each other
 * by a path(s), and which is connected to no other vertices outside the subgraph.
 * A graph where all vertices are connected with each other, has exactly one connected component,
 * consisting of the whole graph. Such graph with only one connected component is called as Strongly Connected Graph
 * <p>
 * The problem can be easily solved by applying DFS() on each component.
 * In each DFS() call, a component or a sub-graph is visited.
 * We will call DFS on the next un-visited component.
 * The number of calls to DFS() gives the number of connected components.
 */
public class Problem88 {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    merge(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void merge(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
            return;

        grid[i][j] = 'X';

        merge(grid, i - 1, j);
        merge(grid, i + 1, j);
        merge(grid, i, j - 1);
        merge(grid, i, j + 1);
    }

    public static void main(String args[]) {
        char grid[][] = {{'1', '1', '0', '0', '0'},
                {'0', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'}
        };
        System.out.println("The number of islands is : " + numIslands(grid));
    }
}
