import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 */
public class Problem106 {
    public static void printArray(int result[]) {
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> intersectionSet = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                intersectionSet.add(i);
            }
        }
        int result[] = new int[intersectionSet.size()];
        int index = 0;
        for (int i : intersectionSet) {
            result[index++] = i;
        }
        return result;
    }

    public static int[] intersectionII(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> intersectionMap = new HashMap<>();
        for (int i : nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                if (!intersectionMap.containsKey(i)) {
                    intersectionMap.put(i, 1);
                } else {
                    intersectionMap.put(i, intersectionMap.get(i) + 1);
                }
                map.put(i, map.get(i) - 1);
            }
        }
        Iterator iterator = intersectionMap.values().iterator();
        int resultSize = 0;
        while (iterator.hasNext()) {
            int val = (int) iterator.next();
            resultSize += val;
        }
        int result[] = new int[resultSize];
        int index = 0;
        int key, val;
        Iterator intersectionIterator = intersectionMap.entrySet().iterator();
        while (intersectionIterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry) intersectionIterator.next();
            key = entry.getKey();
            val = entry.getValue();
            for (int i = 0; i < val; i++) {
                result[index++] = key;
            }
        }
        return result;
    }


    public static void main(String args[]) {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        System.out.println("Their intersection is without repeats are :");
        int result[] = intersection(nums1, nums2);
        printArray(result);
        System.out.println("Their intersection is with repeats are :");
        result = intersectionII(nums1, nums2);
        printArray(result);
    }
}
