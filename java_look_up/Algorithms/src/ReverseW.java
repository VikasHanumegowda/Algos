/**
 * Created by sridharyadav on 12/16/15.
 */
public class ReverseW {
    public static String reverseEach(String inputString) {
        StringBuilder sb = new StringBuilder();
        String[] array = inputString.split(" ");
        for(String s : array){
            sb.append(new StringBuffer(s).reverse());
            sb.append(' ');
        }
        return sb.toString();
    }
    public static String reverse(String s){
        if(s == null || s.length() <= 1)
            return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
    public static void main(String args[]){
        String s = "Hello World Sridhar";
        System.out.println(reverseEach(s));
        String s2 = "Hello";

        System.out.println(reverse(s2));
    }
}