/**
 * Created by sridharyadav on 10/15/17.
 */
public class Problem75 {
    public static int findQuotient(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MIN_VALUE;
        }
        int result = 0;
        int numShifts;
        int pDividend = Math.abs(dividend);
        int pDivisor = Math.abs(divisor);
        while (pDividend >= pDivisor) {
            numShifts = 0;
            while (pDividend >= (pDivisor << numShifts)) {
                numShifts++;
            }
            result += (1 << (numShifts - 1));
            pDividend -= (pDivisor << (numShifts - 1));
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        }

        return Math.abs(result);
    }

    public static void main(String args[]) {
        int a = 169;
        int b = 13;
        System.out.println(findQuotient(a, b));
    }
}
