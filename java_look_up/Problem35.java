/**
 * Created by sridharyadav on 10/10/17.
 */
//Author:     King, wangjingui@outlook.com
//Date:       Dec 12, 2014
//        Problem:    Add Binary
//        Difficulty: Easy
//        Source:     https://oj.leetcode.com/problems/add-binary/
//        Notes:
//        Given two binary strings, return their sum (also a binary string).
//        For example,
//        a = "11"
//        b = "1"
//        Return "100".
//        Solution: '1'-'0' = 1.
//        */
//public class     AddBinary {
//    public static void main(String args[]){
//        String a = "11";
//        String b = "1";
public class Problem35 {
    public static String addTwoBinary(String a, String b){
        int l = a.length() - 1;
        int r = b.length() - 1;
        int sum = 0, carry = 0;
        StringBuffer sb = new StringBuffer();
        while (l >= 0 && r >= 0){
            sum = a.charAt(l--) - '0' + carry;
            sum += b.charAt(r--) - '0';
            carry = sum / 2;
            sb.insert(0, sum % 2);
        }
        while (l >= 0){
            sum = a.charAt(l--) - '0' + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
        }
        while (r >= 0){
            sum = a.charAt(r--) - '0' + carry;
            carry = sum / 2;
            sb.insert(0, sum % 2);
        }
        if(carry > 0){
            sb.insert(0, carry);
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        String a = "1";
        String b = "11";
        System.out.println(addTwoBinary(a, b));
    }
}
