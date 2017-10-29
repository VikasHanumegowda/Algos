/**
 * Created by sridharyadav on 10/4/17.
 */
// http://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
public class Problem14 {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void cyclicRotate(int arr[]) {
        int length = arr.length;
        int firstElement = arr[length - 1];
        for (int i = length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = firstElement;
        printArray(arr);
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        cyclicRotate(arr);
    }
}
