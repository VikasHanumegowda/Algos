import java.util.ArrayList;

/**
 * Created by sridharyadav on 12/25/15.
 */
public class Paranthesis {
    ArrayList<String> printAll(int count){
        char[] str = new char[count*2];
        ArrayList<String> perm = new ArrayList<String>();
        print(perm, count, count, str, 0);
        return perm;
    }
    void print(ArrayList<String> perm, int l, int r, char[] str, int count){
        if(l < 0 || r < l)
            return;
        if(l == 0 && r==0){
            String s = String.copyValueOf(str);
            perm.add(s);
            return;
        }
        if(l > 0){
            str[count] = '(';
            print(perm, l-1, r, str, count + 1);
        }
        if (r > 0) {
            str[count] = ')';
            print(perm, l, r - 1, str, count + 1);
        }
    }
    public static void main(String args[]){
        Paranthesis p = new Paranthesis();
        System.out.print(p.printAll(3).toString());
    }
}
