/**
 * Created by sridharyadav on 10/15/17.
 */
public class Problem69 {
    public static int helper(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x % 1337;
        }
        return helper(x % 1337, n / 2) * helper(x % 1337, n - n / 2) % 1337;
    }

    public static int superPow(int a, int[] b) {
        int result = 1;
        for (int i = 0; i < b.length; i++) {
            result = helper(result, 10) * helper(a, b[i]) % 1337;
        }
        return result;
    }

    public static void main(String args[]) {
        int a = 2147483647;
        int b[] = {2, 0, 0};
        System.out.println(superPow(a, b));
    }
}

