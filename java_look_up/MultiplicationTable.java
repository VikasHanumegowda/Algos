/**
 * Given the height m and the length n of a m * n Multiplication Table,
 * and a positive integer k, you need to return the k-th smallest number in this table.
 * <p>
 * Example 1:
 * Input: m = 3, n = 3, k = 5
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 */
public class MultiplicationTable {

    public static int findKthSmallest(int m, int n, int k) {
        int low = 0, high = (m * n) + 1;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int c = count(mid, m, n);
            if (c >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    /* Count all the values smaller or than equal to v in each row
     * The min is for the count not to exceed the number of columns
     * in each row.
     */
    public static int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(v / i, n);
            count += temp;
        }
        return count;
    }

    public static void main(String args[]) {
        int m = 3, n = 3, k = 5;
        System.out.println("The kth smallest number is : " + findKthSmallest(m, n, k));
    }

}
