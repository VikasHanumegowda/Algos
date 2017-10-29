/**
 * Created by sridharyadav on 9/27/17.
 */
//LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
//        A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
//        For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
//        So a string of length n has 2^n different possible subsequences.
public class Problem9 {
    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int L[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println("Length of LCS is" + " " +
                lcs(s1, s2));
    }
}
