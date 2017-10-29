/**
 * Created by sridharyadav on 9/27/17.
 */
//Given a string s we need to tell minimum characters to be appended (insertion at end) to make a string palindrome.
//
//        Examples:
//
//        Input : s = "abede"
//        Output : 2
//        We can make string palindrome as "abedeba"
//        by adding ba at the end of the string.
//
//        Input : s = "aabb"
//        Output : 2
//        We can make string palindrome as"aabbaa"
//        by adding aa at the end of the string.
public class Problem7 {
    // Driver program to test above function
    public static boolean isPalindrome(String input) {
        int lst_char_pointer = input.length() - 1;
        int first_char_pointer = 0;
        while (lst_char_pointer > first_char_pointer) {
            if (input.charAt(first_char_pointer) != input.charAt(lst_char_pointer)) {
                return false;
            }
            lst_char_pointer--;
            first_char_pointer++;
        }
        return true;
    }

    public static int minInsertionsToPalindrome(String input) {
        int num_insertions = 0;
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (!isPalindrome(input.substring(i + 1))) {
                num_insertions++;
            } else {
                break;
            }
        }
        return num_insertions + 1;
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println("Number of min insertions is: " +
                minInsertionsToPalindrome(str));
    }

}
