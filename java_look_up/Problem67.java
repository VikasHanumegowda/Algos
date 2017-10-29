import java.util.HashSet;

/**
 * Created by sridharyadav on 10/15/17.
 */
public class Problem67 {

    public static int findLongestConseqSubseq(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        int longestConseqSubseq = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                int left = arr[i] - 1;
                int right = arr[i] + 1;
                int count = 1;
                while (set.contains(left)) {
                    count++;
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    count++;
                    set.remove(right);
                    right++;
                }
                set.remove(arr[i]);
                longestConseqSubseq = Math.max(longestConseqSubseq, count);
            }
        }
        return longestConseqSubseq;
    }

    public static void main(String args[]) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " +
                findLongestConseqSubseq(arr, n));
    }
}
