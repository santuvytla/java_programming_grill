package com.company;

import java.util.*;

public class validwordspuz {
    /*
    With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
word contains the first letter of puzzle.
For each letter in word, that letter is in puzzle.
For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage"; while invalid words are "beefed" (doesn't include "a") and "based" (includes "s" which isn't in the puzzle).
Return an array answer, where answer[i] is the number of words in the given word list words that are valid with respect to the puzzle puzzles[i].
Input:
words = ["aaaa","asas","able","ability","actt","actor","access"],
puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
Output: [1,1,3,2,4,0]
Explanation:
1 valid word for "aboveyz" : "aaaa"
1 valid word for "abrodyz" : "aaaa"
3 valid words for "abslute" : "aaaa", "asas", "able"
2 valid words for "absoryz" : "aaaa", "asas"
4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
There're no valid words for "gaswxyz" cause none of the words in the list contains letter 'g'.
     */
    public static void main(String[] args) {
        String words[]={"aaaa","asas","able","ability","actt","actor","access"};
        String puzzle[]={"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        List<Integer> ans=validwords(words,puzzle);
        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }

    private static List<Integer> validwords(String[] words, String[] puzzle) {
        List<Integer> ans=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(String word:words)
        {
            int code=encode(word);
            if(map.containsKey(code))
            {
                map.put(code,map.get(code)+1);
            }
            else
            {
                map.put(code,1);
            }
        }
        for(int i=0;i<puzzle.length;i++)
        {
            int sum=0;
            String puzz=puzzle[i];
            Set<Integer> s=new HashSet<>();
            List<Integer> a=new ArrayList<>();
            for(int j=0;j<puzz.length();j++)
            {
                s.add(puzz.charAt(j)-'a');
            }
            generate(new ArrayList<>(s),0,0,a);
            for(int n:a)
            {
                if(map.containsKey(n))
                {
                    int first=puzz.charAt(0)-'a';
                    first=1<<first;
                    if((n&first)!=0)
                    {
                        sum+=map.get(n);
                    }
                }
            }
            ans.add(sum);
        }
        return ans;
    }

    private static void generate(List<Integer> nums, int i, int i1, List<Integer> a) {
        if(i>=nums.size())
        {
            a.add(i1);
            return;
        }
        int pos=nums.get(i);
        int cp1=i1;
        int cp2=i1;
        cp1=cp1|(1<<pos);
        generate(nums,i+1,cp1,a);
        generate(nums,i+1,cp2,a);

    }

    private static int encode(String word) {
        int code=0;
        for(int i=0;i<word.length();i++)
        {
            int pos=word.charAt(i)-'a';
            code=code|(1<<pos);
        }
        return code;
    }
}
