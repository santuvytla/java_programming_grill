package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ggi {
    public static int countPassengers(ArrayList<int[]> stops) {
        //Code here!
        int result = 0;
        for(int i = 0; i < stops.size();i++) {
            result += stops.get(i)[0];
            result -= stops.get(i)[1];
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<int[]> ss=new ArrayList<int[]>();
        int a1[]={4,2};
        int a2[]={6,7};
        ss.add(0,a1);
        ss.add(1,a2);
        int k=countPassengers(ss);
        System.out.println(k);





    }
}
