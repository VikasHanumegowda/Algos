import java.util.*;
/*Shashank likes strings in which consecutive characters are different.
 For example, he likes ABABA, while he doesn't like ABAA.
Given a string containing characters A and B only, he wants to change it into a string he likes.
 To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions. */

public class alternating{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++){
            int count = 0;
            String s = scan.next();
            for(int j = 1; j < s.length(); j++){
                if(s.charAt(j-1) == s.charAt(j)){
                    count++;
                }
            }
        System.out.println(count);
        }
    }
}