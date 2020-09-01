package com.company;

public class sexyp {

    public static void main(String[] args) {
            int n=1000,k = 0;
            int arr[]=new int[n];
            for(int i=2;i<n;i++)
            {   int count=0;
                for(int j=2;j<i;j++){
                    if((i%j)==0){
                        count++;
                    }

                }
                if(count==0){
                    arr[k]=i;
                    k++;
                }
            }
            int limit=0,flag=0;
            for(int i=0;i<arr.length-1;i++){
                for (int j=i+1;j<arr.length;j++)
                {
                    if(arr[j]-arr[i]==6){
                        System.out.println("("+arr[i]+","+arr[j]+")");
                        limit++;

                    }
                    if(limit==5)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==1){
                    break;
                }

            }

    }
}

