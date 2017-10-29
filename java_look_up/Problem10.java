/**
 * Created by sridharyadav on 9/27/17.
 */

//Given two strings, find if first string is a subsequence of second.
//        Input: str1 = "AXY", str2 = "ADXCPY"
//        Output: True (str1 is a subsequence of str2)
//
//        Input: str1 = "AXY", str2 = "YADXCP"
//        Output: False (str1 is not a subsequence of str2)
//
//        Input: str1 = "gksrek", str2 = "geeksforgeeks"
//        Output: True (str1 is a subsequence of str2)

public class Problem10 {
    public static boolean isSubSequence(String str1, String str2, int m, int n) {
        int i, j;
        for (i = 0, j = 0; i < m && j < n; i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
            }
        }
        return i == m;
    }

    public static void main(String[] args) {
        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        int m = str1.length();
        int n = str2.length();
        boolean res = isSubSequence(str1, str2, m, n);
        if (res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}