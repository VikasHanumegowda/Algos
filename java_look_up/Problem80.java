/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Problem80 {

    public static int findMaxProfit(int prices[]) {
        int maxProfit = 0;
        int length = prices.length;
        int l2r[] = new int[length];
        int r2l[] = new int[length];
        int minLeft = prices[0], maxRight = prices[length - 1];
        int i;
        for (i = 1; i < length; i++) {
            l2r[i] = Math.max(l2r[i - 1], prices[i] - minLeft);
            minLeft = Math.min(minLeft, prices[i]);
        }

        for (i = length - 2; i >= 0; i--) {
            r2l[i] = Math.max(r2l[i + 1], maxRight - prices[i]);
            maxRight = Math.max(maxRight, prices[i]);
        }

        for (i = 0; i < length - 1; i++) {
            maxProfit = Math.max(maxProfit, l2r[i] + r2l[i + 1]);
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int[] prices = {10, 20, 8, 25, 28, 43};
        System.out.println(findMaxProfit(prices));
    }
}
