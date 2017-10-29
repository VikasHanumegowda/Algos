/**
 * Created by sridharyadav on 12/25/15.
 */
public class spiral {
    void print(int a[][], int m, int n){
        int k = 0, l = 0;
        int i;
        while( k < m && l < n){
            for(i = l; i < n; i++){
                System.out.print(a[k][i]+ " ");
            }
            k++;
            for(i = k; i < m; i++){
                System.out.print(a[i][n-1]+ " ");
            }
            n--;
            if( k < m){
                for(i = n-1; i >= l; i--){
                    System.out.print(a[m-1][i]+ " ");
                }
                m--;
            }
            if( l < n){
                for(i = m-1; i >= k; i--){
                    System.out.print(a[i][l]+ " ");
                }
                l++;
            }
        }
    }

    public static void main(String args[]){
        spiral s = new spiral();
        int a[][] = new int[][]{ {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}};

        s.print(a, 3, 6);
    }
}
