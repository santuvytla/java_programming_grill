package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class uniqueperm {
    public static void main(String[] args) {
        int arr[]={1,1,2};
        List<List<Integer>> res=permutateunique(arr);
        System.out.print(res);
    }

    private static List<List<Integer>> permutateunique(int[] nums) {
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        if(nums.length==0||nums==null)
        {
            return res;
        }
        Arrays.sort(nums);
        boolean used[]=new boolean[nums.length];
        List<Integer> per=new ArrayList<>();
        helper(used,nums,per,res);
        return res;

    }

    private static void helper(boolean[] used, int[] nums, List<Integer> per, List<List<Integer>> res) {
        if(per.size()==nums.length)
        {
            res.add(new ArrayList<>(per));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i])
                continue;
            used[i]=true;
            per.add(nums[i]);
            helper(used,nums,per,res);
            per.remove(per.size()-1);
            used[i]=false;
            while (i+1<nums.length&&nums[i]==nums[i+1])
            {
                i++;
            }
        }

    }
}
