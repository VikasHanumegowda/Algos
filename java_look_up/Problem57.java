/**
 * Created by sridharyadav on 10/13/17.
 * Check if it is a number
 */
public class Problem57 {
    public static boolean isNumber(String num) {
        char ch = num.charAt(0);
        if ((ch < '0' || ch > '9') && ch != '.' && ch != '-') {
            return false;
        }
        boolean dot = false;
        if (ch == '.') {
            dot = true;
        }
        for (int i = 1; i < num.length(); i++) {
            ch = num.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch == '.' && !dot)) {
                if(ch == '.'){
                    dot = true;
                }
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "6.2";
        System.out.println(isNumber(num));
    }
}
