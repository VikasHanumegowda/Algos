import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sridharyadav on 1/1/16.
 */
public class sherlock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        int sum;
        for (int i = 0; i < cases; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            String str = scan.next();
            int len = str.length();
            for (int start1 = 0; start1 < len; start1++) {
                for (int start2 = start1 + 1; start2 <= len; start2++) {
                    String sub = str.substring(start1, start2);
                    char[] ch = sub.toCharArray();
                    Arrays.sort(ch);
                    sub = String.valueOf(ch);
                    if (!map.containsKey(sub)) {
                        map.put(sub, 1);
                    } else {
                        map.put(sub, map.get(sub) + 1);
                    }
                }
            }
            sum = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int n = entry.getValue();
                sum += (n * (n - 1)) / 2;
            }
            System.out.println(sum);
        }
    }
}