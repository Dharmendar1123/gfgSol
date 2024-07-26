//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    private boolean dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inRec) {
        visited[u] = true;
        inRec[u] = true;
        
        for (int v : adj.get(u)) {
            if (visited[v] == false && dfs(v, adj, visited, inRec)) {
                return true;
            }else if (inRec[v] == true) {
                return true;
            }
        }
        
        inRec[u] = false;
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] inRec = new boolean[V];
        
        for (int i = 0; i < V; ++i) {
            if (!visited[i] && dfs(i, adj, visited, inRec)) {
                return true;
            }
        }
        return false;
    }
}