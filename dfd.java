package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class dfd {
    public static void totaldis(double[][] arr1,String[] arr){
        DecimalFormat dd=new DecimalFormat("0.##");
        dd.setRoundingMode(RoundingMode.DOWN);
        for(int j=0;j<4;j++) {
            double total=0;

            for (int i = 0; i < 7; i++) {
                total+=arr1[j][i];

            }
            System.out.println(arr[j]+" "+dd.format(total)+" kms");
        }
    }
    public static void averdis(double[][] arr1)
    {
        DecimalFormat dd=new DecimalFormat("0.00");

        for(int j=0;j<7;j++) {
            double total1=0;

            for (int i = 0; i < 4; i++) {
                total1+=arr1[i][j];

            }
            double avg=total1;
            System.out.println("Day"+(j+1)+":"+dd.format(avg/4)+" kms");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String arr[]={"David","Charles","Antony","Leo"};
        double arr1[][]=new double[4][7];
        for(int j=0;j<4;j++) {


            for (int i = 0; i < 7; i++) {
                arr1[j][i] = sc.nextDouble();
            }

        }
        System.out.println("Total Distance covered by each participant:");
        totaldis(arr1,arr);
        System.out.println("Average distance covered on each day:");
        averdis(arr1);
    }
}
