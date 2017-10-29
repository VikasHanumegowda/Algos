/**
 * Created by sridharyadav on 12/24/15.
 */
public class nonDecDig {
    int k = 2;
    int dp[][] = new int[10][k+1];

    int nonDecCount(int n) {
        // Base cases
        for(int i = 0; i <= 9; i++)
            dp[i][1] = 1;
        for(int digit = 0; digit <= 9; digit++)
        {
            for(int len = 2; len <= n; len++){
                for(int x = 0; x <= digit; x++){
                    dp[digit][len] += dp[x][len-1];
                }
            }
        }
        int count = 0;
        for(int i = 0; i <=9 ; i++){
            count += dp[i][n];
        }

        return count;
    }

    // Driver Program to test above functions
    public static void main(String args[]) {
        nonDecDig p = new nonDecDig();
        System.out.print(p.nonDecCount(p.k));
    }
}