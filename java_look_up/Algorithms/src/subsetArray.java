import java.util.HashMap;
import java.util.Map;

public class subsetArray {
    int[] a = {11, 1, 13, 21, 3, 3, 7};
    int[] b = {11, 1, 13, 21, 3, 3, 7};

    private void evaluate(int[] a, int[] b){

        HashMap<Integer,Integer> hash = new HashMap(a.length);
        boolean has = true;
        for(Integer i : a){
            if(!hash.containsKey(i))
                hash.put(i, 1);
            else
                hash.put(i, hash.get(i)+1);
        }
        for(Integer i: b){
            if(hash.containsKey(i)) {
                if (hash.get(i) == 0) {
                    has = false;
                    break;
                } else {
                    hash.put(i, hash.get(i) - 1);
                }
            }
            else{
                has = false;
                break;
            }
        }
        if (!has) {
            System.out.print("They are not same sets.");
            return;
        }
            for(Map.Entry<Integer,Integer> entry : hash.entrySet()){
                if(entry.getValue() != 0){
                    System.out.println("They are not same sets");
                    return;
                }
            }
            System.out.print("They are same sets");
    }
    public static void main(String args[]){
       subsetArray l = new subsetArray();
        l.evaluate(l.a, l.b);
    }
}