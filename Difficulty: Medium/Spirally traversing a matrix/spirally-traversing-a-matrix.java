//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        int m = matrix.length;
        int n = matrix[0].length;
        
        ArrayList<Integer> result = new ArrayList<>();
        if (m == 0) {
            return result;
        }
        int dir = 0;
        
        int top = 0;
        int down = m-1;
        int left = 0;
        int right = n-1;
        
        while (top <= down && left <= right) {
            
            if (dir == 0) {
                
                for (int i = left; i <= right; ++i) {
                    result.add(matrix[top][i]);
                }
                top++;
            }
            
            if (dir == 1) {
                
                for (int i = top; i <= down; ++i) {
                    result.add(matrix[i][right]);
                }
                right--;
            }
            
            if (dir == 2) {
                
                for (int i = right; i >= left; --i) {
                    result.add(matrix[down][i]);;
                }
                down--;
            }
            
            if (dir == 3) {
                
                for (int i = down; i >= top; --i) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
            
            dir = (dir + 1) % 4;
        }
        return result;
    }
}
