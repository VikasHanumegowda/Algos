import java.util.Arrays;

/**
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 */
public class Problem102 {
    public static int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int table[] = new int[target + 1];
        table[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else if (num == i) {
                    table[i] = table[i] + 1;
                } else {
                    table[i] = table[i] + table[i - num];
                }
            }
        }
        return table[target];
    }

    public static void main(String args[]) {
        int array[] = {1, 2, 3};
        int target = 4;
        System.out.println("The number of possible combinations are : " + combinationSum4(array, target));
    }
}
