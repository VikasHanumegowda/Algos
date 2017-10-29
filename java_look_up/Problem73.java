import java.util.HashSet;

/**
 * Created by sridharyadav on 10/15/17.
 */
public class Problem73 {

    public static String removeDuplicates(String input) {
        HashSet<Character> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        char character;
        for (int i = 0; i < input.length(); i++) {
            character = input.charAt(i);
            if (!set.contains(character)) {
                sb.append(character);
                set.add(character);
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        String input = "geeksforgeeks";
        System.out.println(removeDuplicates(input));
    }
}
