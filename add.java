package com.company;
import java.util.*;


public class add {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the encrypted text:");
        String ss = sc.nextLine();
        int j = 0;
        char arr[] = ss.toCharArray();
        char aar1[] = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (Character.isAlphabetic(arr[i])) {
                int s = (int) arr[i];
                int m = s - 7;
                if(m>=65&&m<90||m>=97&&m<122) {


                    arr[i] = (char) m;

                    aar1[j] = arr[i];
                    j++;
                }
                else{
                    if(m<=64){
                        int l=65-m;
                        m=91-l;
                        arr[i] = (char) m;

                        aar1[j] = arr[i];
                        j++;
                    }
                    else {
                        int l=97-m;
                        m=123-l;
                        arr[i] = (char) m;

                        aar1[j] = arr[i];
                        j++;
                    }
                }
            } else if (arr[i] == ' ') {
                aar1[j] = arr[i];
                j++;
            } else {
                continue;
            }

        }
        System.out.print("Decrypted text:\n");
        for (int i = 0; i < aar1.length; i++) {
            System.out.print(aar1[i]);
        }
    }
}
