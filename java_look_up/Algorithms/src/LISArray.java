/**
 * Created by sridharyadav on 2/5/16.
 */
public class LISArray {
    static void lis( int arr[], int n )
    {
        int lis[] = new int[n];
        int i, j, max = 0;
   /* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

   /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1 && i - j != 1)
                    lis[i] = lis[j] + 1;

   /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];
        System.out.println("Length of LIS is " + max);
                System.out.println("LIS is:");
        printLIS(lis,n-1,arr,max);

    }

    public static void printLIS(int[] lis, int lisIndex, int[] arr, int max) {
        if(max == 0) {
            return;
        }
        if(lis[lisIndex] == max) {
            printLIS(lis, lisIndex - 2, arr, max - 1);
            System.out.print(arr[lisIndex] + " ");
        } else {
            printLIS(lis, lisIndex - 2, arr, max);
        }

    }

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        lis(arr, n);
    }
}
