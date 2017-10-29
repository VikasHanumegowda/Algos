import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by sridharyadav on 10/8/17.
 */
//K’th Smallest/Largest Element in Unsorted Array | Set 1
//        Given an array and a number k where k is smaller than size of array,
//        we need to find the k’th smallest element in the given array.
//        It is given that ll array elements are distinct.
public class Problem32 {
    PriorityQueue<Integer> pq;

    Problem32(int k) {
        this.pq = new PriorityQueue<>(k, Collections.reverseOrder());
    }

    public int findKthSmallest(int array[], int k) {
        int i, n = array.length;
        for(i = 0; i < k && i < n; i++) {
            pq.add(array[i]);
        }
        for(; i < n; i++){
            if(array[i] < findMaxInHeap()){
                pq.poll();
                pq.add(array[i]);
            }
        }
        return findMaxInHeap();
    }

    public int findMaxInHeap(){
        return pq.peek();
    }

    public static void main(String args[]) {
        int array[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        Problem32 obj = new Problem32(k);
        System.out.println("K’th Smallest Element is : " + obj.findKthSmallest(array, k));
    }
}
