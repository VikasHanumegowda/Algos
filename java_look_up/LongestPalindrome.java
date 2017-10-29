/**
 * Find the longest palindromic substring in a string
 */
public class LongestPalindrome {

    public static String helper(String input, int start, int end, int length) {
        while (start >= 0 && end < length && input.charAt(start) == input.charAt(end)) {
            start--;
            end++;
        }
        return input.substring(start + 1, end);
    }

    public static int longestPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        if (input.length() == 1) {
            return 1;
        }
        int length = input.length();
        String longest = input.substring(0, 1);
        for (int i = 0; i < length; i++) {
            String oddLenPalin = helper(input, i, i, length);
            if (oddLenPalin.length() > longest.length()) {
                longest = oddLenPalin;
            }
            String evenLenPalin = helper(input, i, i + 1, length);
            if (evenLenPalin.length() > longest.length()) {
                longest = evenLenPalin;
            }
        }
        System.out.println("The longest palindromic substring is : " + longest + " and it's length is : ");
        return longest.length();
    }

    public static void main(String args[]) {
        String s = "abba";
        System.out.print(longestPalindrome(s));
    }
}
