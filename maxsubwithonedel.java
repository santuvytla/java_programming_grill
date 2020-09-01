public class maxsubwithonedel {
    /*
    Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

Note that the subarray needs to be non-empty after deleting one element.



Example 1:

Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
Example 2:

Input: arr = [1,-2,-2,3]
Output: 3
Explanation: We just choose [3] and it's the maximum sum.
     */
    public static void main(String[] args) {
        int arr[]={1,-2,0,3};
        int ele_with_dele=0;
        int ans=arr[0];
        int ele_without_del=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            ele_with_dele=Math.max(ele_with_dele+arr[i],ele_without_del);
            ele_without_del=Math.max(ele_without_del+arr[i],arr[i]);
            ans=Math.max(ans,ele_with_dele);
            ans=Math.max(ans,ele_without_del);
        }
        System.out.println(ans);
    }
}
