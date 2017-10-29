import java.io.*;
import java.util.*;
/**
 * Created by sridharyadav on 12/27/15.
 */
public class rocks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int rocks = Integer.parseInt(br.readLine());
            Map<Character,Integer> map = new HashMap<>();
            boolean array[] = new boolean[26];
            for (int j = 1; j <= rocks; j++) {
                for (int i = 0; i < 26; i++) {
                    array[i] = false;
                }
                String s = br.readLine();
                char[] cArray = s.toCharArray();
                if (j == 1) {
                    for (char ch : cArray) {
                        if (!map.containsKey(ch))
                            map.put(ch, 1);
                    }
                    continue;
                }
                    for (char ch : cArray) {
                        int tmp = ch - 'a';
                        if (map.containsKey(ch) && !array[tmp])
                            map.put(ch, map.get(ch) + 1);
                            array[tmp] = true;
                        }
                    }

            int count = 0;
            for(Map.Entry<Character,Integer> entry : map.entrySet()){
                if(entry.getValue()==rocks)
                    count++;
            }
            System.out.print(count);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
