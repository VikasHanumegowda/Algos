import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-distance/
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * <p>
 * If there is no solution possible, return -1.
 * <p>
 * Example :
 * <p>
 * A : [3 5 4 2]
 * <p>
 * Output : 2
 * for the pair (3, 4)
 */
public class Problem60 {
    public static int findMinIndex(int minLeft[], int num) {
        int lo = 0, high = minLeft.length;
        int mid, index = -1;
        while (lo <= high) {
            mid = lo + (high - lo) / 2;
            if (num < minLeft[mid]) {
                lo = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }

    public static int findMaximumGap(List<Integer> input) {
        int maxGap = -1;
        int length = input.size();
        int minLeft[] = new int[length];
        int maxRight[] = new int[length];
        minLeft[0] = input.get(0);
        int i;
        for (i = 1; i < length; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], input.get(i));
        }
        maxRight[length - 1] = input.get(length - 1);
        for (i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], input.get(i));
        }
        for (int j = length - 1; j >= 0; j--) {
            i = findMinIndex(minLeft, maxRight[j]);
            maxGap = Math.max(maxGap, j - i);
        }
        return maxGap;
    }

    public static void main(String args[]) {
        final List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(5);
        input.add(4);
        input.add(2);
        System.out.println(findMaximumGap(input));
    }

}
