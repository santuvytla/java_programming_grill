package com.company;

public class and {
    public static void main(String[] args) {
        int m=5;
        int n=7;
        int k=anding(m,n);
        System.out.println(k);
    }

    private static int anding(int m, int n) {
        if(m==0 || n/m>=2)
            return 0;
        if(m==n)
            return m;

        int result=m;
        for(int i=m+1; i<=n; i++)
        {
            result&=i;
            if(i==n)
                break;

        }
        return result;
    }
}
