/**
 * Created by sridharyadav on 10/14/17.
 * Find missing number in a sorted array
 */
public class Problem61 {
    public static int findMissing(int array[]) {
        int low = 0, high = array.length;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (array[mid] - array[0] == mid) {
                low = mid + 1;
            } else {
                if (array[mid - 1] - array[0] == mid - 1) {
                    return array[mid - 1] + 1;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int array[] = {20, 21, 22, 23, 24, 25, 26, 27, 28, 30};
        System.out.print(findMissing(array));
    }

}
