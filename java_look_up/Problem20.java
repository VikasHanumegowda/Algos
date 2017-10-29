/**
 * Created by sridharyadav on 10/5/17.
 */
//Maximum Length Bitonic Subarray | Set 1 (O(n) tine and O(n) space)
//        Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic if there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j]. Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
//        Expected time complexity of the solution is O(n)
public class Problem20 {
    public static int bitonic(int array[]) {
        int length = array.length;
        int max_inc_array[] = new int[length];
        int max_dec_array[] = new int[length];
        max_inc_array[0] = 1;
        max_dec_array[length - 1] = 1;
        int i;
        for (i = 1; i < length; i++) {
            max_inc_array[i] = (array[i] >= array[i - 1]) ? (max_inc_array[i - 1] + 1) : 1;
        }
        for (i = length - 2; i >= 0; i--) {
            max_dec_array[i] = (array[i] >= array[i + 1]) ? (max_dec_array[i + 1] + 1) : 1;
        }
        int bitonic_val = max_dec_array[0] + max_inc_array[0] - 1;
        for (i=0; i < length; i++){
            if((max_dec_array[i] + max_inc_array[i] - 1 ) > bitonic_val){
                bitonic_val = max_dec_array[i] + max_inc_array[i] -1;
            }
        }
        return bitonic_val;
    }

    public static void main(String args[]) {
        int array[] = {12, 4, 78, 90, 45, 23};
        System.out.println("The length of the maximum length bitonic subarray is : " + bitonic(array));
    }
}
