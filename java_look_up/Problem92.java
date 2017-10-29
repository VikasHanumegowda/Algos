import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


public class Problem92 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        char ch;
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                maxLength = Math.max(maxLength, set.size());
                while (start < i && s.charAt(start) != ch) {
                    set.remove(s.charAt(start++));
                }
                start++;
            }
        }
        return Math.max(maxLength, set.size());
    }

    public static void main(String args[]) {
        String s = "dvddf";
        System.out.println("The length of the longest substring that"
                + " has no repeating characters is : " + lengthOfLongestSubstring(s));
    }
}
