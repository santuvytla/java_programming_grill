package com.company;

public class selc {
    public static void main(String[] args) {
        int arr[]={2,4,3,4};
        int q=0;
        if(arr.length==0)
        {
            System.out.print("No elements");

        }
        for(int i=0;i<arr.length-1;i++)
        {
            int min=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[min])
                {
                    min=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
            q++;
        }
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println("Exchanges are "+q);
    }
}
