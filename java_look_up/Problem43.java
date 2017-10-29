/**
 * Created by sridharyadav on 10/11/17.
 */
public class Problem43 {

    public static int shift(int pos, int array[], int n){
        return (pos + array[pos] + n) % n;
    }
    public static boolean isCircular(int array[], int n ){
        for(int i = 0; i < n; i++){
            if(array[i] == 0){
                continue;
            }
            int j = i;
            int k = shift(j, array, n);
            while(array[i] * array[k] > 0 && array[i] * array[shift(k, array, n)] > 0){
                if(j == k){
                    if(j == shift(j, array, n)){
                        break;
                    }
                    return true;
                }
                j = shift(j, array, n);
                k = shift(shift(k, array, n), array, n);
            }

            j = i;
            int val = array[j];
            while (array[j] * val > 0){
                int pos = shift(j, array, n);
                array[j] = 0;
                j = pos;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int array[] = {2, -1, 1, 2, 2};
        int n = array.length;
        System.out.println(isCircular(array, n));
    }
}
