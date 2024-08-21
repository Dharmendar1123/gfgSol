//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int s = Integer.parseInt(S[2]);
            int d = Integer.parseInt(S[3]);
            int[][] edges = new int[m][2];
            for (int i = 0; i < m; i++) {
                String[] S1 = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(S1[0]);
                edges[i][1] = Integer.parseInt(S1[1]);
            }
            Solution obj = new Solution();
            int ans = obj.possible_paths(edges, n, s, d);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    private void solve(int s, int d, Map<Integer, List<Integer>> adj, int[] result ) {
        
        if (s == d) {
            result[0]++;
        }
        
        for (int v : adj.getOrDefault(s, new ArrayList<>())) {
            solve(v, d, adj, result);
        }
        
    }
        
    public int possible_paths(int[][] edges, int n, int start, int destination) {
        // Code here
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        
        int[] result = new int[1];
        
        solve(start, destination, adj, result);
        
        return result[0];
    }
}