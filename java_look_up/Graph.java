import java.util.*;

/**
 * Created by sridharyadav on 10/23/17.
 */
public class Graph {
    private int V;
    private LinkedList<Integer> adjacencyList[];

    Graph(int v) {
        this.V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            Iterator iterator = adjacencyList[vertex].listIterator();
            while (iterator.hasNext()) {
                int i = (int) iterator.next();
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public boolean isBipartite(int s){
        int colors[] = new int[V];
        Arrays.fill(colors, -1);
        colors[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            int u = queue.poll();
            for(int v = 0; v < V; v++){
                if(adjacencyList[u].contains(v) && colors[v] == -1){
                    colors[v] = 1 - colors[u];
                }
                else if(adjacencyList[u].contains(v) && colors[u] == colors[v]){
                    return false;
                }
            }
        }
        return true;
    }

    public void DFS(int s) {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        stack.push(s);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");
            }
            Iterator iterator = adjacencyList[vertex].listIterator();
            while (iterator.hasNext()) {
                int i = (int) iterator.next();
                if (!visited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack){
        visited[v] = true;
        Iterator iterator = adjacencyList[v].listIterator();
        while(iterator.hasNext()){
            int i = (int)iterator.next();
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }

    public void TopologicalSort(){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2) : ");

        g.BFS(2);
        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2) : ");

        g.DFS(2);

        System.out.println(g.isBipartite(0));
        g.TopologicalSort();
    }
}
