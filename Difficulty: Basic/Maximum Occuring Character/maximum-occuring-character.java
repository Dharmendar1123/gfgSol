//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        int[] occ = new int[26];
        for (char ch : line.toCharArray()) {
            occ[ch-97] += 1;
        }
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < 26; ++i) {
            if (occ[i] > max) {
                max = occ[i];
                result = i;
            }
        }
        return (char)(result+97);
    }
    
}