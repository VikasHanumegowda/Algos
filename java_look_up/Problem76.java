/**
 * Rotate array by 90 degrees
 */
public class Problem76 {
    public static void printArray(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int array[][]) {
        int layers = array.length;
        for (int layer = 0; layer < layers / 2; layer++) {
            int first = layer;
            int last = layers - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - layer;
                int top = array[first][i];
                array[first][i] = array[last - offset][first];
                array[last - offset][first] = array[last][last-offset];
                array[last][last-offset] = array[i][last];
                array[i][last] = top;
            }
        }
        printArray(array);
    }

    public static void main(String args[]) {
        int array[][] = {{1, 2}, {3, 4}};
        rotate(array);
    }
}
