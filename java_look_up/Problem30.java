import java.util.PriorityQueue;

/**
 * Created by sridharyadav on 10/7/17.
 */
//Sort a nearly sorted(or K sorted)array
//        Given an array of n elements,where each element is at most k away from its target position,
//        devise an algorithm that sorts in O(n log k)time.
//        For example,let us consider k is 2,an element at index 7in the sorted array,
//        can be at indexes 5,6,7,8,9in the given array.


public class Problem30 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }

    public static void sortNearlySortedArray(int array[], int k) {
        int n = array.length;
        int outputArray[] = new int[n];
        int i = 0;
        for (; i < k + 1 && i < n; i++) {
            pq.add(array[i]);
        }
        int j = 0;
        outputArray[j++] = getMinElement();
        for(; i < n; i++) {
            pq.add(array[i]);
            outputArray[j++] = getMinElement();
        }
        while (!pq.isEmpty()){
            outputArray[j++] = pq.poll();
        }
        printArray(outputArray);
    }

    public static int getMinElement() {
        return pq.poll();
    }

    public static void main(String args[]) {
        int k = 3;
        int array[] = {2, 6, 3, 12, 56, 8};
        sortNearlySortedArray(array, k);
    }
}
