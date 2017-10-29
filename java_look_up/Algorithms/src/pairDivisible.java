/**
 * Created by sridharyadav on 12/23/15.
 */
import java.util.*;
public class pairDivisible {
    public static void main(String args[]) {
        Map<Integer, Integer> hash = new HashMap<>();
        int a[] = {92, 75, 65, 48, 45, 35};
        int x = 10;
        for(Integer i : a) {
            int key = i % x;
            if(!hash.containsKey(key)){
                hash.put(key , 1);
            }
            else {
                hash.put(key, hash.get(key) + 1);
            }
        }
        for( int i = 0; i < a.length; i++){
            int rem = a[i] % x;
            if(rem*2 == x){
                if(hash.get(rem) % 2 != 0) {
                    System.out.print("false");
                    return;
                }

            }
            else if(hash.get(rem) != hash.get(x-rem) ){
                System.out.print("false");
                return;
            }
        }
        System.out.print("true");
    }
}