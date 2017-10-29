/**
 * Created by sridharyadav on 10/13/17.
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class Problem58 {
    public static int findLastWordLen(String input) {
        int i = input.length() - 1;
        while (i >= 0 && input.charAt(i) == ' ') {
            i--;
        }
        int lastWordLen = 0;
        while (i >= 0 && input.charAt(i) != ' ') {
            lastWordLen++;
        }
        return lastWordLen;
    }

    public static void main(String args[]) {
        System.out.println(findLastWordLen("hey god i dunno what    to dooo   "));
    }
}
