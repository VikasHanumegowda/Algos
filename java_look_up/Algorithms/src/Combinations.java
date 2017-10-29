/**
 * Created by sridharyadav on 12/22/15.
 */
public class Combinations {
    void printSum(int candidates[], int index[], int n) {
        for (int i = 1; i <= n; i++)
            System.out.print(candidates[index[i]] + ((i == n) ? "" : "+"));
        System.out.println();
    }

    void solve(int target, int sum, int candidates[], int sz, int index[], int n) {
        if (sum > target)
            return;
        if (sum == target)
            printSum(candidates, index, n);

        for (int i = index[n]; i < sz; i++) {
            index[n+1] = i;
            solve(target, sum + candidates[i], candidates, sz, index, n+1);
        }
    }

    void solve(int target, int candidates[], int sz) {
        int index[] = new int[1000];
        solve(target, 0, candidates, sz, index, 0);
    }

    public static void main( String args[]){
        Combinations c = new Combinations();
        int target = 7;
        int candidates[] = {1,3,6,7};
        c.solve(target, candidates, candidates.length);
    }
}
