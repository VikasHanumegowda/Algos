/**
 * Created by sridharyadav on 1/5/16.
 */
public class subStringIndex {
    public static int findIndex(String s, String s1)
    {
        int i, j;
        for (i = 0; i<= s.length() - s1.length(); i++) {
            j = 0;
            while (j < s1.length() && s1.charAt(j) == s.charAt(i+j))
                j++;
            if (j == s1.length())
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abcedefg";
        String sub = "ef";
        System.out.println(findIndex(s,sub));
    }
}

