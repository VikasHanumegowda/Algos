import java.util.*;
public class palinIndex {

    public static boolean isPalin(String s, int start, int end){
        for(int i = start, j = end - 1; i < j; ++i, --j){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int m = 0; m < cases; m++){
            String s = scan.next();
            int n = s.length();
            int count = 0;
            for(int i = 0, j = n-1 ; i < j ; ++i, --j){
                if(s.charAt(i) != s.charAt(j)){
                    count += Math.abs(s.charAt(i) - s.charAt(j));
                   if(isPalin(s, i+1, j))
                    break;
                }
            }
            System.out.println(count);
        }
    }
}