package com.company;

import java.util.Arrays;

public class bestbuy2 {
    /*
    prices array and max trans are given
     */
    public static void main(String[] args) {
        int prices[]={2,4,1};
        int s=2;
        int k=maxprofit(prices,s);
        System.out.print(k);
    }

    private static int maxprofit(int[] prices,int k) {
        int size=prices.length;
        int maxprofit=0;
        if(k>=size/2)
        {
            for(int i=1;i<size;i++)
            {
                maxprofit+=Math.max(0,prices[i]-prices[i-1]);
            }
            return maxprofit;
        }
        int hold[]=new int[k+1];
        int sold[]=new int[k+1];
        Arrays.fill(hold,Integer.MIN_VALUE/2);
        Arrays.fill(sold,Integer.MIN_VALUE/2);
        hold[0]=0;
        sold[0]=0;
        for(int i=0;i<size;i++)
        {
            int[] hold_old=hold.clone();
            int[] sold_old=sold.clone();
            for(int j=1;j<=k;j++)
            {
                hold[j]=Math.max(hold_old[j],sold_old[j-1]-prices[i]);
                sold[j]=Math.max(sold_old[j],hold_old[j]+prices[i]);
            }

        }
        for(int num:sold)
        {
            maxprofit=Math.max(maxprofit,num);
        }
        return maxprofit;

    }
}
