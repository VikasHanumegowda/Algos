public class MaximumSumSubsequence {

    public void maxSum(int arr[]){
        int T[] = new int[arr.length+1];

        for(int i=1; i < T.length; i++){
            T[i] = arr[i-1];
        }

        for(int i=1; i < T.length; i++){
            for(int j = 1; j <i; j++){
                if(arr[i-1] > arr[j-1]){
                    T[i] = Math.max(T[i], T[j] + arr[i-1]);
                }
            }
        }

        int max = 0;
        for(int i=1; i <= arr.length; i++){
            if(T[i] > max){
                max = T[i];
            }
        }
        System.out.println("Length of MSS is " + max);
        System.out.println("MSS is:");
        printLIS(T,arr.length,arr,max);
    }
    public static void printLIS(int[] lis, int lisIndex, int[] arr, int max) {
        if(max == 0) {
            return;
        }
        if(lis[lisIndex] == max) {
            printLIS(lis, lisIndex - 1, arr, max - arr[lisIndex-1]);
            System.out.print(arr[lisIndex-1] + " ");
        } else {
            printLIS(lis, lisIndex - 1, arr, max);
        }

    }
    public static void main(String args[]){
        MaximumSumSubsequence mss = new MaximumSumSubsequence();
        int arr[] = {1,101,10,2,3,100,4};
        mss.maxSum(arr);
    }
}