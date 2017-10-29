/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 */
public class Problem103 {
    public static boolean increasingTriplet(int[] arr) {
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
        for (int k : arr) {
            if(k <= i){
                i = k;
            }
            else if (k <= j){
                j = k;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {2, 1, 5, 0, 3};
        System.out.println(increasingTriplet(arr));
    }
}
