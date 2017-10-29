import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sridharyadav on 10/11/17.
 */
public class Problem40 {
    static int V = 4;

    public static boolean isBipartite(int G[][], int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int colors[] = new int[V];
        Arrays.fill(colors, -1);
        colors[src] = 1;
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (G[u][v] == 1 && colors[v] == -1) {
                    colors[v] = 1 - colors[u];
                    queue.add(v);
                } else if (G[u][v] == 1 && colors[v] == colors[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        if (isBipartite(G, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
