import java.util.Arrays;
import java.util.Stack;
/**
 * Created by Meghana on 2/5/2016.
 */
public class ArrayManipulation {
    public static void main(String[] args) {
        int in[] = {1, 5, 7, 6, 3, 16, 29, 2, 7};
        int out[] = new int[9];
        int i, n = 9;
        Stack<Integer> stack = new Stack<Integer>();
        for (i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && in[i] <= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                out[i] = 0;
                stack.push(in[i]);
            }
            if (in[i] > stack.peek()) {
                out[i] = stack.peek();
                stack.push(in[i]);
            }
        }
        System.out.println(Arrays.toString(out));
    }
}