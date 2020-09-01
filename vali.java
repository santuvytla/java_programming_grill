package com.company;

import java.util.*;

public class vali {
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
        List<Integer> ans=findNumOfValidWords(words,puzzle);
        for(int i:ans)
        {
            System.out.print(i+" ");
        }
    }

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer>res=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
        for(String w:words){
            int code=encode(w);
            if(map.containsKey(code)){
                map.put(code,map.get(code)+1);
            }else{
                map.put(code,1);
            }
        }

        for(int i=0;i<puzzles.length;i++){
            int sum=0;
            String puzzle=puzzles[i];
            Set<Integer>set=new HashSet<>();
            List<Integer>list=new ArrayList<>();
            for(int k=0;k<puzzle.length();k++){
                set.add((puzzle.charAt(k)-'a'));
            }
            generate(new ArrayList<>(set),0,0,list);
            for(int n:list){
                if(map.containsKey(n)){
                    int first=puzzle.charAt(0)-'a';
                    first=1<<first;
                    if((n&first)!=0){
                        sum+=map.get(n);
                    }
                }
            }
            res.add(sum);
        }
        return res;
    }

    public static void generate(List<Integer>nums,int index,int n,List<Integer>list){
        if(index>=nums.size()){
            list.add(n);
            return;
        }
        int pos=nums.get(index);
        int copyn1=n;
        int copyn2=n;
        copyn1=copyn1|(1<<pos);
        generate(nums,index+1,copyn1,list);
        generate(nums,index+1,copyn2,list);
    }

    public static int encode(String s){
        int res=0;
        for(int i=0;i<s.length();i++){
            int pos=s.charAt(i)-'a';
            res=res|(1<<pos);
        }
        return res;
    }
}
