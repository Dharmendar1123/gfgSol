//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    private static int[] parent;
    private static int[] rank;
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        }else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
    
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        parent = new int[V];
        rank = new int[V];
        
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for (int u = 0; u < V; ++u) {
            for (int v : adj.get(u)) {
                if (u < v) {
                    if (find(u) == find(v)) {
                        return 1;
                    }else {
                        union(u, v);
                    }
                }
            }
        }
        return 0;
    }
}