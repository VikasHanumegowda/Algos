/**
 * Created by sridharyadav on 1/30/16.
 */
public class mergeSortArray {
    public static void main(String args[]){
        int a[] = new int[10];
        int i;
        for(i = 0; i <5; i++){
            a[i]= i+1;
        }
        i = i-1;
        int b[] = {6,7,8,9,10};
        int j = b.length - 1;
        int k = i + j + 1;
        while( k >= 0){
            if( j < 0 || i >= 0 && a[i] > b[j]){
                a[k--] = a[i--];
            }
            else
                a[k--] = b[j--];
        }
        for(i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
