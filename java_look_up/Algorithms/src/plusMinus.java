import java.util.*;

public class plusMinus {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double pos = 0;
        double z = 0;
        double neg = 0;
        int size = scan.nextInt();
        for(int i =1; i <= size; i++){
            int x = scan.nextInt();
            if(x < 0)
                neg++;
            else if(x==0)
                z++;
            else
                pos++;
        }
        System.out.printf("%.6f\n%.6f\n%.6f", pos/size, neg/size, z/size);
    }
}