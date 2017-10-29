/**
 * Created by sridharyadav on 10/12/17.
 */

/*
   Find the minimum distance between two numbers in an array.
 */
public class Problem46 {

    public static int minDistance(int candidates[], int a, int b) {
        int aIndex = -1, bIndex = -1, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == a) {
                aIndex = i;
            } else if (candidates[i] == b) {
                bIndex = i;
            }
            if (aIndex != -1 && bIndex != -1) {
                minDistance = Math.min(Math.abs(aIndex - bIndex), minDistance);
            }

        }
        return minDistance;
    }

    public static void main(String args[]) {
        int candidates[] = {3, 5, 4, 4, 6, 5, 6, 6, 5, 4, 8, 3};
        int a = 3, b = 6;
        System.out.println("The minimum distance between " + a + " and " + b + " is " + minDistance(candidates, a, b));
    }
}
