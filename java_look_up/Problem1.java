/**
 * Created by sridharyadav on 9/19/17.
 */

// Return maximum occurring character in an input string
public class Problem1 {
    public static Character findMaxOccurChar(String input){
        int charCount[] = new int[256];
        for (int i = 0; i < input.length(); i++){
            charCount[input.charAt(i)]++;
        }
        int maxCount = charCount[0];
        char maxOccurChar = (char) 0;
        for(int i = 1; i < 256; i++){
            if(charCount[i] > maxCount){
                maxCount = charCount[i];
                maxOccurChar = (char) i;
            }
        }
        return maxOccurChar;
    }
    public static void main(String args[]) {
        String input = "sridhar";
        System.out.println("The maximum occurring character is : " + findMaxOccurChar(input));
    }
}