package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class exx {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=1;i<=n;i++)
        {
            arr[i-1]=i;
        }
        List<List<Integer>> ans=permuteUnique(arr);
        System.out.print(ans.get(k-1));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        Arrays.sort(nums);
        boolean[] used= new boolean[nums.length];
        List<Integer> permutation = new ArrayList<Integer>();
        helper(used, nums, permutation, res);
        return res;
    }
    private static void helper(boolean[] used, int[] nums, List<Integer> permutation, List<List<Integer>> res) {
        if(permutation.size()==nums.length)
        {
            res.add(new ArrayList<Integer>(permutation));
            return;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(used[i]) continue;
            used[i]=true;
            permutation.add(nums[i]);
            helper(used, nums, permutation, res);
            permutation.remove(permutation.size()-1);
            used[i]=false;
            /*Removing duplicates*/
            while(i+1<nums.length && nums[i]==nums[i+1]) ++i;
        }
    }
}