/**
 * Created by sridharyadav on 1/29/16.
 */
public class RemMultiSpaces {

    public static void main(String args[]){
        String s = "mehjldwd idifbwio       jdowfjowpfjpowf  qd qdqd    wfwfwf";
        System.out.println(s.replaceAll("\\s+", " "));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                }
            }
            result.append(c);
        }
        System.out.println(result.toString());
    }
}
