/**
 * Created by sridharyadav on 10/4/17.
 */
//http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
public class Problem15 {

    public static int search(int arr[], int l, int r, int key) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[l] <= arr[mid]) {
                if (arr[l] <= key && arr[mid] >= key) {
                    return search(arr, l, mid - 1, key);
                }
                return search(arr, mid + 1, r, key);
            } else {
                if (arr[mid] <= key && arr[r] >= key) {
                    return search(arr, mid + 1, r, key);
                }
                return search(arr, l, mid - 1, key);
            }
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 2;
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}
