import java.io.*;
/*
You are given two strings, A and B. Find if there is a substring that appears in both A and B.
2
hello
world
hi
world

YES
NO
 */
public class twoStrings {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cases = Integer.parseInt(br.readLine());
            for (int j = 1; j <= cases; j++) {
                boolean isMatch = false;
                String s1 = br.readLine();
                String s2 = br.readLine();
                int count1[] = new int[256];
                int count2[] = new int[256];
                for(int i = 0;i< s1.length();i++)
                {
                    int value = s1.charAt(i);
                    count1[value] = 1;
                }
                for(int i = 0;i< s2.length();i++)
                {
                    int value = s2.charAt(i);
                    count2[value] = 1;
                }
                for(int i= 0; i< 256;i++){
                    if(count1[i]!=0 && count1[i] == count2[i]) {
                        isMatch = true;
                        break;
                    }
                }
                if(isMatch)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
