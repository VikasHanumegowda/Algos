import java.util.*;

public class Solution {

    static class Duplet{
        int data;
        int repeat;
        Duplet(int d, int r){
            data = d;
            repeat = r;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt();
        int M = scan.nextInt();
        long size = 0;
        ArrayList<Duplet> a = new ArrayList<Duplet>();
        for (int i = 0; i < M; i++) {
            int n = scan.nextInt();
            int x = scan.nextInt();
            size = size + x;
            a.add(new Duplet(n, x));
        }
        Collections.sort(a, new Comparator<Duplet>() {
            public int compare(Duplet obj1, Duplet obj2) {

                if (obj1.data > obj2.data)
                    return 1;
                else
                    return -1;

            }
        });
        for(int i=1; i < Q; i++){
            int sum = 0;
            double data = size * i;
            Double d = Math.ceil(data/Q);
            int index = d.intValue();
            int m;
            int pos = 0;
            for(m = 0; m < a.size(); m++){
                sum += a.get(m).repeat;
                if(sum < index) {
                    pos = m + 1;
                }
                else{
                    break;
                }
            }
            System.out.println(a.get(pos).data);
        }
    }
}