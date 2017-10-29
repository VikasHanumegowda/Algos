/**
 * Find the maximum number that can be obtained by duplicating one of the digits adjacent to it.
 */
public class Problem53 {
    public static int returnNumber(int number) {
        if (number == 0) {
            return 0;
        }
        String num = String.valueOf(number);
        int curValue;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                curValue = Integer.parseInt(num.substring(0, i + 1) + num.charAt(i) + num.substring(i + 1, num.length()));
            } else {
                curValue = Integer.parseInt(num.substring(0, i + 2) + num.charAt(i + 1) + num.substring(i + 2, num.length()));
            }
            if (curValue > largest) {
                largest = curValue;
            }
        }
        return largest;
    }

    public static void main(String args[]) {
        System.out.println(returnNumber(12511));
    }
}
