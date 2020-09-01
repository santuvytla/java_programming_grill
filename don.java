package com.company;

import java.util.Scanner;
import java.lang.*;

public class don {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        int n=sc.nextInt();
     //   String ssa=sc.nextLine();
     //   ssa=ssa.replaceAll(":","");
      //  String arr[]=ssa.split(" ");
        String arr[]=new String[n];
        for(int i=0;i<n;i++)
        {
            String k=sc.next();
            k=k.replaceAll(":","");
            arr[i]=k;
        }
        int arr1[]=new int[n];

            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.valueOf(arr[i]);

        }

        for(int i=0;i<arr1.length;i++){
            if(arr1[i]>930)
            {
                count++;
            }
        }
        if(count>0){
            System.out.println(count+" employees are late");
        }
        else
        {
            System.out.println("All employees are on time");
        }





    }
}
