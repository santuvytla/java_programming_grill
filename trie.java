package com.company;

public class trie {
    public static void main(String[] args) {
        int arr[]=new int[]{5, 6, 5, 5, 5, 5};
       int ans= findMaximumXOR(arr);
       System.out.println(ans);
    }
    private static class TreeNode {
        TreeNode left;
        TreeNode right;

        public TreeNode() {
            left = null;
            right = null;
        }
    }

    public static int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode();

        int max = 0;

        for (int num : nums) {
            TreeNode curr = root;    // pointer for current number
            TreeNode opposite = root; // pointer for candidate number which can create largest XOR result with current number
            int currMax = 0;

            for (int i = 0; i < 32; i++) {
                currMax = currMax << 1;

                if (((num >>> (31 - i)) & 1) == 0) {
                    if (curr.left == null) {
                        curr.left = new TreeNode();
                    }

                    if (opposite.right != null) {
                        opposite = opposite.right;
                        currMax = currMax | 1;
                    } else {
                        opposite = opposite.left;
                    }

                    curr = curr.left;
                }
                else {
                    if (curr.right == null) {
                        curr.right = new TreeNode();
                    }

                    if (opposite.left != null) {
                        opposite = opposite.left;
                        currMax = currMax | 1;
                    } else {
                        opposite = opposite.right;
                    }

                    curr = curr.right;
                }
            }

            max = Math.max(max, currMax);
        }

        return max;
    }
}
