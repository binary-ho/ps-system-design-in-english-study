from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    [solution]
    Convert Sorted Array to Binary Search Tree

    Approach: Divide and Conquer (Recursive)
    1. Find the middle element of array as root
    2. Recursively build left subtree from left half
    3. Recursively build right subtree from right half
    4. This ensures the tree is height-balanced

    Time Complexity: O(n) where n is the length of array
    Space Complexity: O(log n) for recursion stack (tree height)

    Key insight:
    - Sorted array + middle element as root = balanced BST
    - Each recursive call creates a balanced subtree
    - In-order traversal of result gives original sorted array

    Example:
    nums = [-10,-3,0,5,9]

    Step 1: Middle element = 0 (index 2)
    Step 2: Left half = [-10,-3] -> recursively build
           Right half = [5,9] -> recursively build

    Resulting tree:
         0
        / \
      -3   9
      /   /
    -10  5

    This tree is height-balanced:
    - Left subtree height: 2
    - Right subtree height: 2
    - Difference: 0 (balanced)
    """

    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if not nums:
            return None

        return self.helper(nums, 0, len(nums) - 1)

    def helper(self, nums: List[int], left: int, right: int) -> Optional[TreeNode]:
        # Base case: invalid range
        if left > right:
            return None

        # Find middle element
        mid = left + (right - left) // 2

        # Create root with middle element
        root = TreeNode(nums[mid])

        # Recursively build left and right subtrees
        root.left = self.helper(nums, left, mid - 1)
        root.right = self.helper(nums, mid + 1, right)

        return root
