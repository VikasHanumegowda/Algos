/**
 * Created by sridharyadav on 9/27/17.
 */
/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
 A subsequence of a string is a new string which is formed from the original string by deleting
 some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 Here is an example:
 S = "rabbbit", T = "rabbit"
 Return 3.
 Solution: dp.
 */

public class Problem11 {
    public static int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int table[] = new int[n + 1];
        table[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                table[j] = table[j] + ((S.charAt(i - 1) == T.charAt(j - 1)) ? table[j - 1] : 0);
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        String s1 = "rabbbit";
        String s2 = "rabbit";

        System.out.println("Number of distinct subsequences of T in S are : " +
                numDistinct(s1, s2));
    }
}
