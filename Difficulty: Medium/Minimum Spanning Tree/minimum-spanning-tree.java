//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int[] parent;
    static int[] rank;
    
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if (parentX == parentY) {
            return;
        }
        
        if (rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        }else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }
    
    static int kruskal(List<int[]> edges) {
        int sum = 0;
        
        for (int[] temp : edges) {
            int u = temp[0];
            int v = temp[1];
            int wt = temp[2];
            
            int parentU = find(u);
            int parentV = find(v);
            
            if (parentU != parentV) {
                union(u, v);
                sum += wt;
            }
        }
        
        return sum;
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; ++i) {
            parent[i] = i;
        }
        
        List<int[]> edges = new ArrayList<>();
        
        for (int u = 0; u < V; ++u) {
            for (int[] temp : adj.get(u)) {
                int v = temp[0];
                int wt = temp[1];
                
                edges.add(new int[] {u, v, wt});
            }
        }
        
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        
        return kruskal(edges);
    }
}