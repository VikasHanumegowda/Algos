import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sridharyadav on 12/21/15.
 */

public class stringPermutation {

    StringBuilder swap(StringBuilder str,int l,int r){
        char templ = str.charAt(l);
        char tempr = str.charAt(r);
        str.setCharAt(l,tempr);
        str.setCharAt(r,templ);
        return str;
    }

    void permute(StringBuilder str,int l){
        if(l==(str.length()-1)){
            System.out.println(str);
        }
        else{
            for(int i = l;i < str.length();i++){
                swap(str,l,i);
                permute(str,l+1);
                swap(str,l,i);
            }
        }
    }

    /*String insertAt(String word, char ch, int i)
    {
        return word.substring(0,i) + ch + word.substring(i);
    }
    ArrayList<String> permute(String str){
        if(str == null)
            return null;
        ArrayList<String> perm = new ArrayList<>();
        if(str.isEmpty())
        {
            perm.add(str);
            return perm;
        }
        char first = str.charAt(0);
        ArrayList<String> rest = permute(str.substring(1));
        for(String word : rest){
            for(int j = 0; j <= word.length(); j++){
                String s = insertAt(word, first, j);
                if(!perm.contains(s))
                    perm.add(s);
            }
        }
        return perm;
    }*/

    public static void main(String args[]){
        String st = "abc";
        stringPermutation m = new stringPermutation();
        StringBuilder str = new StringBuilder(st);
        m.permute(str,0);
        //System.out.print((m.permute(st)).toString());
    }
}