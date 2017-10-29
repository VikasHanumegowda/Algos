/**
 * Created by sridharyadav on 12/16/15.
 */
public class RemoveSpaces {
    public static String insertAt(String s, int i){
        return s.substring(0,i) + ' ' + s.substring(i);
    }
    public static String removeSpace(String inputString) {
        inputString = inputString.replace(" ", "");
        for( int i = 5; i < inputString.length(); i = i + 6){
            inputString = insertAt(inputString, i);
        }
        return inputString;
    }
    public static void main(String args[]){
        String s = "Hello Wor ld Sr id h armeg";
        System.out.print(removeSpace(s));
    }
}