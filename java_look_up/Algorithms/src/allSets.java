/**
 * Created by sridharyadav on 12/25/15.
 */
//Print all possible sets
import java.util.ArrayList;
public class allSets {
    public static void main(String args[]){
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        ArrayList<ArrayList<Integer>> all = printSets(set, 0);
        System.out.print(all.toString());
    }
    public static ArrayList<ArrayList<Integer>> printSets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> all;
        if(set.size() == index){
            all = new ArrayList<ArrayList<Integer>>();
            all.add(new ArrayList<Integer>());
        }
        else{
            all = printSets(set,index + 1);
            int val = set.get(index);
            ArrayList<ArrayList<Integer>> more =new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> s : all){
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.addAll(s);
                sub.add(val);
                more.add(sub);
            }
            all.addAll(more);
        }
        return all;
    }
}
