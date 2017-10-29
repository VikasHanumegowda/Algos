import java.util.*;
public class array {
    public int[] print(int a[]){
        int n = a.length;
        int result[] = new int[n];
        result[0] = a[0] * a[1];
        for(int i = 1; i < n-1; i++){
            result[i] = a[i-1] * a[i+1];
        }
        result[n-1] = a[n-1] * a[n-2];
        return result;
    }
    public static void main(String args[]){
        array a = new array();
        int s[] = {2, 3, 4, 5, 6};
        System.out.print(Arrays.toString(a.print(s)));
    }
}