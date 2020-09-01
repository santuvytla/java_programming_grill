package com.company;

import java.util.Scanner;

class sampl1 {

    static int factorial(int n)
    {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact= fact* i;
        }
        return fact;
    }

    static int sumFactorial(int arr[], int n)
    {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]>0 && arr[i]<10) {
                sum += factorial(arr[i]);
            }
            else {
                continue;
            }
        }
        if(sum==0)
        {
            System.out.println("this is not valid");
            System.exit(0);
        }
        return sum;
    }

    public static void main(String[] args)
    {
// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size=in.nextInt();
        System.out.println("Enter the array elements:");
        int a[]=new int[size];
        for(int i=0;i<size;i++) {
            a[i]=in.nextInt();
        }
        System.out.print("Sum = ");
        System.out.println(sumFactorial(a, size));
        in.close();

    }
}
