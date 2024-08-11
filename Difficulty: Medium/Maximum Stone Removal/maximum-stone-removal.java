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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public static int find(int x, int[] parent) {
        if (parent[x] == -1) {
            return x;
        }
        
        return parent[x] = find(parent[x], parent);
    }
    
    public static void union(int x, int y, int[] parent, int[] rank) {
        
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

    int maxRemove(int[][] stones, int n) {
        // Code here
        int[] parent = new int[20005];
        int[] rank = new int[20005];
        
        Arrays.fill(parent, -1);
        
        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10001, parent, rank);
        }
        
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(find(stone[0], parent));
        }
        
        return stones.length - set.size();
    }
};
