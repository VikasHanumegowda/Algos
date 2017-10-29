/**
 * Created by sridharyadav on 10/5/17.
 */

//Rearrange an array in maximum minimum form | Set 2 (O(1) extra space)
//        Given a sorted array of positive integers, rearrange the array alternately i.e first element should be the maximum value, second minimum value, third-second max, fourth-second min and so on.
//
//        Examples:
//
//        Input  : arr[] = {1, 2, 3, 4, 5, 6, 7}
//        Output : arr[] = {7, 1, 6, 2, 5, 3, 4}
//
//        Input  : arr[] = {1, 2, 3, 4, 5, 6}
//        Output : arr[] = {6, 1, 5, 2, 4, 3}
//        We have discussed a solution in below post:
//        Rearrange an array in maximum minimum form | Set 1 : The solution discussed here requires extra space, how to solve this problem with O(1) extra space.
public class Problem19 {
    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void rearrangeArray(int array[]) {
        int length = array.length;
        int max_index = length - 1;
        int min_index = 0;
        int i;
        int max_element = array[max_index] + 1;
        for (i = 0; i < length; i++) {
            if (i % 2 == 0) {
                array[i] += array[max_index] % max_element * max_element;
                max_index--;
            } else {
                array[i] += array[min_index] % max_element * max_element;
                min_index++;
            }
        }
        for (i = 0; i < length; i++) {
            array[i] /= max_element;
        }
    }

    public static void main(String args[]) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rearrangeArray(array);
        printArray(array);

    }
}
