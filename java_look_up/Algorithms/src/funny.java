import java.io.*;

public class funny {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cases = Integer.parseInt(br.readLine());
            for (int j = 1; j <= cases; j++) {
                String s = br.readLine();
                String rev = "";
                boolean fun = true;
                for (int i = s.length() - 1; i >= 0; i--)
                    rev = rev + s.charAt(i);
                for (int i = 1; i < s.length(); i++) {
                    int v1 = s.charAt(i);
                    int v2 = s.charAt(i - 1);
                    int rv1 = rev.charAt(i);
                    int rv2 = rev.charAt(i - 1);
                    int a = Math.abs(v1 - v2);
                    int b = Math.abs(rv1 - rv2);
                    if (a != b) {
                        fun = false;
                        break;
                    }
                }
                if(!fun)
                    System.out.println("Not Funny");
                else
                    System.out.println("Funny");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}