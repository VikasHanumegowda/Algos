import java.util.ArrayList;

/**
 * Created by sridharyadav on 10/10/17.
 */

//Given a non-negative number represented as an array of digits,
//
//        add 1 to the number ( increment the number represented by the digits ).
//
//        The digits are stored such that the most significant digit is at the head of the list.
//
//        Example:
//
//        If the vector has [1, 2, 3]
//
//        the returned vector should be [1, 2, 4]
//
//        as 123 + 1 = 124.

public class Problem33 {

    public static ArrayList<Integer> plusOne(ArrayList<Integer> input) {
        if(input.size() == 0 || input == null){
            return null;
        }
        while (input.size() > 0 && input.get(0) == 0){
            input.remove(0);
        }
        if(input.size() == 0){
            input.add(1);
            return input;
        }
        int carry = 1;
        int sum;
        for(int i = input.size() - 1; i >=0; i--){
            sum = (input.get(i) + carry);
            carry = sum / 10;
            input.remove(i);
            input.add(i, sum % 10);
        }
        if(carry != 0){
            input.add(0, carry);
        }
        return input;
    }

    public static void main(String args[]){
        ArrayList<Integer> input = new ArrayList<>();
        input.add(0);
//        input.add(9);
//        input.add(9);
//        input.add(9);
//        input.add(9);
//        input.add(9);
//        input.add(9);
//        input.add(9);
        System.out.println(plusOne(input));
    }
}
