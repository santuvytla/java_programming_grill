package com.company;

import java.util.HashMap;

public class sam {
    /*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
     */
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        String ans=minwin(s,t);
        System.out.print(ans);
    }

    private static String minwin(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int totalFnd = t.length();
        String res = "";
        int len = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int numChar = map.get(c) - 1;
                map.put(c, numChar);

                if (numChar >= 0)
                    totalFnd--;
            }
            while (totalFnd == 0) {
                if (i - j + 1 < len) {
                    res = s.substring(j, i + 1);
                    len = i - j + 1;
                }

                char jChar = s.charAt(j);
                if (map.containsKey(jChar)) {
                    int numJChar = map.get(jChar) + 1;
                    map.put(jChar, numJChar);

                    if (numJChar > 0)
                        totalFnd++;
                }
                j++;

            }
        }
        return res;
    }
}
