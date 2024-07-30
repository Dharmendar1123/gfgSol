//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static void dfs(int u, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        visited[u] = true;
        
        for (int v = 0; v < n; ++v) {
            if (!visited[v] && adj.get(u).get(v) == 1) {
                dfs(v, visited, adj);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int n = adj.size();
        
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }
};