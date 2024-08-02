//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] connections = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.minimumConnections(n,connections);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    private static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x], parent);
    }
    
    private static void union (int x, int y, int[] parent, int[] rank) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        
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
    
    public static int minimumConnections(int n, int[][] connections) {
        // code here
        if (connections.length < n-1) {
            return -1;
        }
        
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        
        int connection = n;
        for (int[] row : connections) {
            if (find(row[0], parent) != find(row[1], parent)) {
                union(row[0], row[1], parent, rank);
                connection--;
            }
        }
        return connection - 1;
    }
}
        
