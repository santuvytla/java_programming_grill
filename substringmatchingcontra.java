package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class substringmatchingcontra {
    /*
    Given a string s of lowercase letters, you need to find the maximum number of non-empty substrings of s that meet the following conditions:

The substrings do not overlap, that is for any two substrings s[i..j] and s[k..l], either j < k or i > l is true.
A substring that contains a certain character c must also contain all occurrences of c.
Find the maximum number of substrings that meet the above conditions. If there are multiple solutions with the same number of substrings, return the one with minimum total length. It can be shown that there exists a unique solution of minimum total length.

Notice that you can return the substrings in any order.



Example 1:

Input: s = "adefaddaccc"
Output: ["e","f","ccc"]
Explanation: The following are all the possible substrings that meet the conditions:
[
  "adefaddaccc"
  "adefadda",
  "ef",
  "e",
  "f",
  "ccc",
]
If we choose the first string, we cannot choose anything else and we'd get only 1. If we choose "adefadda", we are left with "ccc" which is the only one that doesn't overlap, thus obtaining 2 substrings. Notice also, that it's not optimal to choose "ef" since it can be split into two. Therefore, the optimal way is to choose ["e","f","ccc"] which gives us 3 substrings. No other solution of the same number of substrings exist.
Example 2:

Input: s = "abbaccd"
Output: ["d","bb","cc"]
Explanation: Notice that while the set of substrings ["d","abba","cc"] also has length 3, it's considered incorrect since it has larger total length.
     */
    public static void main(String[] args) {
        String s="abbaccd";
        int[] first = new int[26];
        Arrays.fill(first, s.length());
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }

        // make valid substrings starting from every index (record the ending index)
        int[] l = new int[s.length()];
        Arrays.fill(l, -1);

        for (int i = 0; i < s.length(); i++) {
            if (last[s.charAt(i) - 'a'] == -1) continue;
            if (first[s.charAt(i) - 'a'] != i) continue;

            int c = i;
            int max = last[s.charAt(c) - 'a'];
            while (true) {
                if (c == max) {
                    l[i] = max;
                    break;
                }
                c++;
                if (first[s.charAt(c) - 'a'] < i) break;
                max = Math.max(max, last[s.charAt(c) - 'a']);
            }
        }

        // find the minimum last index every time from the list.
        List<String> ans = new ArrayList<>();
        int start = 0;
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = start; i <= Math.min(min, s.length() - 1); i++) {
                if (l[i] != -1  && l[i] <= min) {
                    min = l[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) break;
            ans.add(s.substring(minIndex, l[minIndex] + 1));
            start = min + 1;
        }
        for(String b:ans)
        {
            System.out.print(b+" ");
        }

    }
}
