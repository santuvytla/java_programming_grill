package com.company;
import java.util.*;
public class numbers {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the line ");
        String ss=sc.nextLine();
        int count=0;
        ss=ss.toLowerCase();
      //  String words[]=ss.split(" ");
        /*
        System.out.println("The duplicates are");
        for(int i=0;i<words.length;i++)
        {   count=1;
            for(int j=i+1;j<words.length;j++){
                if(words[i].contentEquals(words[j])){
                    count++;
                    words[j]="0";
                }



            }
            if(count>1&& words[i]!="0"){
                System.out.println(words[i]+ " ");
            }
        }
*/
        ArrayList<String> arrayList=new ArrayList<String>();

        String arr[]=ss.split(" ");
        for(int i=0;i<arr.length;i++) {
            arrayList.add(arr[i]);
        }
            Collections.sort(arrayList, Collections.reverseOrder());
                arrayList.forEach((str) -> System.out.print(str + " "));
               System.out.println("\n");
                for(String str: arrayList)
                System.out.print( str + " ");


    }
}
