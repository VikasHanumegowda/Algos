import java.util.HashMap;
/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Example 1: Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1. ...
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class Problem81 {
    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < length; i++){
            sum += nums[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            else{
                maxLen = Math.max(maxLen, i - map.get(sum));
            }
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int nums[] = {0, 1, 1, 1, 1, 0, 0, 1, 0};
        System.out.println("The maximum length of a contiguous subarray with equal number of 0 and 1 is : ");
        System.out.print(findMaxLength(nums));
    }
}
