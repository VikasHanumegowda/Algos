/**
 * Created by sridharyadav on 2/5/16.
 */
public class Interleaving {
    public static String interleaving(){
        String s1 ="abcd";
        String s2 = "xyz";
        String s3 = "axybcz";
        if(s1.length() + s2.length() != s3.length())
            return "NO";
        int i = 0, j = 0, k = 0;
        while( i < s1.length() || j < s2.length()){
            if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
                i++;
                k++;
            }
            else if(j < s2.length() &&s2.charAt(j) == s3.charAt(k)){
                j++;
                k++;
            }
            else{
                return "NO";
            }
        }
        if(i + j == s3.length())
        return "YES";
        return "NO";
    }
    public static void main(String args[]){
        System.out.println(interleaving());
    }
}
