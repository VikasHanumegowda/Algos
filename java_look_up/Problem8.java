/**
 * Created by sridharyadav on 9/27/17.
 */
//Minimum number of deletions to make a string palindrome
//        Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
//
//        Note: The order of characters should be maintained.
//
//        Examples:
//
//        Input : aebcbda
//        Output : 2
//        Remove characters 'e' and 'd'
//        Resultant string will be 'abcba'
//        which is a palindromic string
//
//        Input : geeksforgeeks
//        Output : 8
public class Problem8 {
    public static int lenLongestPalinSubq(String input) {
        int length = input.length();
        int L[][] = new int[length][length];
        for (int i = 0; i < length; i++) {
            L[i][i] = 1;
        }
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                int j = i + len - 1;
                if (input.charAt(i) != input.charAt(j)) {
                    L[i][j] = Math.max(L[i + 1][j],L[i][j - 1]);
                } else if (len == 2) {
                    L[i][j] = 2;
                } else {
                    L[i][j] = L[i + 1][j - 1] + 2;
                }
            }
        }
        return L[0][length-1];
    }

    public static int minimumNumberOfDeletions(String input) {
        int len_longest_pali_subq = lenLongestPalinSubq(input);
        return (input.length() - len_longest_pali_subq);

    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println("Minimum number of deletions = "
                + minimumNumberOfDeletions(str));
    }
}
