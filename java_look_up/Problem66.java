/**
 * How to find maximum sum of n consecutive numbers in an array in o(n)?
 */
public class Problem66 {
    public static int findMaxSum(int array[], int n) {
        int max = 0, sum;
        for (int i = 0; i < n; i++) {
            max += array[i];
        }
        sum = max;
        for (int i = n; i <= array.length - n; i++) {
            sum = sum - array[i - n] + array[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        int array[] = {1, 2, 3, 4, 2, 1, 1, 2, 3, 3, 4, 2, 1, 3, 3, 4, 3, 2, 1, 1};
        int n = 4;
        System.out.println("The maximum sum of n consecutive number is : " + findMaxSum(array, n));
    }
}
