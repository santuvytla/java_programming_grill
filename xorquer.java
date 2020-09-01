package com.company;

public class xorquer {
    public static void main(String[] args) {
        int arr[]={1,3,4,8};
        int queries[][]={{0,1},{1,2},{0,3},{3,3},{0,1},{1,2},{0,3},{3,3}};
        int k[]=xorQueries(arr,queries);
        for(int i=0;i<k.length;i++)
        System.out.println(k[i]);
    }
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length+1];
        prefix[0]=0;
        for( int i = 0 ; i < arr.length;i++)
        {

            prefix[i+1]=prefix[i]^ arr[i];
        }
        int[] ans = new int[queries.length];
        for( int i = 0 ; i < ans.length;i++)
        {
            int ss =queries[i][0];
            int ee = queries[i][1];

            ans[i] = prefix[ee+1]^prefix[ss];
        }
        return ans;
    }
}
