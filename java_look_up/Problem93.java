/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class Problem93 {
    public static boolean isPalin(String input, int l, int r) {
        while (l < r) {
            if (input.charAt(l++) != input.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome(String input) {
        int l = 0, r = input.length() - 1;
        while (l < r) {
            if (input.charAt(l) != input.charAt(r)) {
                return (isPalin(input, l + 1, r) || isPalin(input, l, r - 1));
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String args[]) {
        String input = "deeee";
        System.out.println(validPalindrome(input));
    }
}
