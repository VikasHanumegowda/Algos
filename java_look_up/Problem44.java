/**
 * Created by sridharyadav on 10/11/17.
 */
//The count-and-say sequence is the sequence of integers beginning as follows:
//        1, 11, 21, 1211, 111221, ...
//
//        1 is read off as "one 1" or 11.
//        11 is read off as "two 1s" or 21.
//        21 is read off as "one 2, then one 1" or 1211.
public class Problem44 {
    public static String countAndSay(int n) {
        int i = 1;
        String result = "1";
        while (i < n) {
            int count = 1;
            StringBuffer sb = new StringBuffer();
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j - 1) == result.charAt(j)) {
                    count++;
                } else {
                    sb.append(String.valueOf(count));
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(String.valueOf(count));
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result.toString();
    }

    public static void main(String args[]) {
        System.out.println(countAndSay(3));
    }
}
