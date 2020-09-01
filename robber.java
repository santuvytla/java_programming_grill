public class robber {
    /*
    pick alternate indexes values to get maximum value
    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     */

    public static void main(String[] args) {
        int nums[]={1,2,3, 1};
        if(nums.length==0)
        {
            System.out.println("0");
        }
        if(nums.length==1)
        {
            System.out.println(nums[0]);
        }
        int houses[]=new int[nums.length];
        houses[0]=nums[0];
        houses[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            houses[i]=Math.max(nums[i]+houses[i-2],houses[i-1]);
        }
        System.out.println(houses[nums.length-1]);
    }
}
