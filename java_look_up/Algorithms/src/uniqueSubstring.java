/**
 * Created by sridharyadav on 2/8/16.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class uniqueSubstring {
    public static void main(String args[])
    {
        String string, sub;
        int i, c, length;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string to print it's all substrings");
        string  = in.nextLine();

        length = string.length();

        HashMap<String, Integer> map = new HashMap<>();

        for( c = 0 ; c <= length-3 ; c++ )
        {
            //for( i = 1 ; i <= length - c ; i++ )
            //{
                sub = string.substring(c, c+3);
            if(!map.containsKey(sub)){
                map.put(sub, 1);
            }
            else{
                map.put(sub, map.get(sub)+1);
            }
        }
        System.out.println("KEY" + "  " + "VALUE");
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}