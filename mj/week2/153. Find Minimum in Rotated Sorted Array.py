from typing import List

class Solution:
    """
    [solution]
    Find Minimum in Rotated Sorted Array

    Approach: Binary Search
    1. Use binary search to find the rotation point
    2. The minimum element is at the rotation point
    3. Compare middle element with right element to decide which half to search

    Time Complexity: O(log n) where n is the length of array
    Space Complexity: O(1)

    Key insight:
    - If nums[mid] > nums[right], minimum is in right half
    - If nums[mid] < nums[right], minimum is in left half (including mid)
    - The array has no duplicates

    Example 1:
    nums = [3,4,5,1,2]
    Original: [1,2,3,4,5]
    Rotated at index 3
    Minimum: 1

    Example 2:
    nums = [4,5,6,7,0,1,2]
    Original: [0,1,2,4,5,6,7]
    Rotated at index 4
    Minimum: 0

    Example 3:
    nums = [11,13,15,17]
    No rotation (or rotated at index 0)
    Minimum: 11
    """

    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = left + (right - left) // 2

            # If mid element is greater than right element,
            # the minimum must be in the right half
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                # Otherwise, minimum is in left half (including mid)
                right = mid

        # When left == right, we found the minimum
        return nums[left]
