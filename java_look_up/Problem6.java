/**
 * Created by sridharyadav on 9/26/17.
 */
/*
Given a string, find the longest substring which is palindrome.
For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 */
public class Problem6 {
    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high));
    }

    // This function prints the longest palindrome substring
    // (LPS) of str[]. It also returns the length of the
    // longest palindrome
    static int longestPalSubstr(String str) {
        int maxLength = Integer.MIN_VALUE;
        int length = str.length();
        int low, high, start = 0;
        for (int i = 1; i < length; i++) {
            low = i - 1;
            high = i;
            // Find the longest even length palindrome with center points
            // as i-1 and i.
            while (low >= 0 && high < length && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }
            // Find the longest odd length palindrome with center
            // point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < length && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                low--;
                high++;
            }
        }
        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, (start + maxLength));
        return maxLength;
    }

    // Driver program to test above function
    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        System.out.println("Length is: " +
                longestPalSubstr(str));
    }

}


//https://github.com/settyblue/GeeksForGeeks/blob/master/Strings/printAllPalindromicSubstrings/src/Main.java
