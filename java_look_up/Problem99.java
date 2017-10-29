import java.util.HashMap;

/**
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
 * that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 */
public class Problem99 {
    public static boolean hasContinuousSubArray(int array[], int k) {
        int length = array.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < length; i++) {
            sum += array[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int array[] = {2, 4};
        int k = 6;
        System.out.println(hasContinuousSubArray(array, k));
    }
}
