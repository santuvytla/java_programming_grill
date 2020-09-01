package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class dna {
    /*
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA,
    it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     */
    public static void main(String[] args) {
        String s="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> k=dnaseq(s);
        for(int i=0;i<k.size();i++)
        {
            System.out.print(k.get(i)+" ");
        }
    }
    private static List<String> dnaseq(String s) {
        List<String> list=new ArrayList();
        Set<String> hashSet=new HashSet();
        if(s==null||s.length()<10)
            return list;
        for(int i=0;i<=s.length()-10;i++)
        {
            if(!hashSet.add(s.substring(i,i+10))&&!list.contains(s.substring(i,i+10)))
                list.add(s.substring(i,i+10));
        }
        return list;
    }
}
