/**
 * Created by sridharyadav on 10/10/17.
 */
public class Problem36 {
    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String args[]) {
        int array[] = {10, 5, 5, 8};
        int length = array.length;
        // output 10, 5, 6, 2, 20, 3, 100, 80
        int temp;
        for (int i = 1; i < length; i += 2) {
            if (array[i] > array[i - 1]) {
                temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
            }
            if (i < length - 1 && array[i] > array[i + 1]) {
                temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        printArray(array);
    }
}
