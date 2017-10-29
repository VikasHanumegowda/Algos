/**
 * Created by sridharyadav on 12/23/15.
 */
import java.util.*;
public class sumClose {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int a[] = {1, 3, 8, 5, 5, 4, 6};
        int x = 16;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int val = x - a[i] - a[j];
                ArrayList<Integer> l = new ArrayList<>();
                if (map.containsKey(val) && map.get(val) != i && map.get(val) != j && i != j) {
                    l.add(val);
                    l.add(a[i]);
                    l.add(a[j]);
                    Collections.sort(l);
                    if (!list.contains(l)) {
                        list.add(l);
                    }
                }

            }
            map.put(a[i], i);
        }
        System.out.println(list.toString());
    }
}