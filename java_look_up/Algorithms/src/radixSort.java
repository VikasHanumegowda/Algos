import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sridharyadav on 2/2/16.
 */
public class radixSort {
    public static void quick3Way(String[] a) {
        int lo = 0;				// the initial index
        int hi = a.length - 1;	// the last index
        int d = 0;

        quick3Way(a, lo, hi, d);
    }

    private static void quick3Way(String[] a, int lo, int hi, int d) {

        if ( hi < lo ) return;

        int i = lo + 1;
        int lt = lo; int gt = hi;
        // partitioning character
        int v = charAt(a[lo], d);

        while ( i <= gt ) {
            int t = charAt(a[i], d);
            if ( t < v ) exch( a, lt++, i++ );
            else if ( t > v ) exch( a, i, gt-- );
            else ++i;
        }

        quick3Way(a, lo, lt-1, d);
        if ( v >= 0 ) quick3Way(a, lt, gt, d+1);
        quick3Way(a, gt+1, hi, d);
    }

    private static void exch(String[] a, int i, int j) {
        String t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int charAt(String str, int d) {
        if ( d >= str.length()  ) return -1;
        return str.charAt(d);
    }
    public static void main(String[] args){
        radixSort rS = new radixSort();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String array[] = new String[n];
        for(int i = 0; i < n; i++){
            array[i] = scan.next();
        }
        rS.quick3Way(array);
        System.out.println(Arrays.toString(array));
    }
}
