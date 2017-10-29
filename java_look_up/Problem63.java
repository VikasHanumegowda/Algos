import java.util.ArrayList;

/**
 * Created by sridharyadav on 10/14/17.
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 * <p>
 * Examples:
 * <p>
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 * <p>
 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class Problem63 {

    public static ArrayList<Integer> count(int coins[], int m, int V) {
        int table[] = new int[V + 1];
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            output.add(new ArrayList<Integer>());
        }
        table[0] = 0;
        for (int i = 1; i <= V; i++) {
            table[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++) {
                if (coins[j] <= i) {
                    int subResult = table[i - coins[j]];
                    if (subResult != Integer.MAX_VALUE && table[i] > subResult + 1) {
                        table[i] = subResult + 1;
                        output.get(i).clear();
                        output.get(i).addAll(output.get(i - coins[j]));
                        output.get(i).add(coins[j]);
                    }
                }
            }
        }
        return output.get(V);
    }

    public static void main(String args[]) {
        int[] coins = {1, 5, 9, 9};
        System.out.print(count(coins, coins.length, 18));
    }
}
