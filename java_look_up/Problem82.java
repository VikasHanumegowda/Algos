import java.util.HashMap;

/**
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k,
 * that is, sums up to n*k where n is also an integer.
 */
public class Problem82 {
    public static boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;
        int diff = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                diff = sum % k;
            }
            if (map.containsKey(diff)) {
                if (i - map.get(diff) > 1)
                    return true;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }
        return false;
    }

    public static void main(String args[]) {
        int nums[] = {23, 2, 6, 4, 7};
        int k = 3;
        System.out.println(checkSubarraySum(nums, k));
    }
}
