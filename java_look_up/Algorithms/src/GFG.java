import java.util.*;

/*Identifies an element which occurs exactly once and other occur an odd number of times*/
class GFG {

    public static int identityOccuringOnce(ArrayList<Integer> a){
        int ones=0, twos=0;
        for(int i=0;i<a.size();i++){
            ones = (ones ^ a.get(i)) & ~twos;
            twos = (twos ^ a.get(i)) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(82, 1, 1, 1));
        System.out.println(identityOccuringOnce(a));
    }

}