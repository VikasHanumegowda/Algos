/*Number of Binary representations with n digits having no consecutive 1s*/
public class CountNumberOfBinaryWithoutConsecutive1s {
    public int count(int n){
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = 1;
        b[0] = 1;
        for(int i=1; i < n; i++){
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1] + b[n-1];
    }
    public static void main(String args[]){
        CountNumberOfBinaryWithoutConsecutive1s cnb = new CountNumberOfBinaryWithoutConsecutive1s();
        System.out.println(cnb.count(6));
    }
}
