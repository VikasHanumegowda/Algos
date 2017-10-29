import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by sridharyadav on 10/7/17.
 */

//k largest(or smallest) elements in an array | added Min Heap method
//        Question: Write an efficient program for printing k largest elements in an array.
//        Elements in array can be in any order.
//
//        For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements i.e., k = 3 then your program should print 50, 30 and 23.

public class Problem28 {
    public static void kLargest(int array[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i;
        for(i = 0; i < array.length; i++){
            pq.add(array[i]);
        }
        for(i = 0; i < k; i++){
            System.out.print(pq.poll() + " ");
        }
    }
    public static void main(String[] args) {
        int array[] = {1, 23, 12, 9,
                30, 2, 50};
        int k = 3;
        kLargest(array, k);
    }

}
