/**
 * Created by sridharyadav on 12/30/15.
 */
import java.io.*;
import java.util.*;

public class pizza {
    PriorityQueue<item> min1;
    PriorityQueue<item> min2;
    long clock = 0;
    long waiting = 0;

    class item{
        long arrival;
        long cooking;
        item(long arrival, long cooking){
            this.arrival = arrival;
            this.cooking = cooking;
        }
    }

    class Cmpr1 implements Comparator<item> {
        public int compare(item a, item b) {
            if(a.arrival < b.arrival ){
                return -1;
            }
            else {
                return 1;
            }
        }
    }
    class Cmpr2 implements Comparator<item> {
        public int compare(item a, item b) {

            if(a.cooking < b.cooking) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }

    pizza(int capacity){
        Cmpr1 cmp1 = new Cmpr1();
        Cmpr2 cmp2 = new Cmpr2();
        min1 = new PriorityQueue<>(capacity,cmp1);
        min2 = new PriorityQueue<>(capacity,cmp2);
    }

    void insert(long arrival, long cooking){
        item i = new item(arrival,cooking);
        min1.add(i);
    }

    void findAverage(int n){
        clock = min1.peek().arrival;
        min2.add(min1.poll());
        while(!min1.isEmpty() || !min2.isEmpty()) {
            if(!min1.isEmpty()) {
                item temp = min1.peek();
                if (temp.arrival <= clock) {
                    min2.add(min1.poll());
                    continue;
                }
            }
            while (!min2.isEmpty()) {
                item temp2 = min2.poll();
                waiting += clock + temp2.cooking - temp2.arrival;
                clock += temp2.cooking;
            }
            if(!min1.isEmpty()){
                if(clock < min1.peek().arrival)
                    clock = min1.peek().arrival;
            }
        }
        System.out.println(waiting/n);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(br.readLine());
            pizza h = new pizza(n);
            for(long i = 1; i <= n; i++){
                String input = br.readLine();
                String[] arr = input.split(" ");
                long arrival = Integer.parseInt(arr[0]);
                long cooking = Integer.parseInt(arr[1]);
                h.insert(arrival, cooking);
            }
            h.findAverage(n);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}