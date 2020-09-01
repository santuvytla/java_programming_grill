package com.company;

public class maxscorewords {
    /*
    Given a list of words, list of  single letters (might be repeating) and score of every character.

Return the maximum score of any valid set of words formed by using the given letters (words[i] cannot be used two or more times).

It is not necessary to use all characters in letters and each letter can only be used once. Score of letters 'a', 'b', 'c', ... ,'z' is given by score[0], score[1], ... , score[25] respectively.



Example 1:

Input: words = ["dog","cat","dad","good"], letters = ["a","a","c","d","d","d","g","o","o"], score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0]
Output: 23
Explanation:
Score  a=1, c=9, d=5, g=3, o=2
Given letters, we can form the words "dad" (5+1+5) and "good" (3+2+2+5) with a score of 23.
Words "dad" and "dog" only get a score of 21.
     */
    public static void main(String[] args) {
        String[] words={"dog","cat","dad","good"};
        char[] letters={'a','a','c','d','d','d','g','o','o'};
        int score[]={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int k=maxscore(words,letters,score);
        System.out.print(k);

    }

    private static int maxscore(String[] words, char[] letters, int[] score) {

        int[] count = new int[26];
        for (int i = 0; i < letters.length; i++) {
            count[letters[i] - 'a']++;
        }
        int res = dfs(words, count, score, 0);//maximum scroe we can get start from words[0];
        return res;
    }

    private static int dfs(String[] words, int[] count, int[] score, int index) {
        if(index==words.length)
            return 0;
        int sum1=0;
        boolean isvalid=true;
        String w = words[index];
        for (int i = 0; i < w.length(); i++) {
            count[w.charAt(i) - 'a']--;
            if (count[w.charAt(i) - 'a'] < 0) isvalid = false;
            sum1 += score[w.charAt(i) - 'a'];
        }
        if(isvalid)
        {
            sum1+=dfs(words,count,score,index+1);
        }
        else {
            sum1=0;
        }
        for (int i = 0; i < w.length(); i++) {
            count[w.charAt(i) - 'a']++;
        }

        //Do not using words[index]:
        int sum2 = dfs(words, count, score, index + 1);
        return Math.max(sum1,sum2);


    }
}
