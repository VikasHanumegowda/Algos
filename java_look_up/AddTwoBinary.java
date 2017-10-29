/**
 * Created by sridharyadav on 10/21/17.
 */
public class AddTwoBinary {
    public String addBinary(String a, String b) {
        if ((a == null && b == null) || (a.length() == 0 && b.length() == 0)) {
            return "0";
        }
        int aLength = a.length();
        int bLength = b.length();
        if (a == null || aLength == 0) {
            return b;
        }
        if (b == null || bLength == 0) {
            return a;
        }
        StringBuffer sb = new StringBuffer();
        int i = aLength - 1, j = bLength - 1;
        int sum;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            sum = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, String.valueOf(sum));
        }
        while (i >= 0) {
            sum = a.charAt(i--) - '0' + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, String.valueOf(sum));
        }
        while (j >= 0) {
            sum = b.charAt(j--) - '0' + carry;
            carry = sum / 2;
            sum = sum % 2;
            sb.insert(0, String.valueOf(sum));
        }
        if(carry > 0){
            sb.insert(0, String.valueOf(carry));
        }
        return sb.toString();
    }

    public static void main(String arg[]) {
        AddTwoBinary obj = new AddTwoBinary();
        System.out.println("The sum is : " + obj.addBinary("1010", "1011"));
    }
}

