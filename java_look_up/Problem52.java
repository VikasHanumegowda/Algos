/**
 * Created by sridharyadav on 10/13/17.
 * <p>
 * <p>
 * Problem:    First Missing Positive
 * Difficulty: Medium
 * Source:     https://oj.leetcode.com/problems/first-missing-positive/
 * Notes:
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * Solution: Although we can only use constant space, we can still exchange elements within input A!
 * Swap elements in A and try to make all the elements in A satisfy: A[i] == i + 1.
 * Pick out the first one that does not satisfy A[i] == i + 1.
 */

public class Problem52 {
    public static int findMissingPositive(int array[]) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            while (array[i] > 0 && array[i] <= array.length && array[i] != array[array[i] - 1]) {
                int temp = array[i];
                array[i] = array[temp - 1];
                array[temp - 1] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            if (array[i] != i + 1){
                return i+1;
            }
        }
        return length+1;
    }

    public static void main(String args[]) {
        int array[] = {3, 4, -1, 1};
        System.out.println("The first missing positive number is : " + findMissingPositive(array));
    }
}
