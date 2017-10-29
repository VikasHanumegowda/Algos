/**
 * Created by sridharyadav on 12/16/15.
 */
public class subsequence {
    public static boolean isSubsequence(String s1, String s2, int m, int n){
        if(m == 0)
            return true;
        if(n == 0)
            return false;
        if(s1.charAt(m-1) == s2.charAt(n-1))
            return isSubsequence(s1, s2, m-1, n-1);
        else
            return isSubsequence(s1, s2, m, n-1);
    }
    public static void main(String args[]) {
        String s1 = "gksreks";
        String s2 = "geeksforgeeks";
        System.out.print(isSubsequence(s1, s2, s1.length(), s2.length()));
    }
}
