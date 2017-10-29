import java.util.Collections;
import java.util.PriorityQueue;

/**
 * K closest points to origin
 */
public class Problem90 {
    public static class Point implements Comparable<Point> {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance() {
            return (x * x) + (y * y);
        }

        @Override
        public int compareTo(Point point) {
            int c = Double.compare(getDistance(), point.getDistance());
            if (c == 0) {
                c = Double.compare(x, point.x);
            }
            if (c == 0) {
                c = Double.compare(y, point.y);
            }
            return c;
        }

        public void printPoint() {
            System.out.println("X : " + x + " Y : " + y);
        }
    }

    public static Point[] findKClosestPoints(double array[][], int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            Point point = new Point(array[i][0], array[i][1]);
            if (pq.size() < k) {
                pq.offer(point);
            } else if (pq.peek().getDistance() > point.getDistance()) {
                pq.poll();
                pq.offer(point);
            }
        }
        return pq.toArray(new Point[k]);
    }

    public static void main(String args[]) {
        double array[][] = {{1, 4}, {1, 2}, {1, 3}, {1, 1}};
        int k = 2;
        Point[] points = findKClosestPoints(array, k);
        for(Point point : points){
            point.printPoint();
        }
    }
}
