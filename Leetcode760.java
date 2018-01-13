import java.util.Map;
import java.util.HashMap;
public class Leetcode760 {
	public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++)
            map.put(A[i],0);
        for(int i = 0; i < B.length; i++)
            map.put(B[i],i);
        int out[] = new int[A.length];
        
        for(int i = 0; i < A.length; i++)
            out[i] = map.get(A[i]);
        return out;
    }
	public static void main(String vikas[]) {
		int a[] = {12, 28, 46, 32, 50};
		int b[] = {50, 12, 32, 46, 28};
		for(int x : new Leetcode760().anagramMappings(a, b))
			System.out.print(x+" ");
	}
}
