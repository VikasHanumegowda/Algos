/**
 * Created by sridharyadav on 12/25/15.
 */
public class Change {
    /*int count( int S[], int m, int n )
    {
        int i, j, x, y;

        // We need n+1 rows as the table is constructed in bottom up manner using
        // the base case 0 value case (n = 0)
        int table[][] = new int[n + 1][m];

        // Fill the entries for 0 value case (n = 0)
        for (i=0; i<m; i++)
            table[0][i] = 1;

        // Fill rest of the table entries in bottom up manner
        for (i = 1; i < n+1; i++)
        {
            for (j = 0; j < m; j++)
            {
                // Count of solutions including S[j]
                x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;

                // Count of solutions excluding S[j]
                y = (j >= 1)? table[i][j-1]: 0;

                // total count
                table[i][j] = x + y;
            }
        }
        return table[n][m-1];
    }*/
    int count(int total, int arr[]){

        int temp[] = new int[total+1];

        temp[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total ; j++){
                if(j >= arr[i]){
                    temp[j] += temp[j-arr[i]];
                }
            }
        }
        return temp[total];
    }
    /*int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
    }*/

    public static void main(String args[]) {
        Change c = new Change();
        int[] S = {5,1};
        System.out.print(c.count(5, S));
    }
}