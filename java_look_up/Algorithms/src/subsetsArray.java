/**
 * Created by sridharyadav on 2/3/16.
 */
import java.util.*;
public class subsetsArray {
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> list, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (list.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        } else {
            allsubsets = getSubsets(list, index + 1);
            int item = list.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> set : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(set);
                newsubset.add(item);
                Collections.sort(newsubset);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<ArrayList<Integer>> result = getSubsets(list, 0);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size() > o2.size()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(result.toString());
    }
}
