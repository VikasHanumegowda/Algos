/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 */
public class Problem96 {
    public static int maximumSwap(int num) {
        char digits[] = String.valueOf(num).toCharArray();
        int bucket[] = new int[10];
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            bucket[digits[i] - '0'] = i;
        }
        for (int i = 0; i < length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (bucket[k] > i) {
                    char temp = digits[i];
                    digits[i] = digits[bucket[k]];
                    digits[bucket[k]] = temp;
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }
        return num;
    }

    public static void main(String args[]) {
        System.out.println(maximumSwap(2736));
    }
}
