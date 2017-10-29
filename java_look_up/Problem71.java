/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class Problem71 {

    public static int removeDuplicates(int array[]) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int j = 1;
        for(int i = 1; i < length; i++){
            if(array[i] != array[i-1]){
                array[j++] = array[i];
            }
        }
        return j;
    }

    public static void main(String args[]) {
        int array[] = {1,1,1,2};
        System.out.println(removeDuplicates(array));
    }
}
