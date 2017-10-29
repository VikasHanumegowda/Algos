import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by sridharyadav on 10/13/17.
 * Find if two strings are Isomorphic
 */
public class Problem56 {
    public static boolean areIsomorphic(String inputA, String inputB) {
        int lenA = inputA.length();
        int lenB = inputB.length();

        if (lenA != lenB) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        char a, b;
        for (int i = 0; i < lenA; i++) {
            a = inputA.charAt(i);
            b = inputB.charAt(i);
            if (!map.containsKey(a)) {
                if (set.contains(b)) {
                    return false;
                } else {
                    map.put(a, b);
                    set.add(b);
                }
            } else {
                if (map.get(a) != b) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(areIsomorphic("aba", "xyx"));
    }
}
