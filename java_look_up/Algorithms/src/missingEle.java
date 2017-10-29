/**
 * Created by sridharyadav on 12/26/15.
 */
public class missingEle{
    public int print(int a[]){
        int result = a[0];
        for(int i = 1; i < a.length; i++){
            result = result ^ a[i];
        }
        return result;
    }
     public static void main(String args[]){
        missingEle a = new missingEle();
        int s[] = {7, 7, 5, 4, 5, 3, 4};
        System.out.print(a.print(s));
     }
}
