package com.company;

public class besttimebuy {
    public static void main(String[] args) {
        int prices[]={3,3,5,0,0,3,1,4};
        int k=maxprofit(prices);
        System.out.print(k);
    }

    private static int maxprofit(int[] prices) {
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        int temp=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            left[i]=Math.max(left[i-1],prices[i]-temp);
            temp=Math.min(temp,prices[i]);
        }
        temp=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--)
        {
            right[i]=Math.max(right[i+1],temp-prices[i]);
            temp=Math.max(temp,prices[i]);

        }
        temp=left[0]+right[0];
        for(int i=0;i<prices.length;i++)
        {
            temp=Math.max(temp,left[i]+right[i]);
        }
        return temp;
    }
}
