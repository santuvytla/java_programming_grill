package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class smallestteam {
    /*
    In a project, you have a list of required skills req_skills, and a list of people.  The i-th person people[i] contains a list of skills that person has.

Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill.  We can represent these teams by the index of each person: for example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].

Return any sufficient team of the smallest possible size, represented by the index of each person.

You may return the answer in any order.  It is guaranteed an answer exists.



Example 1:

Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]
     */
    public static void main(String[] args) {
        String reqskills[]={"java","nodejs","reactjs"};
        List<List<String>> people = new ArrayList<>();
        List<String> a=new ArrayList<>();
        List<String> b=new ArrayList<>();
        List<String> c=new ArrayList<>();
        a.add("java");
        b.add("nodejs");
        c.add("nodejs");
        c.add("reactjs");
        people.add(a);
        people.add(b);
        people.add(c);
        int arr[]=smallest(reqskills,people);
        for(int g:arr)
        {
            System.out.print(g+" ");
        }
    }

    private static int[] smallest(String[] reqskills, List<List<String>> people) {
        Map<String,Integer> map=createskillmap(reqskills);
        int[] peopleskills=createpeopleskill(people,map);
        return calculateteam(map,peopleskills).stream().mapToInt(i -> i).toArray();

    }

    private static List<Integer> calculateteam(Map<String, Integer> map, int[] peopleskills) {
        int n=peopleskills.length;
        int m=1<<map.size();
        List<List<Integer>> dp=new ArrayList<>(Collections.nCopies(m,null));
        dp.set(0,new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            int value=peopleskills[i];
            if(dp.get(value)==null||dp.get(value).size()>1)
            {
                dp.set(value,Arrays.asList(i));

            }
            for(int j=0;j<m;j++)
            {
                int cur=j|value;
                List<Integer> prev=dp.get(j);
                if(prev!=null&&(dp.get(cur)==null||prev.size()+1<dp.get(cur).size()))
                {
                    dp.set(cur,new ArrayList<>(prev));
                    dp.get(cur).add(i);
                }
            }
        }
        return dp.get(m-1);
    }
    private static int[] createpeopleskill(List<List<String>> people, Map<String, Integer> map) {
        int[] peopleskills=new int[people.size()];
        for(int i=0;i<people.size();i++)
        {
            int value=0;
            for(String skill:people.get(i))
            {
                value |=1<<map.get(skill);
            }
            peopleskills[i]=value;
        }
        return peopleskills;
    }

    private static Map<String, Integer> createskillmap(String[] reqskills) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i< reqskills.length;i++)
        {
            map.put(reqskills[i],i);
        }
        return map;
    }
}
