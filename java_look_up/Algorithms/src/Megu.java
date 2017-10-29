import java.util.*;

/**
 * Created by sridharyadav on 12/26/15.
 */
public class Megu {
    static public int print(String word){
        List<Character> x = new ArrayList<Character>();
        x.add('!');
        x.add('?');
        x.add('-');
        for(char ch : x){
            if(word.indexOf(ch)!= -1){
                word = word.replace(String.valueOf(ch), "");
            }
        }
        String[] split = word.split(" ");
        HashSet<String> set = new HashSet<>();
        for(String w : split){
            if(!set.contains(w)){
                set.add(w);
            }
        }
        return set.size();
    }

    public static void main(String args[]){
        System.out.println(print("Hello!! S???wfwfw hdhhd--bfbfb"));
    }
}
