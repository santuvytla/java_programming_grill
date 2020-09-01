package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class sasss {
    public static int[] menFromBoys(final int[] values) {


        int k=0;
        Set<Integer> s=new HashSet<Integer>();
        for(int i=0;i<values.length;i++)
        {
            s.add(values[i]);
        }
        int values1[]=new int[s.size()];
       for(int i:s)
       {
           values1[k]=i;
           k++;
       }
        Arrays.sort(values1);
        int arr[]=new int[values1.length];
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(values1[i]%2==0)
            {
                arr[j]=values1[i];
                j++;
            }
        }
        j=arr.length-1;
        for(int i=0;i<arr.length;i++)
        {
            if(!(values1[i]%2==0))
            {
                arr[j]=values1[i];
                j--;
            }
        }
        return arr ;
    }

    public static void main(String[] args) {
        int arr[]=new int[]{-32,-39,-35,-41,-41};
        int arr1[]=menFromBoys(arr);
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
    }
}
