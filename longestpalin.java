package com.company;

public class longestpalin {
    public static void main(String[] args) {
        String a="babababsbaabd";
        String ans=longpalin(a);
        System.out.print(ans);
    }

    private static String longpalin(String a) {
        int best_len=0;
        String best="";
        int n=a.length();
        for(int mid=0;mid<n;mid++)
        {
        for(int x=0;mid-x>=0&&mid+x<n;x++)
            {
                if (a.charAt(mid-x)!=a.charAt(mid+x))
                {
                    break;
                }
                int len=2*x+1;
                if(len>best_len)
                {
                    best_len=len;
                    best=a.substring(mid-x,len);
                }
            }
        }
        for(int mid=0;mid<n-1;mid++)
        {
            for(int x=1;mid-x+1>=0&&mid+x<n;x++)
            {
                if (a.charAt(mid-x+1)!=a.charAt(mid+x))
                {
                    break;
                }
                int len=2*x;
                if(len>best_len)
                {
                    best_len=len;
                    best=a.substring(mid-x+1,len);
                }
            }
        }
        return best;
    }
}
