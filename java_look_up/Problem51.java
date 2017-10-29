/**
 * /*
 * Problem:    Find Peak Element
 * Difficulty: Medium
 * Source:     https://oj.leetcode.com/problems/find-peak-element/
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * Find the peak element.
 */
public class Problem51 {
    public static int findPeakElement(int array[]) {
        int low = 0, high = array.length;
        int mid;
        while (low < high) {
            mid = (high + low) / 2;
            if (array[mid] < array[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String args[]) {
        int array[] = {1, 2, 3, 1};
        System.out.println("The peak element is : " + findPeakElement(array));
    }
}
