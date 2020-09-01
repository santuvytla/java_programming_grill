package com.company;

import java.util.Scanner;

public class evod {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char c[]=s.toCharArray();
        int k[]=new int[c.length];
        for(int i=0;i<c.length;i++){
            k[i]=Integer.parseInt(String.valueOf(c[i]));
        }
        int evensum=0;
        int oddsum=0;
        for(int i=0;i<k.length;i+=2){
            oddsum+=k[i];
        }
        for(int i=1;i<k.length;i+=2){
            evensum+=k[i];
        }

        System.out.println("even sum is:"+evensum);
        System.out.println("odd sum is:"+oddsum);

    }

}
