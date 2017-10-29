/**
 * Created by sridharyadav on 12/14/15.
 */
import java.util.*;
public class Anagram {
    public static void isAnagram(String str1, String str2) {
        HashMap<Character, Integer> count1 = new HashMap<>();
        HashMap<Character, Integer> count2 = new HashMap<>();
        ArrayList<Character> result = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!count1.containsKey(ch)) {
                count1.put(ch, 1);
            } else {
                count1.put(ch, count1.get(ch) + 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (!count2.containsKey(ch)) {
                count2.put(ch, 1);
            } else {
                count2.put(ch, count2.get(ch) + 1);
            }
        }
        int n = 0;
        for (Map.Entry<Character, Integer> entry : count1.entrySet()) {
            if (count2.containsKey(entry.getKey())) {
                if (count2.get(entry.getKey()) < entry.getValue())
                    n = count2.get(entry.getKey());
                else
                    n = entry.getValue();
                for (int i = 1; i <= n; i++)
                    result.add(entry.getKey());
            }

        }

        System.out.println(result.toString());
    }

    public static void main(String args[]) {
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";
        isAnagram(str1, str2);
    }
}
