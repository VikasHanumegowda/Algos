/**
 * Multiple two strings
 */
public class Problem74 {
    public static String product(String firstNumber, String secondNumber) {
        int firstNumberLength = firstNumber.length();
        int secondNumberLength = secondNumber.length();
        int product[] = new int[firstNumberLength + secondNumberLength];
        int multiplication, currPos, carryPos, sum;
        for (int i = firstNumberLength - 1; i >= 0; i--) {
            for (int j = secondNumberLength - 1; j >= 0; j--) {
                multiplication = (firstNumber.charAt(i) - '0') * (secondNumber.charAt(j) - '0');
                currPos = i + j + 1;
                carryPos = i + j;
                sum = multiplication + product[currPos];
                product[currPos] = sum % 10;
                product[carryPos] += sum / 10;
            }
        }
        StringBuilder productString = new StringBuilder();
        for (int digit : product) {
            if (!(digit == 0 && productString.length() == 0)) {
                productString.append(digit);
            }
        }
        return productString.length() == 0 ? "0" : productString.toString();
    }

    public static void main(String args[]) {
        String a = "10";
        String b = "2";
        System.out.println(product(a, b));
    }
}
