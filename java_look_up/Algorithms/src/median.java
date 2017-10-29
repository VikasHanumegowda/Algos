/**
 * Created by sridharyadav on 12/30/15.
 */
import java.io.*;
import java.util.*;

public class median {

    PriorityQueue<Double> max = new PriorityQueue<>(10,Collections.reverseOrder());
    PriorityQueue<Double> min = new PriorityQueue<>();
    void insert(double val){
        if(val < max.peek()){
            insertMax(val);
        }
        else{
            insertMin(val);
        }
    }
    void insertMax(double val){
        max.add(val);
        if(max.size() > min.size() + 1) {
           double x = max.poll();
            insertMin(x);
        }
    }
    void insertMin(double val){
        min.add(val);
        if(min.size() > max.size()) {
            double x = min.poll();
            insertMax(x);
        }
    }

    void printMedian(int i){
        double res = max.peek();
        if(min.peek() != null && i%2==0)
         res = (max.peek() + min.peek())/2;
        System.out.printf("%.1f\n", res);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        median h = new median();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int n = Integer.parseInt(br.readLine());
            for(int i = 1; i <= n; i++){
                double val = (double)Integer.parseInt(br.readLine());
                    if(i == 1){
                        h.max.add(val);
                    }
                else {
                        h.insert(val);
                    }
                    h.printMedian(i);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
