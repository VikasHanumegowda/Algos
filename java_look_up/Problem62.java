import java.util.ArrayList;

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous.
 * That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * <p>
 * Example:
 * <p>
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */
public class Problem62 {
    public static ArrayList<Integer> findMaxSet(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        long sum = 0;
        int length = input.size();
        int element;
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            element = input.get(i);
            if (element >= 0) {
                temp.add(element);
                sum += element;
            }
            if (element < 0 || i == length - 1) {
                if (sum > maxSum) {
                    maxSum = sum;
                    output = temp;
                }
                temp = new ArrayList<>();
                sum = 0;
            }

        }
        return output;
    }

    public static void main(String args[]) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(756898537);
        input.add(-1973594324);
        input.add(-2038664370);
        input.add(-184803526);
        input.add(1424268980);
        System.out.println(findMaxSet(input));
    }
}
