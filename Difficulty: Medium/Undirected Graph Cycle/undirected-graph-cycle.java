//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    
    private boolean bfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {u, -1});
        visited[u] = true;
        
        while (!que.isEmpty()) {
            int[] top = que.poll();
            
            int src = top[0];
            int parent = top[1];
            
            for (int v : adj.get(src)) {
                if (visited[v] == false) {
                    que.offer(new int[] {v, src});
                    visited[v] = true;
                }else if (v != parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; ++i) {
            if (!visited[i] && bfs(i, adj, visited)) {
                return true;
            }
        }
        return false;
    }
}