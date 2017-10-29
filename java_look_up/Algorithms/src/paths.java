import java.util.*;
public class paths {
    int R = 3, C = 3;
    int max_k = 1000;
    int dp[][][] = new int[R][C][max_k];

    int pathCountDPRecDP(int mat[][], int m, int n, int k) {
        // Base cases
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0)
            return (k == mat[m][n])? 1 : 0;

        // If this sub-problem is already solved
        if (dp[m][n][k] != -1) return dp[m][n][k];

        // (m, n) can be reached either through (m-1, n) or
        // through (m, n-1)
        dp[m][n][k] = pathCountDPRecDP(mat, m - 1, n, k - mat[m][n]) +
                pathCountDPRecDP(mat, m, n - 1, k - mat[m][n]);

        return dp[m][n][k];
    }

    // This function mainly initializes dp[][][] and calls
// pathCountDPRecDP()
    int pathCountDP(int mat[][], int k) {
        for(int [][] row: dp)
        {
            for (int[] innerRow: row)
            {
                    Arrays.fill(innerRow, -1);
                }
            }
        return pathCountDPRecDP(mat, R - 1, C - 1, k);
    }

    // Driver Program to test above functions
    public static void main(String args[]) {
        paths p = new paths();
        int mat[][] = new int[][]{{1, 2, 3}, {4, 6, 5}, {3, 2, 1}};
        System.out.print(p.pathCountDP(mat, 12));
    }
}