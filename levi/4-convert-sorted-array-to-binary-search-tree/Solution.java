import java.util.*;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     [solution]
     Convert Sorted Array to Binary Search Tree

     Approach: Divide and Conquer (Recursive)
     1. Find the middle element of the array as root
     2. Recursively build left subtree from left half
     3. Recursively build right subtree from right half
     4. This ensures the tree is height-balanced

     Time Complexity: O(n) where n is the length of array
     Space Complexity: O(log n) for recursion stack

     Example:
     nums = [-10,-3,0,5,9]
     Middle = 0 (index 2)
     Left subtree: [-10,-3]
     Right subtree: [5,9]
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}
