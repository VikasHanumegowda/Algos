/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Try to solve it in linear time/space. Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class Problem65 {
    public static class Bucket {
        int low;
        int high;

        Bucket() {
            this.low = -1;
            this.high = -1;
        }
    }

    public static int findMaximumGap(int arr[]) {
        int length = arr.length;
        if (arr == null || length < 2) {
            return 0;
        }

        int i, min, max, maxGap = Integer.MIN_VALUE;
        min = max = arr[0];

        for (i = 1; i < length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        Bucket buckets[] = new Bucket[length + 1];
        for (i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        double interval = (double) length / (max - min);
        int index;
        for (i = 0; i < length; i++) {
            index = (int) ((arr[i] - min) * interval);
            if (buckets[index].low == -1) {
                buckets[index].low = arr[i];
                buckets[index].high = arr[i];
            } else {
                buckets[index].low = Math.min(buckets[index].low, arr[i]);
                buckets[index].high = Math.max(buckets[index].high, arr[i]);
            }
        }
        int prev = buckets[0].high;
        for (i = 1; i < buckets.length; i++) {
            if (buckets[i].low != -1) {
                maxGap = Integer.max(maxGap, buckets[i].low - prev);
                prev = buckets[i].high;
            }
        }
        return maxGap;
    }

    public static void main(String args[]) {
        int arr[] = {12, 14, 21, 15, 17, 17};
        System.out.println(findMaximumGap(arr));
    }
}
