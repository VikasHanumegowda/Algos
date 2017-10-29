import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sridharyadav on 10/23/17.
 */
public class BucketSort {
    public static void sort(ArrayList<Integer> data) {
        if(data.size() == 0){
            return;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i : data) {
            maxVal = Math.max(maxVal, i);
        }
        int bucket[] = new int[maxVal + 1];
        for (int i : data) {
            bucket[i]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                data.set(index++, i);
            }
        }
    }

    public static void bucketSort(int data[]) {
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        for (int i : data) {
            if (i < 0) {
                negList.add(-1 * i);
            } else {
                posList.add(i);
            }
        }
        sort(posList);
        sort(negList);
        int index = 0;
        for (int i = negList.size() - 1; i >= 0; i--) {
            data[index++] = -1 * negList.get(i);
        }
        for (int i = 0; i < posList.size(); i++) {
            data[index++] = posList.get(i);
        }
    }

    public static void main(String args[]) {

        int[] data = {-5, 3, 0, 2, -4, 1, 0, 5, -2, 3, -1, 4};
        System.out.println("Before: " + Arrays.toString(data));
        bucketSort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }
}
