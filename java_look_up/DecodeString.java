import java.util.Stack;

/**
 * Decode String (Java)
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public static String decodeString(String s) {
        String result = "";
        Stack<Integer> repeatStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        char ch;
        int i = 0;
        while (i < s.length()) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int repeat = 0;
                while (Character.isDigit(ch)) {
                    repeat = repeat * 10 + (ch - '0');
                    ch = s.charAt(++i);
                }
                repeatStack.push(repeat);
            } else if (ch == '[') {
                resultStack.push(result);
                result = "";
                i++;
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int repeat = repeatStack.pop();
                for (int j = 0; j < repeat; j++) {
                    temp.append(result);
                }
                result = temp.toString();
                i++;
            } else {
                result = result + ch;
                i++;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        String input = "3[a2[c]]";
        System.out.println("The decoded string is : " + decodeString(input));
    }
}
