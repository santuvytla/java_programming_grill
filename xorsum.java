package com.company;

public class xorsum {
    public static void main(String[] args) {
        int a=0,b=1;
        int n=5;
        String s=Long.toBinaryString(n);
        int j=s.length();
        for(int i=1;i<j;i++)
        {
            b=b*2;
            if(s.charAt(i)=='1')
                a=a*2+1;
            else
                a=a*2;

        }
        System.out.print(a+" "+b);

    }
}
