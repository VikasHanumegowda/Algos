/**
 * Created by sridharyadav on 12/18/15.
 */
public class isInteger {
    public static boolean isInteger(String str) {
        if ((str == null) || str.isEmpty())
            return false;
        int length = str.length();
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1)
                return false;
            else
                i = 1;
        }
            for( ; i < length; i++){
                if(str.charAt(i) < '0' || str.charAt(i) > '9')
                    return false;
            }
        return true;
    }
    public static void main(String[] args){
        String s ="8989";
        System.out.println(isInteger(s));
        try{
            Integer.parseInt(s);
            System.out.println(true);
        }
        catch(Exception e){
            System.out.println(false);
        }
    }
}


