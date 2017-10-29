/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Problem72 {
    public static void printArray(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    public static void moveZeroes(int array[]) {
        int length = array.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] != 0) {
                array[j++] = array[i];
            }
        }
        while (j < length) {
            array[j++] = 0;
        }
        printArray(array);
    }

    public static void main(String args[]) {
        int array[] = {0, 1, 0, 3, 12};
        moveZeroes(array);
    }
}
