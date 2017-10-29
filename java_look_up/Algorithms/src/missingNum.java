/**
 * Created by sridharyadav on 12/22/15.
 */
public class missingNum {

    public static int missing_number(int range, int a[]) {
        int sum = range * (range + 1) / 2;
        for (int i = 0; i < a.length; i++) {
            sum = sum - a[i];
        }
        return sum;
    }
    public static void main(String args[]){
        int a[] = {4, 3, 1};
        System.out.print(missing_number(4, a));
    }
}