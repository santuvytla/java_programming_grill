<<<<<<< HEAD
public class sample1 {
    public static void main(String args[])

    {

        A obj = new A();

        obj.cal(2, 3);

        System.out.println(obj.x + " " + obj.y);

    }
}
class A{

    public int x;

    protected int y;

    void cal(int a, int b){

        x =  a + 1;

        y =  b;

    }

}

=======
package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.TreeMap;

public class sample {

    public static void main(String[] args) {
// TODO Auto-generated method stub

        Scanner in=new Scanner(System.in);

        int size=in.nextInt();

        int a[]=new int[size];
        for(int i=0;i<size;i++) {
            a[i]=in.nextInt();
        }

        Map<Integer,Integer> hm= new HashMap<>();

        for(int i=0;i<size;i++) {
            int key=a[i];
            if(hm.containsKey(key)) {
                int frequency = hm.get(key);
                frequency++;
                hm.put(key,frequency);
            }
            else {
                hm.put(key,1);
            }
        }

        TreeMap<Integer, Integer> ss = new TreeMap<>();
        ss.putAll(hm);



        int max_count=0;
        int mode=-1;

        for(Entry<Integer,Integer>val : ss.entrySet()) {
            if(max_count <= val.getValue()) {
                mode=val.getKey();
                max_count = val.getValue();
            }
        }
        System.out.println("Maximum repeated element in the array = "+ mode);
        in.close();
    }

}
>>>>>>> 05653a978ece795f54bbd7ff0cebe589d97e8145
