import java.io.*;
import java.util.*;

public class Pangram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine().toLowerCase().replaceAll(" ", "");
            char[] cArray = s.toCharArray();
            Set set = new HashSet();
            for(char ch : cArray){
                int value = ch;
                if(value >=97 && value<=122)
                    set.add(ch);
            }
            if(set.size() == 26){
                System.out.println("pangram");
            }
            else{
                System.out.println("not pangram");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}