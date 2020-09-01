package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class das {

    public static void main(String[] args) {
// TODO Auto-generated method stub

        Scanner in = new Scanner(System.in);

        String ss=in.nextLine();
        char arr[]= ss.toCharArray();

        Map<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char key = arr[i];
            if (hm.containsKey(key)) {
                int frequency = hm.get(key);
                frequency++;
                hm.put(key, frequency);
            } else {
                hm.put(key, 1);
            }
        }
        int max_count=Integer.MAX_VALUE;

        char mode[]=new char[ss.length()];
                int i=0;
        for(Map.Entry<Character,Integer> val : hm.entrySet()) {
            if(max_count >= val.getValue()) {
                max_count = val.getValue();

            }
        }
        for(Map.Entry<Character,Integer> val : hm.entrySet()) {
            if(max_count == val.getValue()) {
                mode[i]=val.getKey();
                i++;
            }
        }
        for(int j=0;j<mode.length;j++){
            System.out.println(mode[j]);

        }

    }

}
