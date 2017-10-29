/**
 * Created by sridharyadav on 10/6/17.
 */

//Replace every element with the greatest element on right side
//        Given an array of integers, replace every element with the next greatest element
//        (greatest element on the right side) in the array.
//        Since there is no element next to the last element, replace it with -1.
//        For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.
public class Problem25 {

    public static void printArray(int array[], int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void replaceArrayElemsWithGreatestRightElem(int array[], int length) {
        int max_elem_right = array[length - 1];
        array[length - 1] = -1;
        int temp;
        for (int i = length - 2; i >= 0; i--) {
            temp = max_elem_right;
            if (array[i] > max_elem_right) {
                max_elem_right = array[i];
            }
            array[i] = temp;
        }
        printArray(array, length);
    }


    public static void main(String args[]) {
        int array[] = {16, 17, 4, 3, 5, 2};
        int length = array.length;
        replaceArrayElemsWithGreatestRightElem(array, length);
    }
}
