import java.util.Arrays;

/**
 * Created by sridharyadav on 9/20/17.
 */

//Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that has exactly k distinct characters.
//        Examples:
//
//        Input: abc, k = 2
//        Output: 2
//        Possible substrings are {"ab", "bc"}
//
//        Input: aba, k = 2
//        Output: 3
//        Possible substrings are {"ab", "ba", "aba"}
//
//        Input: aa, k = 1
//        Output: 3
//        Possible substrings are {"a", "a", "aa"}
public class Problem3 {
    // with exactly k unique characters
    static int num_characters = 26;

    static int countkDist(String str, int k) {
        int result = 0;
        int unique_Chars;
        int length = str.length();
        int character_occurrence_array[] = new int[num_characters];
        for (int i = 0; i < length; i++) {
            unique_Chars = 0;
            Arrays.fill(character_occurrence_array, 0);
            for (int j = i; j < length; j++) {
                if (character_occurrence_array[str.charAt(j) - 'a'] == 0) {
                    unique_Chars++;
                }
                if (unique_Chars == k) {
                    result++;
                }
                character_occurrence_array[str.charAt(j) - 'a']++;
            }
        }
        return result;
    }

    // Driver Program
    public static void main(String[] args) {
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k + " distinct characters : "
                + countkDist(ch, k));
    }
}
