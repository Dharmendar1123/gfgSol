//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    private boolean topologicalSort(int n, Map<Integer, List<Integer>> adj, int[] inDegree) {
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                que.offer(i);
                count++;
            }
        }
        
        while(!que.isEmpty()) {
            int u = que.poll();
            
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                inDegree[v]--;
                
                if (inDegree[v] == 0) {
                    que.offer(v);
                    count++;
                }
            }
        }
        
        return count == n ? true : false;
    }
    
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegree = new int[N];
        
        for (int[] row : prerequisites) {
            int a = row[0];
            int b = row[1];
            
            adj.computeIfAbsent(b, k ->  new ArrayList<>()).add(a);
            inDegree[a]++;
        }
        
        return topologicalSort(N, adj, inDegree);
    }
    
}