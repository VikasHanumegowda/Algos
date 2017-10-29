/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * <p>
 * Solution :
 * <p>
 * Find a subset of numbers P and a subset of numbers N,
 * such that sum(P) - sum(N) = target
 * Now add sum(P) + sum(N) on both sides,
 * 2 * sum(P) = target + sum(P) + sum(N)
 * sum(P) = (target + sum(nums)) / 2
 * So find a subset satisfying such a scenario.
 */
public class Problem100 {
    public static int findNumberOfWays(int nums[], int target) {
        int table[] = new int[target + 1];
        table[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                table[i] = table[i] + table[i - num];
            }
        }
        return table[target];
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 > 0) {
            return 0;
        }
        return findNumberOfWays(nums, (target + sum) / 2);
    }

    public static void main(String args[]) {
        int array[] = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println("The number of ways are : " + findTargetSumWays(array, target));
    }
}
