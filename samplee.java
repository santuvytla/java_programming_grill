package com.company;

import java.util.*;

public class samplee {

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int s=sc.nextInt();
        HashMap<String,Integer> ss=new HashMap<String, Integer>();
        String arr[]=new String[s];
        int arr1[]=new int[s];
        for(int i=0;i<s;i++)
        {
            arr[i]=sc.next();

        }
        for(int i=0;i<s;i++)
        {
            arr1[i]=sc.nextInt();

        }
        for(int i=0;i<s;i++)
        {
            ss.put(arr[i],arr1[i]);

        }
        Map<String, Integer> hm1 = sortByValue(ss);

        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println(en.getKey());
        }
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println(en.getValue());
        }
    }
}
