import java.util.*;
class RemoveRepChar
{
    public static void removeRep(String str) {
        String result = "" + str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                result = result + str.charAt(i);
            }
        }
        System.out.println(result);
    }
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any word: "); // Inputting the word
        String s = scan.nextLine();
        removeRep(s); // Printing the result
    }
}