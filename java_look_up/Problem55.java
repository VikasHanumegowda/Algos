import java.util.ArrayList;
import java.util.List;

/**
 * Created by sridharyadav on 10/13/17.
 * Find the intersection between two arrays
 */
public class Problem55 {
    public static ArrayList<Integer> intersect(List<Integer> A, List<Integer> B){
        ArrayList<Integer> resultList = new ArrayList<>();
        int lenA = A.size(), lenB = B.size();
        if(lenA == 0 || lenB == 0){
            return resultList;
        }
        int i = 0, j = 0;

        while(i < lenA && j < lenB){
            if(A.get(i) == B.get(j)){
                resultList.add(A.get(i));
                i++;
                j++;
            }
            else if(A.get(i) < B.get(j)){
                i++;
            }
            else{
                j++;
            }
        }
        return resultList;
    }
    public static void main(String args[]) {
        final List<Integer> A = new ArrayList<>();
        final List<Integer> B = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(4);
        A.add(5);
        B.add(3);
        B.add(3);
        B.add(5);
        System.out.println(intersect(A, B));
    }
}
