import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sridharyadav on 10/8/17.
 */

//Kth smallest element in a row-wise and column-wise sorted 2D array | Set 1
//Given an n x n matrix, where every row and column is sorted in non-decreasing order.
// Find the kth smallest element in the given 2D array.
//
//        For example, consider the following 2D array.
//
//        10, 20, 30, 40
//        15, 25, 35, 45
//        24, 29, 37, 48
//        32, 33, 39, 50
//        The 3rd smallest element is 20 and 7th smallest element is 30
public class Problem31 {

    static class Element {
        int val, row, column;

        Element(int val, int row, int column) {
            this.val = val;
            this.row = row;
            this.column = column;
        }
    }

    static PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
        @Override
        public int compare(Element e1, Element e2) {
            if(e1.val > e2.val){
                return 1;
            }
            if(e1.val < e2.val){
                return -1;
            }
            return 0;
        }
    });

    public static int kthSmallest(int matrix[][], int n, int k) {
        int i,small;
        for (i = 0; i < n; i++) {
            pq.add(new Element(matrix[0][i], 0, i));
        }
        int row, col;
        Element min = getMinimumElement();
        for (small = 1; small < k; small++) {
            row = min.row + 1;
            col = min.column;
            pq.add(new Element(matrix[row][col], row, col));
            min = getMinimumElement();
        }
        return min.val;
    }

    public static Element getMinimumElement() {
        return pq.poll();
    }

    public static void main(String args[]) {
        int matrix[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {25, 29, 37, 48},
                {32, 33, 39, 50},
        };
        System.out.println("7th smallest element is " + kthSmallest(matrix, 4, 7));
    }
}
