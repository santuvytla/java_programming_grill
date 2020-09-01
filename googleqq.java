package com.company;

import java.util.HashMap;

public class googleqq {
    /*
    Given a string S, we can split S into 2 strings: S1 and S2. Return the number of ways S can be split such that the number of unique characters between S1 and S2 are the same.

Example 1:

Input: "aaaa"
Output: 3
Explanation: we can get a - aaa, aa - aa, aaa- a
Example 2:

Input: "bac"
Output: 0
     */
    public static void main(String[] args) {
        String s="aaaa";
        int k=uniquesets(s);
        System.out.println(k);
    }

    private static int uniquesets(String s) {
        /*
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        int ans = 0;
        for(char c : input.toCharArray()) right.put(c, right.getOrDefault(c, 0) + 1);  //n
        for(char c : input.toCharArray()) {                                                      //n -> n^2
            // Move character from right to left
            right.put(c, right.getOrDefault(c, 0) - 1);
            left.put(c, left.getOrDefault(c, 0) + 1);
            if(right.get(c) == 0) right.remove(c);
            // Compare unique characters
            if(right.keySet().equals(left.keySet())) ans++;
        }
        return ans;
         */
        if(s.length() < 2) return 0;
        int[] leftChar = new int[26];
        int[] rightChar = new int[26];
        //store frequency of each character of the input string in the right hash map
        for(char c : s.toCharArray()){
            rightChar[c-'a']++;
        }
        int count = 0;

        //check if the left split string and the right split string have the same number of unique characters
        for(char c : s.toCharArray()) {
            //add current character to left hash map and update the frequency of characters
            leftChar[c - 'a']++;
            //remove current character to left hash map and update the frequency of characters
            rightChar[c - 'a']--;

            boolean sameUniques = true;
            for(int i = 0; i < 26; i++){
                if((leftChar[i] != 0 && rightChar[i] == 0) || (leftChar[i] == 0 && rightChar[i] != 0)){
                    sameUniques = false;
                    break;
                }
            }
            if(sameUniques) count++;
        }
        return count;
    }
}
