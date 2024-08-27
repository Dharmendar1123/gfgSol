//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        List<int[]>[] adj = new ArrayList[n+1];
        
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            
            adj[u].add(new int[] {v, cost});
        }
        
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {src, 0});
        
        int level = 0;
        
        while (!que.isEmpty() && level <= k) {
            int size = que.size();
            
            while (size-- > 0) {
                int[] top = que.poll();
                int u = top[0];
                int cost = top[1];

                for (int[] v : adj[u]) {
                    int node = v[0];
                    int ct = v[1];

                    if (cost + ct < result[node]) {
                        result[node] = cost + ct;
                        que.offer(new int[] {node, cost + ct});
                    }
                }
            }
            level++;
        }
        if (result[dst] == Integer.MAX_VALUE) {
            return -1;
        }else {
            return result[dst];
        }
    }
}