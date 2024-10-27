import java.util.ArrayList;
import java.util.Stack;

public class ad_graph {
    static ArrayList<Integer>[]lists;
    private static void dfs(int node, int []vis, Stack<Integer> st) {
        vis[node] = 1;
        for (Integer it : lists[node]) {
            if (vis[it] == 0) {
                dfs(it, vis, st);
            }
        }
        st.push(node);
    }
    private static void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer it : adjT.get(node)){
            if (vis[it] == 0) {
                dfs3(it, vis, adjT);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public static int kosaraj(int V) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 1; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis,  st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 1; i < V; i++) {
            vis[i] = 0;
            for (Integer it : lists[i]) {
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }
}
