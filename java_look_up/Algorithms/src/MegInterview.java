/**
 * Created by sridharyadav on 1/19/16.
 */
import java.util.*;
public class MegInterview {
    public void print(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for(char ch : array) {
            if (!map.containsKey(ch))
                map.put(ch, 1);
            else
                map.put(ch, map.get(ch) + 1);
        }
        for(char ch : array){
            if(map.get(ch)==1){
                System.out.println(ch);
                return;
            }
        }
        }
    public static void main(String args[]){
        MegInterview m = new MegInterview();
        String s = "megheama";
        m.print(s);
    }
}
