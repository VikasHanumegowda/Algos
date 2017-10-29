/**
 * Number of connected components in an undirected graph */
public class Problem89 {
    public static int countComponents(int n, int[][] edges) {
        int count = n;

        int[] root = new int[n];
        // initialize each node is an island
        for(int i=0; i<n; i++){
            root[i]=i;
        }

        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];

            int xRoot = getRoot(root, x);
            int yRoot = getRoot(root, y);

            if(xRoot!=yRoot){
                count--;
                root[xRoot]=yRoot;
            }

        }

        return count;
    }

    public static int getRoot(int[] arr, int i){
        while(arr[i]!=i){
            arr[i]= arr[arr[i]];
            i=arr[i];
        }
        return i;
    }
    public static void main(String args[]){
        int edges[][] = {{0,1},{1,2},{3,4},{0,2}};
        int n = 5;
        System.out.println("The number of connected components are : " + countComponents(n, edges));
    }
}
