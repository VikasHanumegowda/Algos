/**
 * Created by sridharyadav on 2/9/16.
 */
public class ArraySum {
    public static void main(String args[]){
        int digits[] = { 9, 9 ,9, 9};
        int result[] = addOne(digits);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
    public static final int[] addOne(int[] digits) {
        int carry = 5;
        int[] result = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            result[i] = val % 10;
            carry = val / 10;
        }
        if(carry == 0){
            return result;
        }
        int[] sum = new int[digits.length + 1];
        sum[0] = carry;
        for(int j = 0; j < result.length; j++){
            sum[j+1] = result[j];
        }
        return sum;
    }

}
