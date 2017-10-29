/**
 * Created by sridharyadav on 2/6/16.
 */
import java.util.*;
public class oneZeroContiguous {
    static void maxSubArraySum(int a[], int b[], int size)
    {
        int sum = 0;
        int start_pos = 0, end_pos = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < size; i++)
        {
            if(a[i] == 1){
                stack.push(a[i]);
            }
            if(!stack.isEmpty() && b[i] == 1){
                stack.pop();
                sum++;
                end_pos = i;
            }
        }
        if(!stack.isEmpty()){
            start_pos = stack.size();
        }
        System.out.println("Maximum contiguous sum is " +  sum + " and their positions are "+start_pos + " and "+end_pos);
    }

    public static void main(String[] args) {

        int b[] = {1,1,0,0,0,0};
        int a[] = {1,0,0,0,1,1};
        int n = a.length;
        maxSubArraySum(a, b, n);
    }

}
