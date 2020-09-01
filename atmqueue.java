package com.company;

import java.util.Scanner;

public class atmqueue {

        public static void main(String args[] ) throws Exception {

            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int max1=0,ans=1;
            int arr[]=new int[n];
            if(n>0&&n<=1000000)
            {
                int maxHeight = -1;
                int currentManHeight = -1;
                int group = 0;
                for(int i=0; i<n; i++) {
                    currentManHeight = sc.nextInt();

                    if(currentManHeight < maxHeight) {
                        maxHeight = -1;
                    }

                    if(maxHeight == -1) {
                        group++;
                    }

                    maxHeight = currentManHeight;
                }
                System.out.println(group);
            }
            else
            {
                System.exit(0);
            }
        }
}
