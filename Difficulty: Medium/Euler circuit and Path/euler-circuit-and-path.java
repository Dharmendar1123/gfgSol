//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        
        while (tc-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            
            List<Integer>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            // String x=scanner.nextLine();
            // scanner.nextLine();
            
            Solution obj = new Solution();
            int ans = obj.isEulerCircuit(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{
    
    public static void dfs(List<Integer>[] adj, int u, boolean[] visited) {
        visited[u] = true;
        
        for (int i = 0; i < adj[u].size(); ++i) {
            int nbr = adj[u].get(i);
            if (!visited[nbr]) {
                dfs(adj, nbr, visited);
            }
        }
    }
    
    public static boolean isConnected(int v, List<Integer>[] adj) {
        
        int nonZeroDegreeVertex = -1;
        
        for (int i = 0; i < v; ++i) {
            if (adj[i].size() != 0) {
                nonZeroDegreeVertex = i;
                break;
            }
        }
        
        boolean[] visited = new boolean[v];
        dfs(adj, nonZeroDegreeVertex, visited);
        
        for(int i = 0; i < v; ++i) {
            if (visited[i] == false && adj[i].size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    public int isEulerCircuit(int V, List<Integer>[] adj) 
    {
        // code here
        if (isConnected(V, adj) == false) {
            return 0;
        }
        
        int oddCount = 0;
        for (int i = 0; i < V; ++i) {
            if (adj[i].size() % 2 != 0) {
                oddCount++;
            }
        }
        
        if (oddCount > 2) {
            return 0;
        }
        
        if (oddCount == 2) {
            return 1;
        }
        
        return 2;
    }
}