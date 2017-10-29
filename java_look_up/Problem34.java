/**
 * Created by sridharyadav on 10/8/17.
 */
//Longest Common Prefix | Set 4 (Binary Search)
//        Given a set of strings, find the longest common prefix.
//
//        Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
//        Output : "gee"
//
//        Input  : {"apple", "ape", "april"}
//        Output : "ap"
public class Problem34 {

    public static String findLongestCommonPrefix(String array[], int n) {
        int i, len;
        int minLen = array[0].length();
        for (i = 1; i < n; i++) {
            len = array[i].length();
            minLen = Math.min(len, minLen);
        }
        int low = 0, high = minLen - 1, mid;
        String prefix;
        StringBuffer sb = new StringBuffer();
        while (low <= high) {
            mid = low + (high - low) / 2;
            prefix = array[0].substring(low, mid + 1);
            if (isPrefixPresent(array, prefix, n)) {
                sb.append(prefix);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return sb.toString();
    }

    public static boolean isPrefixPresent(String array[], String prefix, int n) {
        for (int i = 1; i < n; i++) {
            if (!array[i].contains(prefix)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String array[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = array.length;
        String longestCommonPrefix = findLongestCommonPrefix(array, n);
        if (longestCommonPrefix.length() > 0) {
            System.out.println("The length of the longest common prefix is : " + longestCommonPrefix.length());
        } else {
            System.out.println("There is no common prefix");
        }
    }

}
