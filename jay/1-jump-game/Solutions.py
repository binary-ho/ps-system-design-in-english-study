from typing import List

class Solution:
    """
    [solution]
    Jump Game - Can we reach the last index?

    Approach 1: Greedy
    - Keep track of the maximum reachable position
    - If current index is beyond max reachable, return False
    - Update max reachable at each step

    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0

        for i in range(len(nums)):
            if i > max_reach:
                return False

            max_reach = max(max_reach, i + nums[i])

            if max_reach >= len(nums) - 1:
                return True

        return True
