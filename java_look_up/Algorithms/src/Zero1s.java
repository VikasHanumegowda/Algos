import java.util.HashMap;

public class Zero1s {
    int[] array = {0, 0, 1, 1, 1, 0, 0, 0};

    private void evaluate(int[] array){

        HashMap<Integer,Integer> hash = new HashMap<>(array.length);

        int sum = 0, max = 0, maxs = 0, maxe = 0;
        hash.put(0,0);
        for(int i = 1; i <= array.length; i++){

            sum += (array[i-1] == 0 ? -1: 1);
            if(hash.containsKey(sum)) {
                if (max < i - hash.get(sum)){
                    max = i - hash.get(sum);
                    maxs = hash.get(sum);
                    maxe = i-1;
                }
            }
            else
                hash.put(sum,i);
        }

        if (max > 0)
            System.out.print(maxs + " to "+ maxe);
        else
            System.out.print("Not found");
    }
    public static void main(String args[]){
        Zero1s l = new Zero1s();
        l.evaluate(l.array);
    }
}