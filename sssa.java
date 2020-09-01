package com.company;

import java.util.Scanner;

public class sssa {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of first array:");
        int size1=in.nextInt();
        if(size1<=0) {
            System.out.println("Invalid array size");
            System.exit(0);
        }
        int array1[]=new int[size1];
        System.out.println("Enter elements for first array:" );
        for(int i=0;i<size1;i++) {
            array1[i]=in.nextInt();
        }

        System.out.println("Enter the size of second array:");
        int size2=in.nextInt();
        if(size1<=0) {
            System.out.println("Invalid array size");
            System.exit(0);
        }
        int array2[]=new int[size2];
        System.out.println("Enter elements for second array:" );
        for(int i=0;i<size2;i++) {
            array2[i]=in.nextInt();
        }

        int[] biggerArray=size1>size2 ? array1:array2;
        int[] smallerArray=size1<=size2 ? array1:array2;
        int[] summedArray=new int[biggerArray.length];
        System.arraycopy(biggerArray,0,summedArray,0,biggerArray.length);
        for(int i=0;i<smallerArray.length;i++)
        {
            summedArray[i]+=smallerArray[i];
        }
        for(int i=0;i<summedArray.length;i++)
        {
            System.out.println(summedArray[i]);
        }
        in.close();
    }
}



