/**
 * Created by sridharyadav on 2/7/16.
 */
public class EditDistance {

    public static int editDistDp(char str1[], char str2[], int m, int n){
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(str1[i-1] == str2[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
            }
        }
        return dp[m][n];
    }

    public static void main(String args[]){
        String str1 = "sunday";
        String str2 = "saturday";
        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();
        System.out.println("The minimum number of operations is " + editDistDp(arr1, arr2, str1.length(), str2.length()));
    }
}
