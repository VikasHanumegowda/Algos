/**
 * Created by sridharyadav on 2/7/16.
 */
public class MatrixMultiplicationCost {

    public int findCost(int p[], int n){
        int m[][] = new int[n][n];

        int i, j, k, L, q;

    /* m[i,j] = Minimum number of scalar multiplications needed to compute
       the matrix A[i]A[i+1]...A[j] = A[i..j] where dimention of A[i] is
       p[i-1] x p[i] */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L=2; L<n; L++)
        {
            for (i=1; i<=n-L+1; i++)
            {
                j = i+L-1;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<j ; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n-1];
    }

    public static void main(String args[]){
        MatrixMultiplicationCost mmc = new MatrixMultiplicationCost();
        int arr[] = {4,2,3,5,3};
        int cost = mmc.findCost(arr, arr.length);
        System.out.print(cost);
    }
}