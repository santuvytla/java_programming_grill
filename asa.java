package com.company;

import java.util.*;
class asa{
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number");
        int s=sc.nextInt();
        if(s==8888)
        {
            System.out.println("Invalid Input");
        }
        else
        {
            String temp=Integer.toString(s);
            int arr[]=new int[temp.length()];
            for(int i=0;i<arr.length;i++)
            {

                arr[i]=temp.charAt(i)-'0';
            }
            int j=0;
            while(arr[j]==8||arr[j]==0)
            {
                arr[j]=11;
                j++;
            }
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==11){
                    continue;
                }
                else{

                    if(arr[i]>0){


                        if(arr[i]==9){
                            arr[i]=1;
                        }
                        else if(arr[i]==8){
                            arr[i]=0;
                        }
                        else{
                            arr[i]+=2;
                        }


                    }
                    else{
                        System.out.println("Invalid Input");
                        System.exit(0);
                    }
                }
            }
            System.out.print("The second number is: ");
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]!=11)
                {
                    System.out.print(arr[i]);
                }
            }

        }

    }


}
