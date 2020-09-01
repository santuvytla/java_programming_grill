package com.company;

public class maxdisttonarst {
    public static void main(String[] args) {
        int arr[]={1,0,0,0,1,0,1};
        int k=maxdistnearest(arr);
        System.out.println(k);
    }

    private static int maxdistnearest(int[] seats) {
        int m1=Integer.MIN_VALUE;
        int m2=Integer.MIN_VALUE;
        //scenario 1: 0 at beginning
        for(int i=0;i<seats.length;i++){
            if(i==0&&seats[i]==0){
                int j=i+1;
                while(seats[j]!=1){
                    j++;
                }
                m1=j-i;
            }
        }
        //scenario 2:0 is at end
        for(int i=seats.length-1;i>=0;i--)
        {
            if(i==seats.length-1&&seats[i]==0)
            {
                int j=i-1;
                while(seats[j]!=1)
                {
                    j--;
                }
                m2=i-j;
            }
        }
        //scenario 3:0 is at the middle
        int m=Integer.MIN_VALUE;
        int s=0,e=0;
        for(int i=0;i<seats.length-1;i++)
        {
            if(seats[i]==1)
            {
                s=i;
                e=i+1;
                while(seats[e]!=1&&e<seats.length-1)
                {
                    e++;
                }
                m=Math.max(m,(e-s)/2);
            }
        }
        int res=Math.max(m,Math.max(m1,m2));
    return res;
    }
}
