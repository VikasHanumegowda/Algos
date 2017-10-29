/**
 * Created by sridharyadav on 1/27/16.
 */
public class StringInterview {
    public static String reverse(String input){
        StringBuilder output = new StringBuilder(input);
        return output.reverse().toString();
    }
    public static void main(String args[]){
        String input = ";112&amp;;21&lt;192";
        StringBuilder output = new StringBuilder();
        String split[] = input.split("&");
        String operation = "";
        int pos = 0;
        for(int i = split.length - 1 ; i > 0; i--){
            pos = split[i].indexOf(";");
            operation = split[i].substring(0, pos+1);
            output.append(reverse(split[i].substring(pos+1)));
            output.append("&");
            output.append(operation);
        }
        output.append(reverse(split[0]));
        System.out.println(output.toString());
    }
}
