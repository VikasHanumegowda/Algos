import java.util.HashSet;

/**
 * *
 * Return the minimum sum of unique numbers in the array.
 * If a number is repeated, then increase that number to the next unique number.
 * A number cannot be repeated more than once.
 */
public class Problem64 {
    public static int getMinimumUniqueSum(int array[]) {
        HashSet<Integer> set = new HashSet<>();
        int value;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            value = array[i];
            if (!set.contains(value)) {
                set.add(value);
                sum += value;
            } else {
                while (set.contains(value)) {
                    value++;
                }
                sum += value;
                set.add(value);
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        int array[] = {1, 2, 3, 4, 5, 2, 6};
        System.out.println(getMinimumUniqueSum(array));
    }
}
