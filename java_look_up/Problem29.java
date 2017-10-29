import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sridharyadav on 10/7/17.
 */

//Merge k sorted arrays | Set 1
//        Given k sorted arrays of size n each, merge them and print the sorted output.
//
//        Example:
//
//        Input:
//        k = 3, n =  4
//        arr[][] = { {1, 3, 5, 7},
//        {2, 4, 6, 8},
//        {0, 9, 10, 11}} ;
//
//        Output: 0 1 2 3 4 5 6 7 8 9 10 11
public class Problem29 {
    static PriorityQueue<arrayElement> pq = new PriorityQueue<arrayElement>(new Comparator<arrayElement>() {

        public int compare(arrayElement obj1, arrayElement obj2) {
            if(obj1.value > obj2.value){
                return 1;
            }
            else if(obj1.value < obj2.value){
                return -1;
            }
            else{
                return 0;
            }
        }
    });
    static class arrayElement {
        int value;
        int whichArray;
        int positionWithinArray;

        arrayElement(int value, int whichArray, int positionWithinArray) {
            this.value = value;
            this.whichArray = whichArray;
            this.positionWithinArray = positionWithinArray;
        }
    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sortKArrays(int array[][], int k, int n) {
        int outputArray[] = new int[n * k];
        for (int i = 0; i < k; i++) {
            pq.add(new arrayElement(array[i][0], i, 0));
        }
        for(int j = 0; j < n*k; j++){
            arrayElement minElement = getMinimum();
            outputArray[j] = minElement.value;
            if(minElement.positionWithinArray + 1 < n) {
                pq.add(new arrayElement(array[minElement.whichArray][minElement.positionWithinArray + 1], minElement.whichArray, minElement.positionWithinArray + 1));
            }
        }
        printArray(outputArray);
    }

    public static arrayElement getMinimum(){
       return pq.poll();
    }

    public static void main(String args[]) {
        int array[][] = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};
        int k = 3, n = 4;
        sortKArrays(array, k, n);

    }
}

