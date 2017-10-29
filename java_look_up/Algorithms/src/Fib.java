/**
 * Created by sridharyadav on 2/3/16.
 */
public class Fib {
    public static int fibArray[]=new int[26];

    public static int fibonacci(int n){
        if(n==1 ){
            return 0;
        }else if(n==2){
            return 1;
        }else if(fibArray[n]!=0){
            return fibArray[n];
        }else{
            fibArray[n]=fibonacci(n-1)+fibonacci(n-2);
            return fibArray[n];
        }
    }

    public static void main(String args[]){
        fibArray[0]=1;
        fibArray[1]=1;
        System.out.println("Value of 6th number in Fibonacci series->"+fibonacci(6));
    }
}
