/**
 * Created by sridharyadav on 12/30/15.
 */
    import java.io.*;
    import java.util.*;

    public class heap {

        PriorityQueue<Integer> pq = new PriorityQueue<>(10,Collections.reverseOrder());
        void insert(int val){
            pq.add(val);
        }
        void delete(int val){
            pq.remove(val);
        }
        /*void printKMax(int k) {
            for (int i = 1; i < k; i++) {
                pq.poll();
            }
            System.out.println(pq.poll());
        }*/

        public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            heap h = new heap();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int queries = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            for(int i =1; i<=queries; i++){
                int input = Integer.parseInt(br.readLine());
                    h.insert(input);
            }
                h.delete(k);
                h.insert(n);
            while(!h.pq.isEmpty()){
                System.out.println(h.pq.poll());
            }
                //h.printKMax(k);
        }
    }
