//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        int[][] maxSum = new int[N][N];
        int maxPath = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++){
                if(i==0) {
                    maxSum[i][j] = Matrix[i][j];
                } else if (i>0 && j==0) {
                    maxSum[i][j] = Matrix[i][j] + Math.max(maxSum[i-1][j],maxSum[i-1][j+1]);
                } else {
                    //maxSum[i][j] = Matrix[i][j] + Math.max(maxSum[i-1][j-1],Math.max(maxSum[i-1][j],maxSum[i][j-1]));
                    int max = Math.max(maxSum[i-1][j-1], maxSum[i-1][j]);
                    if(j+1 < N)
                        max = Math.max(max, maxSum[i-1][j+1]);
                    maxSum[i][j] = Matrix[i][j] +  max;
                }
                maxPath = Math.max(maxSum[i][j], maxPath);
            }
        }
        return maxPath;
    }
}