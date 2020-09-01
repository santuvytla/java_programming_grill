package com.company;

import java.util.*;

public class least {

    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str=in.nextLine();
        char arr[]=str.toCharArray();
        HashMap<Character,Integer> hm=new HashMap<Character, Integer>();
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
        Map<Character, Integer> hm1 = sortByValue(hm);
        int min=Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> sm:hm1.entrySet())
        {
            if(sm.getValue()<=min){
                min=sm.getValue();
                System.out.println(sm.getKey());
            }
        }


    }
}
