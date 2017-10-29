/**
 * Created by sridharyadav on 10/4/17.
 */
//Given a sorted and rotated array, find if there is a pair with a given sum
//http://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
public class Problem17 {
    public static boolean pairInSortedRotated(int arr[], int n, int sum) {
        int i, l, r;
        for (i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        l = (i + 1) % n;
        r = i;
        while (l != r) {
            if (arr[l] + arr[r] == sum) {
                return true;
            } else if (arr[l] + arr[r] < sum) {
                l = (l + 1) % n;
            } else {
                r = (n + r - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        int n = arr.length;

        if (pairInSortedRotated(arr, n, sum))
            System.out.print("Array has two elements" +
                    " with sum 16");
        else
            System.out.print("Array doesn't have two" +
                    " elements with sum 16 ");
    }
}
