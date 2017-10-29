/**
 * Created by sridharyadav on 10/6/17.
 */

//Given an array that contains both positive and negative integers, find the product of the maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.
//
//        Examples:
//
//        Input: arr[] = {6, -3, -10, 0, 2}
//        Output:   180  // The subarray is {6, -3, -10}
//
//        Input: arr[] = {-1, -3, -10, 0, 60}
//        Output:   60  // The subarray is {60}
//
//        Input: arr[] = {-2, -3, 0, -2, -40}
//        Output:   80  // The subarray is {-2, -40}

public class Problem24 {
    public static int maxProductSubArray(int array[]){
        int max_product = array[0];
        int product = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] != 0){
                product = product * array[i];
            }
            else{
                product = 1;
            }
            if(product > max_product){
                max_product = product;
            }
        }
        return max_product;
    }
    public static void main(String args[]) {
        int array[] = {-2, -3, 0, -2, -40};
        System.out.println("The product of the maximum product subarray is : " + maxProductSubArray(array));
    }
}
