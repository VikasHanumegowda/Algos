/**
 * Created by sridharyadav on 12/22/15.
 */
import java.util.*;
public class TwoSum {
    public static void main(String args[]){
        int a[] = {1, 3 , 8, 5, 7, 6};
        int x = 10;
        /*HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < a.length; i++){
            if(set.contains(x-a[i]))
            {
                System.out.println("The two numbers are: " + a[i] + " and " + (x-a[i]));
            }
            set.add(a[i]);
        }*/

        int start = 0, end = a.length -1;
        while(start < end)
        {
            if(x == (a[start]+a[end]))
            {
                System.out.print(a[start] + " "+ a[end]);
                break;
            }
            else if( x < a[start]+a[end])
            {
                --end;
            }
            else
                start++;
        }
    }
    }