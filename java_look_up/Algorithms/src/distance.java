/**
 * Created by sridharyadav on 12/22/15.
 */
public class distance {
    int minDistance(int arr[], int a,int b){
        int aIndex = -1, bIndex = -1;
        int minD = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(a == arr[i])
            aIndex = i;
            if(b == arr[i])
                bIndex = i;
            if(aIndex != -1 && bIndex != -1 && minD > Math.abs(aIndex - bIndex))
                minD = Math.abs(aIndex - bIndex);
        }
        return minD;
    }
    public static void main(String args[]){
        distance c = new distance();
        int candidates[] = {3, 5, 4, 4, 6, 5, 6, 6, 5, 4, 8, 3};
        int a = 3, b = 6;
        System.out.println("The minimum distance between " + a +" and " + b + " is "+ c.minDistance(candidates, a, b));
    }
}