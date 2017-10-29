public class shortestPath {


    /*public int countPathsRecursive(int n, int m){
        if(n == 1 || m == 1){
            return 1;
        }
        return countPathsRecursive(n-1, m) + countPathsRecursive(n, m-1);
    }*/

    public int countPaths(int a, int b, int n,int m){
        int T[][] = new int[n][m];
        for(int i=a; i < n; i++){
            T[i][0] = 1;
        }

        for(int i=b; i < m; i++){
            T[0][i] = 1;
        }
        for(int i=1; i < n; i++){
            for(int j=1; j < m; j++){
                T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }
        return T[n-1][m-1];
    }

    public static void main(String args[]){
        shortestPath nop = new shortestPath();
        char array[][] = new char[5][5];
        int  k = 97;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                array[i][j] = (char)k;
                k++;
            }
        }
        char x = 'a';
        int m1 = ((int) x - 97 )/ 5;
        int n1 = ((int) x - 97 )% 5;
        char y = 'g';
        int m2 = ((int) y - 97 )/ 5;
        int n2 = ((int) y - 97 )% 5;
        System.out.print(nop.countPaths(m1,n1,m2 + 1, n2+1));
    }

}