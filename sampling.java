package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class sampling {

        public static void main(String args[] ) throws Exception {
            Scanner sc=new Scanner(System.in);
            int k=sc.nextInt();
            int arr[]=new int[k];
            int sum=0,orgsum=0,min1=Integer.MAX_VALUE;
            int arr1[]=new int[k];
            for(int i=0;i<k;i++)
            {
                arr[i]=sc.nextInt();
                orgsum+=arr[i];
            }
            Arrays.sort(arr);
            for(int i=arr.length-1;i>=0;i--)
            {
                for(int j=0;j<arr.length;j++)
                {
                    arr1[j]=arr[i];
                    sum+=arr1[j];
                }
                System.out.println(sum);
                if(sum>orgsum)
                {
                    min1=Math.min(min1,sum);
                }
                sum=0;
            }
            System.out.println(min1);

        }
    }


