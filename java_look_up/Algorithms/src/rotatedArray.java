/**
 * Created by sridharyadav on 1/30/16.
 */
public class rotatedArray {
    static int search(int arr[], int l, int h, int key)
    {
        if (l > h) return -1;

        int mid = (l+h)/2;
        if (arr[mid] == key) return mid;

    /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid])
        {
        /* As this subarray is sorted, we can quickly
           check if key lies in half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid-1, key);

            return search(arr, mid+1, h, key);
        }

    /* If arr[l..mid] is not sorted, then arr[mid... r]
       must be sorted*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid+1, h, key);

        return search(arr, l, mid-1, key);
    }
    public static void main(String[] args){
        int arr[] = { 6,7,8,9,10,1,2,3,4,5};
        System.out.println(search(arr, 0, arr.length - 1, 3));
    }
}
