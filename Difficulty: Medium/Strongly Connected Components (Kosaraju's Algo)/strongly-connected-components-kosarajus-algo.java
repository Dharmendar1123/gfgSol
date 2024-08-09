//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public static void dfsTrav(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfsTrav(v, adj, visited);
            }
        }
    }
    
    public static void dfsTopo(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfsTopo(v, adj, visited, st);
            }
        }
        
        st.push(u);
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                dfsTopo(i, adj, visited, st);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        
        for (int i = 0; i < V; ++i) {
            adjRev.add(new ArrayList<>());
        }
        
        for (int u = 0; u < V; ++u) {
            
            for (int v : adj.get(u)) {
                adjRev.get(v).add(u);
            }
        }
        
        int countScc = 0;
        visited = new boolean[V];
        
        while (!st.isEmpty()) {
            int node = st.pop();
            
            if (!visited[node]) {
                dfsTrav(node, adjRev, visited);
                countScc++;
            }
        }
        
        return countScc;
    }
}
