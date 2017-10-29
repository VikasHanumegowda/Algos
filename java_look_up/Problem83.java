/**
 * Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 */
public class Problem83 {
    public static int findLongestContinuousIncreasingSubsequence(int array[]) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int maxIncreasingLen = 1;
        int increasingLen = 1;
        for (int i = 1; i < length; i++) {
            if (array[i] > array[i - 1]) {
                increasingLen++;
            } else {
                increasingLen = 1;
            }
            maxIncreasingLen = Math.max(maxIncreasingLen, increasingLen);
        }
        return maxIncreasingLen;
    }

    public static void main(String args[]) {
        int array[] = {1, 3, 5, 4, 7, 8, 9};
        System.out.println(findLongestContinuousIncreasingSubsequence(array));
    }
}
