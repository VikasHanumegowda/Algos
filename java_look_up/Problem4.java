/**
 * Created by sridharyadav on 9/21/17.
 */
import java.util.*;

//Input : str = geeksforgeeks, k = 3
//        Output : r
//        First non-repeating character is f,
//        second is o and third is r.
//
//        Input : str = geeksforgeeks, k = 2
//        Output : o
//
//        Input : str = geeksforgeeks, k = 4
//        Output : Less than k non-repeating
//        characters in input.

public class Problem4 {
    public static char getKthNonRepeatingChar(String input){
        Map<Character, Integer> map = new HashMap<>();
        int length = input.length();
        char ch;
        for(int i = 0; i < length; i++){
            ch = input.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            } else{
                map.put(ch, map.get(ch) + 1);
            }
        }
        int k = 3;
        for(int i = 0; i < length; i++){
            ch = input.charAt(i);
            if(map.get(ch) == 1){
                k--;
                if(k == 0){
                    return ch;
                }
            }
        }
        throw new IllegalArgumentException("The string has no kth non-repeating character");
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return (e1.getValue()).compareTo(e2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void main(String args[]){
        System.out.println(getKthNonRepeatingChar("geeksforgeeks"));
    }
}
