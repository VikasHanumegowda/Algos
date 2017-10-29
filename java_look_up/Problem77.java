//http://www.geeksforgeeks.org/the-celebrity-problem/
public class Problem77 {

    // Person with 2 is celebrity
    static int MATRIX[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    // Returns true if a knows b, false otherwise
    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }

    public static int findCelebrity(int n) {
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (knows(a, b)) {
                a++;
            } else {
                b--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != a && (knows(a, i) || !knows(i, a))) {
                return -1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " + result);
    }
}
