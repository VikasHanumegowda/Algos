/**
 * Created by sridharyadav on 12/25/15.
 */
public class threeNumbers {
    public static void main(String args[]){
        threeNumbers obj = new threeNumbers();
        int a[] = {-1,-9,7,-3,-4,10};
        System.out.print(obj.findProduct(a));
    }
    int findProduct(int a[]){
        int n = a.length;
        if(n < 3)
            return -1;
        int max_1 = a[0];
        int min_1 = max_1;
        int max_2 = Integer.MIN_VALUE;
        int max_3 = max_2;
        int min_2 = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(max_1 < a[i]){
                max_3 = max_2;
                max_2 = max_1;
                max_1 = a[i];
            }
            else if(max_2 < a[i]){
                max_3 = max_2;
                max_2 = a[i];
            }
            else if(max_3 < a[i]){
                max_3 = a[i];
            }

            if(min_1 > a[i]){
                min_2 = min_1;
                min_1 = a[i];
            }
            else if(min_2 > a[i]){
                min_2 = a[i];
            }

        }
        return  max_1 * Integer.max( min_1 * min_2,  max_2 * max_3);

    }
}
