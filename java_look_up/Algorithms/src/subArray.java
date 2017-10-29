/**
 * Created by sridharyadav on 2/3/16.
 */
public class subArray {
        public int maxSubArray(int[] A) {
            int max = A[0];
            int[] sum = new int[A.length];
            sum[0] = A[0];

            for (int i = 1; i < A.length; i++) {
                sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
                max = Math.max(max, sum[i]);
            }

            return max;
        }
    public static void main(String[] args){
        subArray obj = new subArray();
        int a[] = {76, 54, -32, 57, 36, -167, 89};
        System.out.println(obj.maxSubArray(a));
    }
    }
