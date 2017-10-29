/**
 * Created by sridharyadav on 12/27/15.
 */
import java.io.*;
public class makeAnagram {

        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cases = Integer.parseInt(br.readLine());
            for (int j = 1; j <= cases; j++) {
            int count = -1;
            String s = br.readLine();
                int len = s.length();
            if(len%2!=0) {
                System.out.println(count);
                continue;
            }
                count = 0;
            String s1 = s.substring(0,len/2);
            String s2 = s.substring(len/2);
            int count1[] = new int[256];
            int count2[] = new int[256];
            for(int i = 0;i< s1.length();i++)
            {
                int value = s1.charAt(i);
                count1[value]++;
            }
            for(int i = 0;i< s2.length();i++)
            {
                int value = s2.charAt(i);
                count2[value]++;
            }
            for(int i= 0; i< 256;i++){
                if(count1[i]!=count2[i])
                count += Math.abs(count1[i]-count2[i]);
            }
            System.out.println(count/2);
        }
    }
            catch(Exception e){
                e.printStackTrace();
            }
        }
}
