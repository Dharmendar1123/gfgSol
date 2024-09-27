//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void computeLPS(String pat, int[] lps, int m) {
        
        int len = 0;
        lps[0] = 0;
        
        int i = 1;
        
        while (i < m) {
            
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else {
                if (len != 0) {
                    len = lps[len - 1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int n = txt.length();
        int m = pat.length();
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int[] lps = new int[m];
        computeLPS(pat, lps, m);
        
        int i = 0;
        int j = 0;
        
        while (i < n) {
            
            if (j < m && txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            
            if (j == m) {
                result.add(i - j + 1);
                j = lps[j - 1];
            }else if (i < n && (j == 0 || txt.charAt(i) != pat.charAt(j))) {
                if (j != 0) {
                    j = lps[j - 1];
                }else {
                    i++;
                }
            }
        }
        
        return result;
    }
}