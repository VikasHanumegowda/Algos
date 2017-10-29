/**
 * Created by sridharyadav on 10/6/17.
 */

//Minimum number of swaps required for arranging pairs adjacent to each other
// There are n-pairs and therefore 2n people. everyone has one unique number ranging from 1 to 2n.
// All these 2n persons are arranged in random fashion in an Array of size 2n. We are also given who is partner of whom.
// Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.
//
//        Example:
//
//        Input:
//        n = 3
//        pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
//        arr[] = {3, 5, 6, 4, 1, 2}
//
//        Output: 2
//        We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1
public class Problem27 {

    public static void swap(int i, int j, int array[]) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int findMinSwaps(int array[], int pairs[], int index[], int number_pairs, int start) {
        if (number_pairs == 0) {
            return 0;
        }
        if (pairs[array[start]] == array[start + 1]) {
            return findMinSwaps(array, pairs, index, number_pairs - 1, start + 2);
        }

        int i = index[pairs[array[start]]];
        swap(i, start + 1, array);
        int a = findMinSwaps(array, pairs, index, number_pairs - 1, start + 2);
        swap(i, start + 1, array);

        int j = index[pairs[array[start + 1]]];
        swap(start, j, array);
        int b = findMinSwaps(array, pairs, index, number_pairs - 1, start + 2);
        swap(start, j, array);

        return Math.min(a, b) + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 6, 4, 1, 2};
        int[] pairs = new int[]{-1, 3, 6, 1, 5, 4, 2};
        int number_pairs = arr.length / 2;
        int[] index = new int[2 * number_pairs + 1];
        for (int i = 0; i < 2 * number_pairs; i++) {
            index[arr[i]] = i;
        }
        System.out.println("Minimum number of swaps required for arranging pairs adjacent to each other is : " + findMinSwaps(arr, pairs, index, number_pairs, 0));
    }
}
