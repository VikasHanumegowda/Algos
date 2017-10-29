import java.util.Stack;

/**
 * Created by sridharyadav on 10/13/17.
 */
public class Problem59 {
    public static int longestValidParentheses(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int last = -1;
        char ch;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - last);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        System.out.println(longestValidParentheses(")()))"));
    }
}
