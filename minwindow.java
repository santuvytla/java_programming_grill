package com.company;

import java.util.HashMap;
import java.util.Map;

public class minwindow {
    /*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
     */
    public static void main(String[] args) {
        String S="ADOBECODEBANC";
        String T="ABC";
        String ans=minimum(S,T);
        System.out.println(ans);
    }

    private static String minimum(String s, String t) {
        if(s == "" || s.length() < t.length())
            return "";

        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();

        String ans = "";
        for(char c : t.toCharArray())
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        int start = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        sMap.put(s.charAt(index),1);
        while(start <= (s.length()-t.length())) {
            boolean foundMatch = false;
            if(isMatch(tMap,sMap)){
                if((index-start) < min){
                    min = index - start;
                    ans = s.substring(start,index+1);
                }
                foundMatch = true;
            }
            if(foundMatch || index == s.length()-1)
                sMap.put(s.charAt(start),sMap.get(s.charAt(start++))-1);
            else
                sMap.put(s.charAt(++index),sMap.getOrDefault(s.charAt(index),0)+1);

        }
        return ans;

}

    private static boolean isMatch(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {

        for(Map.Entry<Character,Integer> entry:tMap.entrySet())
        {
            if(!(sMap.containsKey(entry.getKey()) && sMap.get(entry.getKey()) >= entry.getValue()))
                return false;
        }
        return true;

        }
    }
