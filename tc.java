package com.company;

import java.util.Scanner;

public class tc {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l=10,p=0;
        int x=0,y=0;
        for (int i = 1; i <= 4; i++,l=l+10) {

            switch (i){
                case 1: x+=l;
                        p++;
                        break;
                case 2: y+=l;
                        p++;
                        break;
                case 3:x-=l;
                        p++;
                        break;
                case 4:y-=l;
                        p++;
                        i=0;
                        break;

            }
            if(p==n){
                System.out.println(x +" "+y);
                break;
            }

        }

    }
}
