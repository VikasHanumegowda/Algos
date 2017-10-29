/**
 * Created by sridharyadav on 9/19/17.
 */

/*Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2 efficiently.
        For Example:

        Input :  string = "this is a test string"
        pattern = "tist"
        Output :  Minimum window is "t stri"
        Explanation: "t stri" contains all the characters
        of pattern.

        Input :  string = "geeksforgeeks"
        pattern = "ork"
        Output :  Minimum window is "ksfor"

http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/*/

public class Problem2 {

    // Function to find smallest window containing
    // all characters of 'pat'
    static int array_size = 256;

    static String findSubString(String str, String pat) {
        if (str == null || pat == null) {
            return "";
        }
        int len1 = str.length();
        int len2 = pat.length();
        if (len1 == 0 || len2 == 0 || len1 < len2) {
            return "";
        }
        int count1[] = new int[array_size];
        int count2[] = new int[array_size];
        int minLen = Integer.MAX_VALUE, start = 0;
        int startIndex = -1;
        char ch;
        for (int i = 0; i < len2; i++) {
            ch = pat.charAt(i);
            count2[ch]++;
        }
        int count = 0;
        for (int j = 0; j < len1; j++) {
            ch = str.charAt(j);
            count1[ch]++;
            if (count2[ch] != 0 && count1[ch] <= count2[ch]) {
                count++;
            }
            if (count == len2) {
                ch = str.charAt(start);
                while (count2[ch] == 0 || count1[ch] > count2[ch]) {
                    if(count1[ch] > count2[ch]) {
                        count1[ch]--;
                    }
                    ch = str.charAt(++start);
                }
                int len = j - start + 1;
                if (len < minLen) {
                    minLen = len;
                    startIndex = start;
                }
            }
        }
        if (startIndex == -1) {
            System.out.println("No such window exists");
            return "";
        }
        return str.substring(startIndex, startIndex + minLen);
    }

    // Driver Method
    public static void main(String[] args) {
        String str = "this is a test string";
        String pat = "tist";

        System.out.print("Smallest window is :  \n" +
                findSubString(str, pat));
    }
}

