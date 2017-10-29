import java.util.*;

/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width.
 * You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * The brick wall is represented by a list of rows.
 * Each row is a list of integers representing the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed.
 * You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall,
 * in which case the line will obviously cross no bricks.
 * <p>
 * Example:
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 */
public class Problem101 {
    public static int leastBricks(List<List<Integer>> wall) {
        int maxWidth = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int width : row) {
                sum += width;
                maxWidth = Math.max(maxWidth, sum);
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }
        if(map.size() == 1){
            return wall.size();
        }
        map.remove(maxWidth);
        int maxEdgeBricks = 0;
        for (int i : map.values()) {
            maxEdgeBricks = Math.max(maxEdgeBricks, i);
        }
        return wall.size() - maxEdgeBricks;
    }

    public static void main(String args[]) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
//        row1.add(2);
//        row1.add(1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(2);
//        row2.add(1);
//        row2.add(2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(1);
//        row3.add(2);
//        List<Integer> row4 = new ArrayList<>();
//        row4.add(2);
//        row4.add(4);
//        List<Integer> row5 = new ArrayList<>();
//        row5.add(3);
//        row5.add(1);
//        row5.add(2);
//        List<Integer> row6 = new ArrayList<>();
//        row6.add(1);
//        row6.add(3);
//        row6.add(1);
//        row6.add(1);
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(row1);
        wall.add(row2);
        wall.add(row3);
//        wall.add(row4);
//        wall.add(row5);
//        wall.add(row6);
        System.out.println("The least number of bricks required are : " + leastBricks(wall));

    }
}
