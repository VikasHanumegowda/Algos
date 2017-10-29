import java.util.Scanner;

public class primeFactor
{
    static void prime_factorization(long x)
    {
        long i, c;
        c = x;
        while(c % 2 == 0)
        {
            System.out.println(2);
            c /= 2;
        }
        i = 3;
        while(i <= Math.sqrt(c) + 1)
        {
            if(c % i == 0)
            {
                System.out.println(i);
                c /= i;
            }
            else
                i += 2;
        }
        if(c > 1)
            System.out.println(c);
    }

    public static void main(String[] args)
    {
        long p;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLong())
        {
            p = sc.nextLong();
            System.out.println("prime factorization of p = " + p + " is: ");
            prime_factorization(p);
        }
    }
}